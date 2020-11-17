package org.aurora.layuiboot.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.DefaultSessionKey;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;
import org.aurora.layuiboot.enums.SystemStatusEnum;
import org.aurora.layuiboot.po.BaseAdminUser;
import org.aurora.layuiboot.response.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zhangjian
 * @date 2020/11/11 9:04
 */
public class KickoutSessionFilter extends AccessControlFilter {
    private static final Logger logger = LoggerFactory.getLogger(KickoutSessionFilter.class);

    private final static ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     * 踢出后到的地址
     */
    private String kickoutUrl;
    /**
     * 踢出之前登录的/之后登录的用户 默认false踢出之前登录的用户
     */
    private boolean kickoutAfter = false;
    /**
     * 同一个帐号最大会话数 默认1
     */
    private int maxSession = 1;
    private SessionManager sessionManager;
    private Cache<String, Deque<Serializable>> cache;

    public void setKickoutUrl(String kickoutUrl) {
        this.kickoutUrl = kickoutUrl;
    }

    public void setKickoutAfter(boolean kickoutAfter) {
        this.kickoutAfter = kickoutAfter;
    }

    public void setMaxSession(int maxSession) {
        this.maxSession = maxSession;
    }

    public void setSessionManager(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

//    /**
//     * 设置Cache的key的前缀
//     * @param cacheManager
//     */
//    public void setCacheManager(CacheManager cacheManager) {
//        //必须和ehcache缓存配置中的缓存name一致
//        this.cache = cacheManager.getCache("shiro-activeSessionCache");
//    }

    public void setCache(Cache<String, Deque<Serializable>> cache){
        this.cache = cache;
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        Subject subject = getSubject(servletRequest, servletResponse);
        // 没有登录授权 且没有记住我
        if (!subject.isAuthenticated() && !subject.isRemembered()) {
            // 如果没有登录，直接进行之后的流程
            return true;
        }
        // 获得用户请求的URI
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String path = req.getRequestURI();
        logger.info("===当前请求的uri:" + path);

        if (path.equals("/login")) {
            return true;
        }
        Session session = subject.getSession();
        logger.info("session时间设置：" + String.valueOf(session.getTimeout()));

        try {
            // 当前用户
            BaseAdminUser user = (BaseAdminUser) subject.getPrincipal();
            String username = user.getSysUserName();
            logger.info("===当前用户username:" + username);
            Serializable sessionId = session.getId();
            logger.info("===当前用户sessionId:" + sessionId);
            // 读取缓存用户 没有就存入
            Deque<Serializable> deque = cache.get(username);
            logger.debug("===当前deque:" + deque);
            if (deque == null) {
                // 初始化队列
                deque = new ArrayDeque<Serializable>();
            }
            // 如果队列里没有此sessionId，且用户没有被踢出；放入队列
            if (!deque.contains(sessionId) && session.getAttribute("kickout") == null) {
                // 将sessionId存入队列
                deque.push(sessionId);
                // 将用户的sessionId队列缓存
                cache.put(username, deque);
            }
            // 如果队列里的sessionId数超出最大会话数，开始踢人
            while (deque.size() > maxSession) {
                logger.debug("===deque队列长度:" + deque.size());
                Serializable kickoutSessionId = null;
                // 是否踢出后来登录的，默认是false；即后者登录的用户踢出前者登录的用户；
                if (kickoutAfter) { // 如果踢出后者
                    kickoutSessionId = deque.removeFirst();
                } else { // 否则踢出前者
                    kickoutSessionId = deque.removeLast();
                }
                // 踢出后再更新下缓存队列
                cache.put(username, deque);
                try {
                    // 获取被踢出的sessionId的session对象
                    Session kickoutSession = sessionManager
                            .getSession(new DefaultSessionKey(kickoutSessionId));
                    if (kickoutSession != null) {
                        // 设置会话的kickout属性表示踢出了
                        kickoutSession.setAttribute("kickout", true);
                    }
                } catch (Exception e) {

                }
            }

            // 如果被踢出了，(前者或后者)直接退出，重定向到踢出后的地址
            if ((Boolean) session.getAttribute("kickout") != null
                    && (Boolean) session.getAttribute("kickout") == true) {
                // 会话被踢出了
                try {
                    // 退出登录
                    subject.logout();
                } catch (Exception e) { // ignore
                }
                saveRequest(servletRequest);
                logger.debug("===踢出后用户重定向的路径kickoutUrl:" + kickoutUrl);
                return isAjaxResponse(servletRequest, servletResponse);
            }
            return true;
        } catch (Exception e) {
            logger.error("控制用户在线数量【KickoutSessionFilter.onAccessDenied】异常！", e);
            return isAjaxResponse(servletRequest, servletResponse);
        }
    }

    private boolean isAjaxResponse(ServletRequest request, ServletResponse response) throws IOException {
        /**
         * 判断是否已经踢出
         * 1.如果是 Ajax 访问，那么给予json返回值提示。
         * 2.如果是普通请求，直接跳转到登录页
         */
        //判断是不是Ajax请求
        ResponseResult responseResult = new ResponseResult();
        if (this.isAjax(request)) {
            logger.info(getClass().getName() + "当前用户已经在其他地方登录，并且是Ajax请求！");
            responseResult.setCode(SystemStatusEnum.MANY_LOGINS.getCode());
            responseResult.setMessage("您已在别处登录，请您修改密码或重新登录");
            out(response, responseResult);
        } else {
            // 重定向
            WebUtils.issueRedirect(request, response, kickoutUrl);
        }
        return false;
    }

    public boolean isAjax(ServletRequest request){
        String header = ((HttpServletRequest) request).getHeader("X-Requested-With");
        if("XMLHttpRequest".equalsIgnoreCase(header)){
            logger.info("shiro工具类【ShiroFilterUtils.isAjax】当前请求,为Ajax请求");
            return Boolean.TRUE;
        }
        logger.debug("shiro工具类【ShiroFilterUtils.isAjax】当前请求,非Ajax请求");
        return Boolean.FALSE;
    }

    public static void out(ServletResponse response, ResponseResult result) {
        PrintWriter out = null;
        try {
            //设置编码
            response.setCharacterEncoding("UTF-8");
            //设置返回类型
            response.setContentType("application/json");
            out = response.getWriter();
            //输出
            out.println(OBJECT_MAPPER.writeValueAsString(result));
            logger.info("用户在线数量限制【KickoutSessionFilter.out】响应json信息成功");
        } catch (Exception e) {
            logger.error("用户在线数量限制【KickoutSessionFilter.out】响应json信息出错", e);
        } finally {
            if (null != out) {
                out.flush();
                out.close();
            }
        }
    }
}

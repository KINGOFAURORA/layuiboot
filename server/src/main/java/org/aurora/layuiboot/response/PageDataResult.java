package org.aurora.layuiboot.response;

import java.util.List;

/**
 * @author zhangjian
 * @date 2020/11/10 17:15
 */
public class PageDataResult {
    private Integer code=200;

    //总记录数量
    private Integer totals;

    private List<?> list;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getTotals() {
        return totals;
    }

    public void setTotals(Integer totals) {
        this.totals = totals;
    }

    public List <?> getList() {
        return list;
    }

    public void setList(List <?> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageDataResult{" +
                "code=" + code +
                ", totals=" + totals +
                ", list=" + list +
                '}';
    }
}

package org.aurora.layuiboot.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.aurora.layuiboot.dto.UserDTO;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhangjian
 * @date 2020/11/9 16:13
 */
public class ListResponse implements Serializable {
    private Integer code;
    private String msg;
    @JsonProperty("user_list")
    private List<UserDTO> userDTOList;

    private ListResponse(){

    }

    public static ListResponse getSuccessResponse(){
        ListResponse response = new ListResponse();
        response.setCode(200);
        return response;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<UserDTO> getUserDTOList() {
        return userDTOList;
    }

    public void setUserDTOList(List<UserDTO> userDTOList) {
        this.userDTOList = userDTOList;
    }

    @Override
    public String toString() {
        return "ListResponse{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", userDTOList=" + userDTOList +
                '}';
    }
}

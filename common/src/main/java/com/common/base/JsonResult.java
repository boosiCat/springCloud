package com.common.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;

@Data
public class JsonResult<T> implements Serializable {

    /**
     * 成功
     */
    public static final int SUCCESS = 200;

    /**
     * 失败
     */
    public static final int FAIL = 201;

    /**
     * 没有用户数据
     */
    public static final int NOINFO = 202;

    /**
     * token失效
     */
    public static final int TOKEN_EXPIRED = 9001;

    // ---------- bm ----------
    /**
     * 未登录或登录失效
     */
    public static final int NO_LOGIN = 1000;

    /**
     * 用户名或密码错误
     */
    public static final int USERNAME_OR_PASSWORD_ERROR = 1001;

    /**
     * 账号被冻结
     */
    public static final int ACCOUNT_FREEZE = 1002;

    /**
     * 没有访问权限
     */
    public static final int UNAUTHORIZED = 1003;

    // ---------- bm ----------

    private Integer status;

    private String msg;

    private T data;

    public JsonResult() {
    }

    public JsonResult(Integer status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public JsonResult(Integer status) {
        this.status = status;
    }

    public JsonResult(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public static <T> JsonResult<T> ok() {
        return JsonResult.ok(null);
    }

    public static <T> JsonResult<T> ok(T data) {
        JsonResult<T> result = new JsonResult<>();
        result.setStatus(SUCCESS);
        result.setMsg("success");
        result.setData(data);
        return result;
    }

    public static <T> JsonResult<T> ok(String message, T data) {
        JsonResult<T> result = new JsonResult<>();
        result.setStatus(SUCCESS);
        result.setMsg(message);
        result.setData(data);
        return result;
    }

    public static JsonResult fail(int code, String message) {
        if (code == SUCCESS) {
            throw new RuntimeException("ok is not fail");
        }
        JsonResult result = new JsonResult();
        result.setStatus(code);
        result.setMsg(message);
        return result;
    }

    @SuppressWarnings("rawtypes")
    public static JsonResult badRequest(String msg) {
        return fail(FAIL, msg);
    }

    @JsonIgnore
    public boolean isOk() {
        return SUCCESS == status;
    }
}

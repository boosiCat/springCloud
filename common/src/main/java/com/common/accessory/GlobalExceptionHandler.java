package com.common.accessory;

import com.common.base.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(com.common.accessory.NoUserException.class)
    public JsonResult NoUserExceptionHandler(Exception e) {
        log.error("ExceptionHandler：", e);
        return JsonResult.fail(JsonResult.NOINFO, "请完善个人信息");
    }

    @ExceptionHandler(Exception.class)
    public JsonResult ExceptionHandler(Exception e) {
        log.error("ExceptionHandler：", e);
        return JsonResult.fail(JsonResult.FAIL, "服务器繁忙请稍后重试~");
    }

}

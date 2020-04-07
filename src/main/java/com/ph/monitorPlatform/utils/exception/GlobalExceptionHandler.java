package com.ph.monitorPlatform.utils.exception;

import com.ph.monitorPlatform.utils.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }

    //处理无效token异常
    @ExceptionHandler(InvalidTokenException.class)
    @ResponseBody
    public JsonResult invalidTokenExceptionHandler(InvalidTokenException exp) {
//        HttpStatus status = getStatus(request);
        log.error("error：{}", exp.getMessage());
        return JsonResult.fail(HttpStatus.UNAUTHORIZED.value(), exp.getMessage());
    }

    @ExceptionHandler(IllegalUserException.class)
    @ResponseBody
    public JsonResult illegalUserExceptionHandler(IllegalUserException exp) {
        log.error("error：{}", exp.getMessage());
        return JsonResult.fail(HttpStatus.FORBIDDEN.value(), exp.getMessage());
    }
}

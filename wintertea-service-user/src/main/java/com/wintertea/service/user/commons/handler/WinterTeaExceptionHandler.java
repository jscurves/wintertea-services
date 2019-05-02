package com.wintertea.service.user.commons.handler;

import com.wintertea.service.user.commons.exception.WinterTeaException;
import com.wintertea.service.user.commons.result.ResultEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 统一异常处理
 * @author woody
 */
@RestControllerAdvice
public class WinterTeaExceptionHandler {

    /**
     * Exception 处理类
     * @param e Exception
     * @return ResultEntity 统一数据返回对象
     */
    @ExceptionHandler(Exception.class)
    public ResultEntity exceptionHandler(Exception e){
        ResultEntity result = new ResultEntity();
        result.setCode(500);
        result.setMessage("系统内部错误");
        result.setErrMessage(e.getMessage());
        return result;
    }

    /**
     * WinterTeaException 处理类
     * @param e WinterTeaException
     * @return ResultEntity 统一数据返回对象
     */
    @ExceptionHandler(WinterTeaException.class)
    public ResultEntity winterTeaExceptionHandler(WinterTeaException e){
        ResultEntity result = new ResultEntity();
        result.setCode(e.getCode());
        result.setMessage(e.getMessage());
        return result;
    }
}

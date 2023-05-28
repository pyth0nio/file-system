package com.common.handler;

import com.common.CodeMsg;
import com.common.Constant;
import com.common.Result;
import com.common.exception.BussiException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description: 全局异常处理器
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    @ResponseBody
    public Object handlerException(Exception exception){
        exception.printStackTrace();
        //判断是否是程序员自己定义的异常信息
        if (exception instanceof BussiException){
            BussiException bussiException = (BussiException) exception;
            return new Result(bussiException);
        }

        //可能发生是其他异常
        return  new Result(CodeMsg.ERROR);
    }

    @ExceptionHandler
    @ResponseBody
    public Object  handlerException(BindException exception){

        System.out.println(exception);
        BindingResult bindingResult = exception.getBindingResult();
        // 获取所有的校验错误信息
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        for (ObjectError error : allErrors) {
            FieldError e = (FieldError) error;
            // 属性
            String field = e.getField();
            // 拒绝的值
            Object rejectedValue = e.getRejectedValue();
            // 拒绝的提示消息
            String defaultMessage = e.getDefaultMessage();
            String  msg = "校验属性: "+field + " 传入的值: " + rejectedValue  + "   拒绝信息: " + defaultMessage;
            return new Result(CodeMsg.VALIDATION_ERROR.code,field+":"+defaultMessage);
        }
        //  可以 messsage 信息
        //  校验字段
        return "异常处理器执行了!";
    }
}

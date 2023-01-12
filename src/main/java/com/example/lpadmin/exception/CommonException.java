package com.example.lpadmin.exception;

import com.example.lpadmin.util.Code;
import com.example.lpadmin.util.ReturnResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CommonException {

    /**
     * 系统异常
     * @param e
     * @return
     */
    @ExceptionHandler(SystemException.class)
    public ReturnResult systemException(SystemException e){

        return new ReturnResult(e.getCode(),null,e.getMessage());
    }

    /**
     * 其他异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ReturnResult globalException(Exception e){
        return new ReturnResult(Code.OTHER_ERR,null,"系统繁忙，请稍后再试");
    }
}

package com.example.lpadmin.exception;

import lombok.Data;

@Data
public class SystemException extends RuntimeException{
    private Integer code;

    public SystemException(Integer code,String s) {
        super(s);
        this.code = code;
    }

    public SystemException(Integer code,String s, Throwable throwable) {
        super(s, throwable);
        this.code = code;
    }

}

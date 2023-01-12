package com.example.lpadmin.util;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReturnResult {

    private Integer code;

    private Object data;

    private String msg;

    public ReturnResult(Integer code, Object data) {
        this.code = code;
        this.data = data;
    }
}

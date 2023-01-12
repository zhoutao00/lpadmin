package com.example.lpadmin.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class DateTime {

    private LocalDateTime _localDateTime;


    public DateTime(){
        _localDateTime = LocalDateTime.now();
    }

    public LocalDateTime getFullDateTime(){
        return _localDateTime;
    }

    @Override
    public String toString() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dateTimeFormatter.format(_localDateTime);
    }
}

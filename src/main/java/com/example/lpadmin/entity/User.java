package com.example.lpadmin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@TableName("lp_user")
public class User {
    @TableId(value = "id",type = IdType.ASSIGN_UUID)
    private String id;

    private String username;

    private String password;

    private String role;

    @TableLogic
    private Integer status;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime create_time;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime update_time;
}

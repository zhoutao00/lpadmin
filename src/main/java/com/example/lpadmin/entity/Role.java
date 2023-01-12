package com.example.lpadmin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@TableName("lp_role")
public class Role {

    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;
    private Integer role_code;
    private String role_name;
    private String role_detail;
    @TableLogic
    private Integer status;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime create_time;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime update_time;

}

package com.example.lpadmin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("lp_menu")
public class Menu {

    @TableId(value = "id",type = IdType.ASSIGN_UUID)
    private String id;

    private String menu_title;

    private Integer menu_type;

    private String menu_url;

    private String menu_perms;

    private String icon;

    private Integer visible;

    private String parent_id;

}

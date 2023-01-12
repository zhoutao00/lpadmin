package com.example.lpadmin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.lpadmin.entity.User;
import com.example.lpadmin.entity.vo.UserVo;

public interface UserService extends IService<User> {

    //条件分页查询
    IPage<User> selectPage(Page<User> userPage, String username);
}

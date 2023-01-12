package com.example.lpadmin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.lpadmin.entity.User;
import com.example.lpadmin.entity.vo.UserVo;
import com.example.lpadmin.mapper.UserMapper;
import com.example.lpadmin.service.UserService;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

    //条件分页查询
    @Override
    public IPage<User> selectPage(Page<User> userPage, String username) {
        IPage<User> pageModel =  baseMapper.selectPage(userPage,username);
        return pageModel;
    }
}

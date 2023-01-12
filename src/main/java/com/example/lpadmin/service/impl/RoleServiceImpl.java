package com.example.lpadmin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.lpadmin.entity.Role;
import com.example.lpadmin.mapper.RoleMapper;
import com.example.lpadmin.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
}

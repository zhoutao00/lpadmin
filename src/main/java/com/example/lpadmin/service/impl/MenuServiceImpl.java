package com.example.lpadmin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.lpadmin.entity.Menu;
import com.example.lpadmin.mapper.MenuMapper;
import com.example.lpadmin.service.MenuService;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
}

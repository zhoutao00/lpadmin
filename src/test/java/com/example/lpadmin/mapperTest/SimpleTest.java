package com.example.lpadmin.mapperTest;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.lpadmin.entity.User;
import com.example.lpadmin.mapper.UserMapper;
import com.example.lpadmin.service.UserService;
import com.example.lpadmin.util.DateTime;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class SimpleTest {
    @Resource
    private UserMapper userMapper;

    @Resource
    private UserService userService;

    /**
     * 测试查询全部用户
     */
    @Test
    public void findUserAll(){
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }
    /**
     * 测试添加用户
     */
    @Test
    public void addUser(){
        DateTime dateTime = new DateTime();
        User user = new User();
        user.setUsername("张飞");
        user.setPassword("23333");
        user.setStatus(0);
        user.setRole("444");
        user.setCreate_time(dateTime.getFullDateTime());
        user.setUpdate_time(dateTime.getFullDateTime());
        int i = userMapper.insert(user);
        System.out.println(i);
    }

    /**
     * 测试更新数据
     */
    @Test
    public void update(){
        //查询id
        User byId = userMapper.selectById("4");
        //修改
        byId.setUsername("大司马");
        //调用方法实现修改
        userMapper.updateById(byId);
    }

    /**
     * 测试删除
     */
    @Test
    public void delete(){
        int byId = userMapper.deleteById("4");
        System.out.println(byId);
    }

    /**
     * 测试批量删除
     */
    @Test
    public void batchDelete(){
        int deleteBatchIds = userMapper.deleteBatchIds(Arrays.asList("1234", "2234"));
        System.out.println(deleteBatchIds);
    }

    @Test
    public void findByWhere(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.likeRight("username","张");
        List<User> user = userMapper.selectList(wrapper);
        System.out.println(user);
    }

    @Test
    public void findAll(){
        List<User> userList = userService.list();
        System.out.println(userList);
    }

}

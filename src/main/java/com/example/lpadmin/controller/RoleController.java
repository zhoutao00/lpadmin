package com.example.lpadmin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.lpadmin.entity.Role;
import com.example.lpadmin.service.RoleService;
import com.example.lpadmin.util.Code;
import com.example.lpadmin.util.DateTime;
import com.example.lpadmin.util.ReturnResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "角色管理")
@RestController
@RequestMapping("/role")
public class RoleController {

    @Resource
    private RoleService roleService;

    @ApiOperation("查询所有角色信息接口")
    @GetMapping
    public ReturnResult findAll(){
        List<Role> list = roleService.list();
        Integer code = list != null ? Code.FIND_OK : Code.FIND_ERR;
        String msg = list != null ? "查询成功" : "查询失败";
        return new ReturnResult(code,list,msg);
    }


    @ApiOperation("查询单个角色信息接口")
    @GetMapping("/{id}")
    public ReturnResult findById(@PathVariable String id){
        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.eq("id",id);
        Role one = roleService.getOne(wrapper);
        Integer code = one != null ? Code.FIND_OK : Code.FIND_ERR;
        String msg = one != null ? "查询成功" : "查询失败";
        return new ReturnResult(code,one,msg);
    }

    @ApiOperation("删除角色信息接口")
    @DeleteMapping("/{id}")
    public ReturnResult deleteById(@PathVariable String id){
        boolean byId = roleService.removeById(id);
        return new ReturnResult(byId ? Code.DELETE_OK : Code.DELETE_ERR,byId,byId ? "删除成功" : "删除失败");
    }


    @ApiOperation("新增角色信息接口")
    @PostMapping
    public ReturnResult save(@RequestBody Role role){
        DateTime dateTime = new DateTime();
        role.setCreate_time(dateTime.getFullDateTime());
        role.setUpdate_time(dateTime.getFullDateTime());
        boolean b = roleService.saveOrUpdate(role);
        return new ReturnResult(b ? Code.SAVE_OK : Code.SAVE_ERR,b,b ? "新增成功" : "新增失败");
    }

}

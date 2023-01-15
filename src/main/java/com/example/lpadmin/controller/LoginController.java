package com.example.lpadmin.controller;

import com.example.lpadmin.util.ReturnResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@Api(tags = "登录接口")
@RestController
@RequestMapping("/index")
public class LoginController {


    @ApiOperation("用户登录接口（未完成）")
    @PostMapping("login")
    public ReturnResult login(){
        Map<String,Object> map = new HashMap<>();
        map.put("token","admin-token");
        return new ReturnResult(20000,map);
    }

    //{"code":20000,
    //  "data":
    //      {
    //          "roles":["admin"],
    //          "introduction":"I am a super administrator",
    //          "avatar":"https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif",
    //          "name":"Super Admin"
    //      }
    // }
    @ApiOperation("获取用户信息接口（未完成）")
    @GetMapping("info")
    public ReturnResult info(){
        Map<String,Object> map = new HashMap<>();
        map.put("role","[admin]");
        map.put("introduction","I am a super administrator");
        map.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        map.put("name","Super Admin ---- Zhou");
        return new ReturnResult(20000,map);
    }


    @ApiOperation("退出登录接口")
    @PostMapping("logout")
    public ReturnResult logout(){
        return new ReturnResult(20000,"退出成功");
    }


}

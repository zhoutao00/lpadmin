package com.example.lpadmin.controller;

import com.example.lpadmin.util.ReturnResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/index")
public class LoginController {


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
    @GetMapping("info")
    public ReturnResult info(){
        Map<String,Object> map = new HashMap<>();
        map.put("role","[admin]");
        map.put("introduction","I am a super administrator");
        map.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        map.put("name","Super Admin ---- Zhou");
        return new ReturnResult(20000,map);
    }

    @PostMapping("logout")
    public ReturnResult logout(){
        return new ReturnResult(20000,"退出成功");
    }


}

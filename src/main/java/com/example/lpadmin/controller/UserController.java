package com.example.lpadmin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.lpadmin.entity.User;
import com.example.lpadmin.entity.vo.UserVo;
import com.example.lpadmin.exception.SystemException;
import com.example.lpadmin.service.UserService;
import com.example.lpadmin.util.Code;
import com.example.lpadmin.util.DateTime;
import com.example.lpadmin.util.ReturnResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 添加用户接口
     * @param user
     * @return
     */
    @PostMapping
    public ReturnResult save(@RequestBody User user){
        DateTime dateTime = new DateTime();
        user.setCreate_time(dateTime.getFullDateTime());
        user.setUpdate_time(dateTime.getFullDateTime());
        boolean isSave = userService.save(user);
        return new ReturnResult(isSave ? Code.SAVE_OK : Code.SAVE_ERR,isSave,isSave ? "添加成功" : "添加失败");
    }

    /**
     * 根据ID删除用户接口
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ReturnResult delete(@PathVariable String id){
        boolean remove = userService.removeById(id);
        if (remove){
            return new ReturnResult(Code.DELETE_OK, true,"删除成功");
        }else {
            throw new SystemException(Code.SYSTEM_ERR,"删除失败");
        }
    }

    /**
     * 修改用户接口
     * @param user
     * @return
     */
    @PutMapping
    public ReturnResult update(@RequestBody User user){
        DateTime dateTime = new DateTime();
        user.setUpdate_time(dateTime.getFullDateTime());
        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.eq("username",user.getUsername());
        boolean update = userService.update(user,wrapper);
        return new ReturnResult(update ? Code.UPDATE_OK:Code.UPDATE_ERR,update,update ? "修改成功" : "修改失败");
    }

    /**
     * 查询所有用户
     * @return
     */
    @GetMapping
    public ReturnResult findAll(){
        List<User> userList = userService.list();
        Integer code = userList != null ? Code.FIND_OK : Code.FIND_ERR;
        String msg = userList != null ? "查询成功" : "查询失败";
        return new ReturnResult(code, userList , msg);
    }

    /**
     * 通过username查询单个用户
     * @param username
     * @return
     */
    @GetMapping("/{username}")
    public ReturnResult findByName(@PathVariable String username){
        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.eq("username",username);
        User user = userService.getOne(wrapper);
        Integer code = user != null ? Code.FIND_OK : Code.FIND_ERR;
        String msg = user != null ? "查询成功" : "查询失败";
        return new ReturnResult(code,user,msg);
    }

    /**
     * 条件分页查询
     * @param page
     * @param limit
     * @param username
     * @return
     */
    @GetMapping("/page")
    public ReturnResult findByPage(@RequestParam Long page, @RequestParam Long limit, @RequestParam(required = false,defaultValue = "") String username){
        //创建page对象
        Page<User> userPage = new Page<>(page,limit);
        //调用service方法
        IPage<User> pageModel = userService.selectPage(userPage,username);
        Integer code = pageModel != null ? Code.FIND_OK : Code.FIND_ERR;
        String msg =  pageModel != null ? "查询成功" : "查询失败";
        return new ReturnResult(code,pageModel,msg);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @DeleteMapping("batchDelete")
    public ReturnResult batchDelete(@RequestBody List<String> ids){
        boolean removeByIds = userService.removeByIds(ids);
        return new ReturnResult(removeByIds ? Code.DELETE_OK : Code.DELETE_ERR,removeByIds,removeByIds ? "批量删除成功" : "批量删除失败");
    }

}

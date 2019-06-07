package com.exam.controller;

import com.exam.entity.Score;
import com.exam.entity.User;
import com.exam.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @author fang
 * @date 2019/2/2 0002 - 下午 9:19
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;


    //添加用户信息
    @ResponseBody
    @PostMapping(value = "/admin/addUser")
    public String addUser(User user) {
        User user2 = userService.getUser(user.username);
        if (user2 == null) {
            userService.addUser(user);
            return "添加成功";
        } else {
            return "用户已存在，不可重复添加";
        }


    }

    //删除用户信息
    @ResponseBody
    @DeleteMapping(value = "/admin/delUser")
    public String delUser(String username) {
        int i = userService.delUser(username);
        return "删除" + i + "条记录";
    }

    //删除多条用户信息
    @ResponseBody
    @DeleteMapping(value = "/admin/delAllUser")
    public String delAllUser(String usernames) {
        int i = userService.delAllUser(usernames);
        return "删除" + i + "条记录";
    }

    //修改用户信息
    @ResponseBody
    @PutMapping(value = "/admin/updUser")
    public int updUser(User user) {
        int i = userService.updUser(user);
        return i;
    }

    //查询所有用户信息
    @GetMapping(value = "/admin/getUserList")
    public String getList(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Map map) {
        PageHelper.startPage(pn, 5);
        List<User> userList = userService.getUserList();
        PageInfo page = new PageInfo(userList, 5);
        map.put("pageInfo", page);
        return "admin/userList";
    }

    //按学号查询用户信息
    @ResponseBody
    @GetMapping(value = "/admin/getUser")
    public User getUser(String username) {
        User user = userService.getUser(username);
        return user;
    }

}

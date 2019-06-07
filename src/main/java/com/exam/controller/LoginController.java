package com.exam.controller;

import com.exam.entity.User;
import com.exam.service.QuestionService;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author fang
 * @date 2019/1/2 0002 - 下午 5:11
 */
@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    QuestionService questionService;

    //登录检测
    @PostMapping(value = "/login")
    public String testLogin(@RequestParam(required = true) String username, @RequestParam(required = true) String password, HttpSession session,HttpServletRequest request) {
        if("admin".equals(username) && "fangfuming".equals(password)){
            session.setAttribute("admin","admin");
            return "redirect:/admin";
        }

        User user = userService.getUser(username);
        if(user != null && user.getPassword().equals(password)){
            session.setAttribute("loginUser",username);
            int[] questionIds = questionService.getQuestionIds();
            session.setAttribute("arr",questionIds);
            return "redirect:/user/main";
        }else {
            request.setAttribute("error","用户名或密码错误请重新登录");
            return "login";
        }
    }


}

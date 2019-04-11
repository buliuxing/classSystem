package com.system.controller;

import com.system.entity.Userlogin;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.apache.shiro.subject.Subject;

/**
 * @author ：yangzengrui
 * @date ：Created in 10/4/2019 10:27 PM
 * @description：
 */
@Controller
public class LoginController {

    //登陆跳转
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginUI() throws Exception{
        return "../../login";
    }

    //登陆表单处理
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Userlogin userlogin) throws Exception{
        //shiro 实现登陆
        UsernamePasswordToken token = new UsernamePasswordToken(userlogin.getUsername(),
                userlogin.getPassword());
        Subject subject = SecurityUtils.getSubject();

        //如果登陆失败
        subject.login(token);

        if(subject.hasRole("admin")){
            return "redirect:/admin/showStudent";
        }else if(subject.hasRole("teacher")){
            return "redirect:/teacher/showCourse";
        }else if(subject.hasRole("student")){
            return "redirect:/student/showCourse";
        }
        return "/login";
    }


}

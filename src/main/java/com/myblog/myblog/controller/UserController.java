package com.myblog.myblog.controller;

import com.myblog.myblog.entity.User;
import com.myblog.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.Null;
import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/findAll")
    @ResponseBody
    public List<User> findAll(){
        List<User> all = userService.findAll();
        return all;
    }

    @RequestMapping("/index")
    public String demo3(){
        return "index";//地址指向demo3.html
    }
}

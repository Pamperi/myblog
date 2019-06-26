package com.myblog.myblog.controller;

import com.myblog.myblog.entity.User;
import com.myblog.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.Null;
import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/findAll.do")
    @ResponseBody
    public List<User> findAll(){
        List<User> all = userService.findAll();
        return all;
    }
    @RequestMapping(value = "/findById.do")
    @ResponseBody
    public User findById(Integer id){
       return userService.findById(id);
    }

    @RequestMapping(value = "/save.do")
    @ResponseBody
    public void add(@RequestBody User user){
       System.out.println(user.getImage());
        userService.add(user);
    }
    @RequestMapping(value = "/deleteById.do")
    public void delete(Integer id){
        userService.delete(id);
    }

    @RequestMapping(value = "/findByStatus.do")
    @ResponseBody
    public User findByStatus(Integer status){
        return userService.findByStatus(status);
    }
}

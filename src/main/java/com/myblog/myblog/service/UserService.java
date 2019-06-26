package com.myblog.myblog.service;

import com.myblog.myblog.entity.User;
import com.myblog.myblog.repositoty.UserRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepositoty userRepositoty;
    public List<User> findAll(){
       return userRepositoty.findAll();
    }
}

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
    public User findById(Integer id){
       return userRepositoty.findById(id);
    }
    public void add(User user){
        userRepositoty.save(user);
    }
    public void delete(Integer id){
        userRepositoty.deleteById(id);
    }

    public User findByStatus(Integer status){
       return userRepositoty.findByStatus(status);
    }
}

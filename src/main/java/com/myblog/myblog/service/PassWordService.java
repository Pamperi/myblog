package com.myblog.myblog.service;

import com.myblog.myblog.entity.PassWord;
import com.myblog.myblog.repositoty.PassWordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassWordService {
    @Autowired
    private PassWordRepository passWordRepository;

    public PassWord save(PassWord passWord){
        return passWordRepository.save(passWord);
    }

    public PassWord findByPassWord(String password){
       return passWordRepository.findByPassword(password);
    }
}

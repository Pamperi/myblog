package com.myblog.myblog.controller;

import com.myblog.myblog.Until.Result;
import com.myblog.myblog.entity.PassWord;
import com.myblog.myblog.service.PassWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/password")
public class PassWordController {
    @Autowired
    private PassWordService passWordService;

    @RequestMapping(value = "save.do")
    @ResponseBody
    public Result save(String oldPassWord,String newPassWord){
        System.out.println(oldPassWord+""+newPassWord);
        PassWord byPassWord = passWordService.findByPassWord(oldPassWord);
        if(byPassWord==null){
            return new Result("失败",false);
        }
        PassWord pw=new PassWord();
        pw.setId(1);
        pw.setName("admin");
        pw.setPassword(newPassWord);

        PassWord save = passWordService.save(pw);
        if(save ==null){
            return new Result("失败",false);
        }
        return new Result("成功",true);
    }
}

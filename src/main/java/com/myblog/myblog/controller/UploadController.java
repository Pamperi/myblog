package com.myblog.myblog.controller;

import com.myblog.myblog.Until.FastDFSClientWrapper;
import com.myblog.myblog.Until.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/upload")
public class UploadController {

    @Autowired
    private FastDFSClientWrapper dfsClient;
    @Value("${address}")
    private String address;
    // 上传图片
    @RequestMapping(value = "/upload.do", method = RequestMethod.POST)
    @ResponseBody
    public Result upload(MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception {


        String imgUrl = dfsClient.uploadFile(file);
        // 。。。。
        if(imgUrl !=null) {
            return new Result(address+"/"+imgUrl,true);
        }else{
            return new Result(imgUrl,false);
        }
    }

}

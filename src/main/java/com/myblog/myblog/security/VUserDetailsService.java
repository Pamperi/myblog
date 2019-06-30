package com.myblog.myblog.security;

import com.myblog.myblog.entity.PassWord;
import com.myblog.myblog.repositoty.PassWordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class VUserDetailsService  implements UserDetailsService {
    @Autowired
    private PassWordRepository passWordRepository;
    /**
     * 根据用户输入的用户名返回数据源中用户信息的封装，返回一个UserDetails
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        PassWord byName = passWordRepository.findByName(s);
        return new VUserDetails(byName);
    }
}

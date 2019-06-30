package com.myblog.myblog.repositoty;

import com.myblog.myblog.entity.PassWord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import sun.security.util.Password;

@Repository
public interface PassWordRepository extends JpaRepository<PassWord,Object>, JpaSpecificationExecutor<PassWord> {
    PassWord findByPassword(String passWord);
    PassWord findByName(String name);
}

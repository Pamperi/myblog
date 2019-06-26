package com.myblog.myblog.repositoty;

import com.myblog.myblog.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  UserRepositoty extends JpaRepository<User,Long> {
}

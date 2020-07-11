package com.abc.student.service;

import com.abc.student.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserService {

//    User login(User user);

    User login(@Param("username") String username, @Param("password") String password);

    int addUser(User user);

    int updateUser(User user);

    User checkUsername(String username);
}

package com.abc.student.service.impl;

import com.abc.student.entity.User;
import com.abc.student.mapper.UserMapper;
import com.abc.student.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

//    @Override
//    public User login(User user) {
//        return userMapper.login(user);
//    }

    @Override
    public User login(String username, String password) {
        return userMapper.login(username,password);
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public User checkUsername(String username) {
        return userMapper.checkUsername(username);
    }
}

package com.abc.student.mapper;

import com.abc.student.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

//    User login(User user);

    User login(@Param("username") String username, @Param("password") String password);

    int addUser(User user);

    int updateUser(User user);

    User checkUsername(String username);
}

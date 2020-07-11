package com.abc.student.entity;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class Student {

    private int sid;

    @NotNull(message = "学号不能为空")
    @Digits(integer = 9,fraction = 9,message = "学号必须是一个9位的数字")
    private String sno;

    @NotNull(message = "姓名不能为空")
    private String sname;

    @NotNull(message = "密码不能为空")
    @Size(min = 6,max = 12,message = "密码必须是6~9位的字符")
    private String spassword;

    @NotNull(message = "性别不能为空")
    private String sex;

    @NotNull(message = "学院名不能为空")
    private String college;

    @NotNull(message = "班级名不能为空")
    private String classes;

    @NotNull(message = "手机号不能为空")
    @Digits(integer = 11,fraction = 11,message = "手机号必须是一个11位的数字")
    private String phone;

    @NotNull(message = "宿舍号不能为空")
    private String house;
}

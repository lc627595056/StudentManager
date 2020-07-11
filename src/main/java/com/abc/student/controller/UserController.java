package com.abc.student.controller;

import com.abc.student.entity.Student;
import com.abc.student.entity.User;
import com.abc.student.service.StudentService;
import com.abc.student.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private StudentService studentService;

    /**
     * 用户登录
     */
    @RequestMapping("/login")
    public String login(@Param("username") String username, @Param("password") String password, @Param("user_type") String user_type, HttpSession session, Model model){

        if (user_type.equals("sys")){
            //判断是管理员
            User login_user = userService.login(username,password);
            if (login_user!=null){
                session.setAttribute("login_user",login_user);
                return "index";
            }else {
                model.addAttribute("message","您输入的账号或密码错误");
                return "login";
            }
        }else {
            //判断是学生
            Student login_student = studentService.loginstudent(username,password);
            if (login_student!=null){
                session.setAttribute("login_student",login_student);
                return "indexStudent";
            }else {
                model.addAttribute("message","您输入的账号或密码错误");
                return "login";
            }
        }
    }

    /**
     * 管理员登录，去首页
     */
    @RequestMapping("goto_index")
    public String goto_index(){
        return "index";
    }

    /**
     * 学生登录，去首页
     */
    @RequestMapping("goto_indexStudent")
    public String goto_indexStudent(){
        return "indexStudent";
    }

    /**
     * 退出系统
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session,Model model){
        session.removeAttribute("user_login");
        session.removeAttribute("student_login");
        model.addAttribute("message","您好，您已经成功退出");
        return "login";
    }

    /**
     * 管理员登录成功后去的欢迎页
     */
    @RequestMapping("/goto_user_welcome")
    public String goto_user_welcome(HttpSession session,Model model){
        User login_user = (User) session.getAttribute("login_user");
        model.addAttribute("username",login_user.getUsername());
        return "user_welcome";
    }

    /**
     * 学生登录成功后去的欢迎页
     */
    @RequestMapping("/goto_student_welcome")
    public String goto_student_welcome(HttpSession session,Model model){
        Student login_student = (Student) session.getAttribute("login_student");
        model.addAttribute("username",login_student.getSname());
        return "student_welcome";
    }

    /**
     * 去添加管理员页面
     */
    @RequestMapping("/goto_addUser")
    public String goto_addUser(){

        return "addUser";
    }

    /**
     * 检查用户名是否重复
     */
    @RequestMapping("/checkUsername")
    @ResponseBody
    public String checkUsername(String username){

        //判断新添加的管理员用户名是否与原有的管理员用户名重复
        User user = userService.checkUsername(username);
        if (user != null){
            return "exists";
        }else {
            return "not-exists";
        }
    }

    /**
     * 添加管理员
     */
    @RequestMapping("/addUser")
    public String addUser(User user,Model model){

        int rows = userService.addUser(user);
        if (rows>0){
            model.addAttribute("success","添加管理员成功");
            return "success";
        }else {
            System.out.println("添加管理员失败");
            model.addAttribute("success","添加管理员失败");
            return "success";
        }
    }

    /**
     * 去修改管理员信息页面
     */
    @RequestMapping("/goto_updateUser")
    public String goto_updateUser(HttpSession session,Model model){

        User login_user = (User) session.getAttribute("login_user");
        model.addAttribute("username",login_user.getUsername());
        return "updateUser";
    }

    /**
     * 修改管理员信息
     */
    @RequestMapping("/updateUser")
    public String updateUser(User user,Model model){

        int rows = userService.updateUser(user);
        if (rows>0){
            model.addAttribute("success","修改管理员成功");
            return "success";
        }else {
            System.out.println("修改管理员信息失败");
            model.addAttribute("success","添加管理员失败");
            return "success";
        }
    }

}

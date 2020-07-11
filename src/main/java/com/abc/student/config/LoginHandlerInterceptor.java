package com.abc.student.config;

import com.abc.student.entity.Student;
import com.abc.student.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        User login_user = (User) request.getSession().getAttribute("login_user");
        Student login_student = (Student) request.getSession().getAttribute("login_student");
        if (login_user == null && login_student == null){
            //未登录，返回登录页面
            request.setAttribute("message","没有权限，请先登录");

            //请求转发
            request.getRequestDispatcher("/").forward(request,response);
            //重定向，必须加上项目路径
            //response.sendRedirect(request.getContextPath()+"/");
            return false;
        }else {
            //已登录，放行请求
            return true;
        }
    }
}

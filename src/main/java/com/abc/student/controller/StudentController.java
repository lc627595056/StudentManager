package com.abc.student.controller;

import com.abc.student.entity.Student;
import com.abc.student.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * 查询所有学生信息
     */
    @RequestMapping("/findStudent")
    public String findStudent(@RequestParam(defaultValue = "1")Integer pageNum, Model model){

        //获取指定页的大小，pageSize=3
        PageHelper.startPage(pageNum,5);
        List<Student> students = studentService.findStudent();
        //使用PageInfo包装数据
        //navigatePages：导航的页码数
        PageInfo pageInfo = new PageInfo(students);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("students",students);
        return "listStudent";
    }

    /**
     * 去添加学生页面
     */
    @RequestMapping("/goto_addStudent")
    public String goto_addStudent(){

        return "addStudent";
    }

    /**
     * 检查学生学号是否重复
     */
    @RequestMapping("/checkSno")
    @ResponseBody
    public String checkSno(String sno){

        Student student = studentService.checkSno(sno);
        if (student!=null){
            return "exists";
        }else {
            return "not-exists";
        }
    }

    /**
     * 添加学生
     */
    @RequestMapping("/addStudent")
    public String addStudent(@Valid Student student, BindingResult result){

        /**
         * 后端校验还未写好
         */
        if (result.hasErrors()){
            Map<String,String> map = new HashMap<>();
            result.getFieldErrors().forEach((item)->{
                //获取错误提示消息
                String message = item.getDefaultMessage();
                //获取错误字段的名字
                String field = item.getField();
                map.put(field,message);
            });
        }

        studentService.addStudent(student);
        return "redirect:/student/findStudent";
    }

    /**
     * 查询指定学生信息，返回到修改页面
     */
    @RequestMapping("/findBySno")
    public String findBySno(String sno,Model model){

        Student student = studentService.findBySno(sno);
        System.out.println("搜寻的学生信息："+student);
        model.addAttribute("student",student);
        return "updateStudent";
    }

    /**
     * 修改学生信息
     */
    @RequestMapping("/updateStudent")
    public String updateStudent(@Valid Student student){

        int rows = studentService.updateStudent(student);
        if (rows>0){
            System.out.println("修改后："+student);
            return "redirect:/student/findStudent";
        }else {
            System.out.println("修改后："+student);
            return "redirect:/student/findStudent";
        }
    }

    /**
     * 删除学生信息
     */
    @RequestMapping("/deleteStudent")
    public String deleteStudent(String sno){

        int rows = studentService.deleteStudent(sno);
        System.out.println(sno);
        if (rows>0){
            System.out.println("删除成功");
            return "redirect:/student/findStudent";
        }else {
            System.out.println("删除失败");
            return "redirect:/student/findStudent";
        }
    }


//****************************************************以下是学生登录******************************************************


    /**
     * 学生登录时，去学生信息查看界面
     */
    @RequestMapping("/goto_listStudentByStudent")
    public String goto_listStudentByStudent(HttpSession session,Model model){

        Student login_student = (Student) session.getAttribute("login_student");
        model.addAttribute("student",login_student);
        return "listStudentByStudent";
    }

}

package com.abc.student.controller;

import com.abc.student.entity.Absence;
import com.abc.student.entity.Student;
import com.abc.student.entity.User;
import com.abc.student.service.AbsenceService;
import com.abc.student.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/absence")
public class AbsenceController {

    @Autowired
    private AbsenceService absenceService;

    @Autowired
    private StudentService studentService;

    /**
     * 查询所有缺勤记录
     */
    @RequestMapping("/findAbsence")
    public String findAbsence(@RequestParam(defaultValue = "1")Integer pageNum, Model model){

        //获取指定页的大小，pageSize=5
        PageHelper.startPage(pageNum,5);
        List<Absence> absences = absenceService.findAbsence();
        //使用PageInfo包装数据
        //navigatePages：导航的页码数
        PageInfo pageInfo = new PageInfo(absences);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("absences",absences);
        return "listAbsence";
    }

    /**
     * 去添加缺勤记录页面，顺便查询出所有学号、以及宿舍号，然后在添加页面显示
     */
    @RequestMapping("/goto_addAbsence")
    public String goto_addAbsence(Model model, HttpSession session){

        List<Student> students2 = studentService.findStudent();
        model.addAttribute("students2",students2);

        User login_user = (User) session.getAttribute("login_user");
        model.addAttribute("username",login_user.getUsername());

        return "addAbsence";
    }

    /**
     * 添加缺勤记录
     */
    @RequestMapping("/addAbsence")
    public String addAbsence(Absence absence){

        absenceService.addAbsence(absence);
        return "redirect:/absence/findAbsence";
    }

    /**
     * 查询指定学号的学生缺勤信息，返回到修改页面
     */
    @RequestMapping("/findBySno")
    public String findBySno(String st_sno,Model model,HttpSession session){

        Absence absence = absenceService.findBySno(st_sno);
        model.addAttribute("absence",absence);
        System.out.println("搜寻后："+absence);

        User login_user = (User) session.getAttribute("login_user");
        model.addAttribute("username",login_user.getUsername());

        return "updateAbsence";
    }

    /**
     * 修改学生缺勤信息
     */
    @RequestMapping("/updateAbsence")
    public String updateAbsence(Absence absence){

        int rows = absenceService.updateAbsence(absence);
        if (rows>0){
            System.out.println("修改后："+absence);
            return "redirect:/absence/findAbsence";
        }else {
            System.out.println("修改失败");
            return "redirect:/absence/findAbsence";
        }
    }

    /**
     * 删除指定学生缺勤信息
     */
    @RequestMapping("/deleteAbsence")
    public String deleteAbsence(Integer ab_id){

        absenceService.deleteAbsence(ab_id);
        return "redirect:/absence/findAbsence";
    }


//****************************************************以下是学生登录******************************************************


    /**
     * 学生登录时，查询该学生的缺勤记录
     */
    @RequestMapping("/goto_listAbsenceByStudent")
    public String goto_listAbsenceByStudent(@RequestParam(defaultValue = "1")Integer pageNum, Model model,HttpSession session){

        Student login_student = (Student) session.getAttribute("login_student");
        session.setAttribute("sno",login_student.getSno());
        String sno = login_student.getSno();

        //获取指定页的大小，pageSize=3
        PageHelper.startPage(pageNum,5);
        List<Absence> absences = absenceService.findAbsenceByStudent(sno);
        //使用PageInfo包装数据
        //navigatePages：导航的页码数
        PageInfo pageInfo = new PageInfo(absences);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("absences",absences);
        return "listAbsenceByStudent";
    }

}

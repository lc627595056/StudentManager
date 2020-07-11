package com.abc.student.controller;

import com.abc.student.entity.Repair;
import com.abc.student.entity.Student;
import com.abc.student.entity.User;
import com.abc.student.service.RepairService;
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
@RequestMapping("/repair")
public class RepairController {

    @Autowired
    private RepairService repairService;

    @Autowired
    private StudentService studentService;

    /**
     * 查询所有报修信息
     */
    @RequestMapping("/findRepair")
    public String findRepair(@RequestParam(defaultValue = "1")Integer pageNum, Model model){

        //获取指定页的大小，pageSize=5
        PageHelper.startPage(pageNum,5);
        List<Repair> repairs = repairService.findRepair();
        //使用PageInfo包装数据
        //navigatePages：导航的页码数
        PageInfo pageInfo = new PageInfo(repairs);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("repairs",repairs);
        return "listRepair";
    }

    /**
     * 去添加报修页面，遍历出所有学号以及宿舍号，然后在添加页面显示
     */
    @RequestMapping("/goto_addRepair")
    public String goto_addRepair(Model model){

        List<Student> students2 = studentService.findStudent();
        model.addAttribute("students2",students2);

        return "addRepair";
    }

    /**
     * 添加报修信息
     */
    @RequestMapping("/addRepair")
    public String addRepair(Repair repair,HttpSession session){

        Student login_student = (Student) session.getAttribute("login_student");
        if (login_student!=null){
            repairService.addRepair(repair);
            return "redirect:/repair/goto_listRepairByStudent";
        }
        repairService.addRepair(repair);
        return "redirect:/repair/findRepair";
    }

    /**
     * 根据sno查询报修信息，返回修改报修页面
     */
    @RequestMapping("/findBySno")
    public String findBySno(String sno,Model model){

        Repair repair = repairService.findBySno(sno);
        model.addAttribute("repair",repair);
        System.out.println("搜寻后："+repair);
        return "updateRepair";
    }

    /**
     * 修改报修信息
     */
    @RequestMapping("/updateRepair")
    public String updateRepair(Repair repair,HttpSession session){

        //判断是否为学生登录的修改操作
        Student login_student = (Student) session.getAttribute("login_student");
        if (login_student!=null){
            repairService.updateRepair(repair);
            return "redirect:/repair/goto_listRepairByStudent";
        }else {
            int rows = repairService.updateRepair(repair);
            if (rows>0){
                return "redirect:/repair/findRepair";
            }else {
                System.out.println("修改失败");
                return "redirect:/repair/findRepair";
            }
        }
    }

    /**
     * 删除报修信息
     */
    @RequestMapping("/deleteRepair")
    public String deleteRepair(Integer rid,HttpSession session){

        //判断是否为学生登录的删除操作
        Student login_student = (Student) session.getAttribute("login_student");
        if (login_student!=null){
            repairService.deleteRepair(rid);
            return "redirect:/repair/goto_listRepairByStudent";
        }
        repairService.deleteRepair(rid);
        return "redirect:/repair/findRepair";
    }


//****************************************************以下是学生登录******************************************************


    /**
     * 学生登录查询报修信息
     */
    @RequestMapping("/goto_listRepairByStudent")
    public String goto_listRepairByStudent(@RequestParam(defaultValue = "1")Integer pageNum, Model model, HttpSession session){

        Student login_student = (Student) session.getAttribute("login_student");
        session.setAttribute("sno",login_student.getSno());
        String sno = login_student.getSno();

        //获取指定页的大小，pageSize=5
        PageHelper.startPage(pageNum,5);
        List<Repair> repairs = repairService.findRepairByStudent(sno);
        //使用PageInfo包装数据
        //navigatePages：导航的页码数
        PageInfo pageInfo = new PageInfo(repairs);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("repairs",repairs);

        return "listRepairByStudent";
    }

}

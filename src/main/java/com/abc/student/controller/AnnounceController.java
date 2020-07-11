package com.abc.student.controller;

import com.abc.student.entity.Announce;
import com.abc.student.service.AnnounceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/announce")
public class AnnounceController {

    @Autowired
    private AnnounceService announceService;

    /**
     * 查看所有公告
     */
    @RequestMapping("/findAnnounce")
    public String findAnnounce(@RequestParam(defaultValue = "1")Integer pageNum, Model model){

        //获取指定页的大小，pageSize=3
        PageHelper.startPage(pageNum,5);
        List<Announce> announces = announceService.findAnnounce();
        //使用PageInfo包装数据
        //navigatePages：导航的页码数
        PageInfo pageInfo = new PageInfo(announces);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("announces",announces);
        return "listAnnounce";
    }

    /**
     * 去添加公告页面
     */
    @RequestMapping("/goto_addAnnounce")
    public String goto_addAnnounce(){

        return "addAnnounce";
    }

    /**
     * 添加公告
     */
    @RequestMapping("/addAnnounce")
    public String addAnnounce(Announce announce){

        int rows = announceService.addAnnounce(announce);
        if (rows>0){
            return "redirect:/announce/findAnnounce";
        }else {
            System.out.println("添加错误");
            return "redirect:/announce/findAnnounce";
        }
    }

    /**
     * 查看公告信息
     */
    @RequestMapping("/findById")
    public String findById(Integer anno_id,Model model){

        Announce announce = announceService.findById(anno_id);
        model.addAttribute("announce",announce);
        return "annoView";
    }

    /**
     * 查看公告信息，修改操作的时候需要用到的数据
     */
    @RequestMapping("/findById2")
    public String findById2(Integer anno_id,Model model){

        Announce announce = announceService.findById(anno_id);
        model.addAttribute("announce",announce);
        return "updateAnnounce";
    }

    /**
     * 修改公告信息
     */
    @RequestMapping("/updateAnnounce")
    public String updateAnnounce(Announce announce,Model model){

        int rows = announceService.updateAnnounce(announce);
        if (rows>0){
            model.addAttribute("announce",announce);
            return "redirect:/announce/findAnnounce";
        }else {
            System.out.println("修改错误");
            return "redirect:/announce/findAnnounce";
        }
    }

    /**
     * 删除公告信息
     */
    @RequestMapping("/deleteAnnounce")
    public String deleteAnnounce(Integer anno_id){

        announceService.deleteAnnounce(anno_id);
        return "redirect:/announce/findAnnounce";
    }


//****************************************************以下是学生登录******************************************************


    /**
     * 学生登录查看公告信息
     */
    @RequestMapping("/goto_listAnnounceByStudent")
    public String goto_listAnnounceByStudent(@RequestParam(defaultValue = "1")Integer pageNum, Model model){

        //获取指定页的大小，pageSize=3
        PageHelper.startPage(pageNum,5);
        List<Announce> announces = announceService.findAnnounce();
        //使用PageInfo包装数据
        //navigatePages：导航的页码数
        PageInfo pageInfo = new PageInfo(announces);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("announces",announces);

        return "listAnnounceByStudent";
    }
}

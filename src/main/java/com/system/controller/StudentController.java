package com.system.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.system.entity.*;
import com.system.exception.CustomException;
import com.system.service.CollegeService;
import com.system.service.CourseService;
import com.system.service.SelectedCourseService;
import com.system.service.StudentService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ：yangzengrui
 * @date ：Created in 11/4/2019 10:12 PM
 * @description：
 */
@Controller
@RequestMapping(value = "/student")
public class StudentController {

    @Resource(name = "courseServiceImpl")
    private CourseService courseService;

    @Resource(name = "studentSeriveImpl")
    private StudentService studentService;

    @Resource(name = "selectedCourseServiceImpl")
    private SelectedCourseService selectedCourseService;

    @RequestMapping(value = "/showCourse")
    public String stuCourseShow(Model model, Integer page) throws Exception{
        List<CourseCustom> list = null;
        //页码对象
        PagingVO pagingVO = new PagingVO();
        //设置总页数
        pagingVO.setTotalCount(courseService.getCountCourse());
        if(page == null || page == 0){
            pagingVO.setToPageNo(1);
            list = courseService.findByPaging(1);
        }else{
            pagingVO.setToPageNo(page);
            list = courseService.findByPaging(page);
        }

        model.addAttribute("courseList", list);
        model.addAttribute("pagingVO", pagingVO);
        return "student/showCourse";
    }

    //选课操作
    @RequestMapping(value = "/stuSelectedCourse")
    public String stuSelectedCourse(int id) throws Exception{
        //获取当前用户名
        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipal();

        SelectedCourseCustom selectedCourseCustom = new SelectedCourseCustom();
        selectedCourseCustom.setCourseid(id);
        selectedCourseCustom.setStudentid(Integer.parseInt(username));
        SelectedCourseCustom s = selectedCourseService.findOne(selectedCourseCustom);

        if(s == null){
            selectedCourseService.save(selectedCourseCustom);
        }else{
            throw new CustomException("该课程已经被你选择，不能再选");
        }

        return "redirect:/sutdent/selectedCourse";
    }

    //退课操作
    @RequestMapping(value = "/outCourse")
    public String outCourse(int id) throws Exception{
        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipal();

        SelectedCourseCustom selectedCourseCustom = new SelectedCourseCustom();
        selectedCourseCustom.setCourseid(id);
        selectedCourseCustom.setStudentid(Integer.parseInt(username));

        selectedCourseService.remove(selectedCourseCustom);
        return "redirect:/student/selectedCourse";
    }

    //已选课程
    @RequestMapping(value = "/selectedCourse")
    public String selectedCourse(Model model) throws Exception{
        //获取当前用户名
        Subject subject = SecurityUtils.getSubject();
        StudentCustom studentCustom = studentService.findStudentAndSelectCourseListByName((String) subject.getPrincipal());
        List<SelectedCourseCustom> list = studentCustom.getSelectedCourseCustoms();
        model.addAttribute("selectedCourseList", list);
        return "student/selectedCourseList";
    }

    //已修课程
    @RequestMapping(value = "/overCourse")
    public String overCourse(Model model) throws Exception{
        //获取当前用户名
        Subject subject = SecurityUtils.getSubject();
        StudentCustom studentCustom = studentService.findStudentAndSelectCourseListByName((String) subject.getPrincipal());
        List<SelectedCourseCustom> list = studentCustom.getSelectedCourseCustoms();
        model.addAttribute("selectedCourseList", list);
        return "student/overCourse";
    }

    //修改密码
    @RequestMapping(value = "/passwordRest")
    public String passwordRest() throws Exception{
        return "student/passwordRest";
    }



}

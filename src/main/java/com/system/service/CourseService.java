package com.system.service;

import com.system.entity.CourseCustom;

import java.util.List;

/**
 * @author ：yangzengrui
 * @date ：Created in 10/4/2019 6:50 PM
 * @description：
 */

public interface CourseService {

    //根据id跟新课程信息
    void updateById(Integer id, CourseCustom courseCustom) throws Exception;

    //根据id删除课程信息
    Boolean removeById(Integer id) throws Exception;

    //获取分页查询课程信息
    List<CourseCustom> findByPaging(Integer toPageNo) throws Exception;

    //插入课程信息
    Boolean save(CourseCustom courseCustom) throws Exception;

    //获取课程总数
    int getCountCourse() throws Exception;

    //根据id查询
    CourseCustom findById(Integer id) throws Exception;

    //根据名字查询
    List<CourseCustom> findByName(String name) throws Exception;

    //根据教师id查找课程
    List<CourseCustom> findByTeacherID(Integer id) throws Exception;

}

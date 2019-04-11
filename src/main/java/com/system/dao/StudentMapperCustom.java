package com.system.dao;

import com.system.entity.PagingVO;
import com.system.entity.StudentCustom;

import java.util.List;

/**
 * @author ：yangzengrui
 * @date ：Created in 10/4/2019 5:22 PM
 * @description：
 */

public interface StudentMapperCustom {

    //分页查询学生信息
    List<StudentCustom> findByPaging(PagingVO pagingVO) throws Exception;

    //查询学生信息和其选课信息
    StudentCustom findStudentAndSelectCourseListById(Integer id) throws Exception;

}

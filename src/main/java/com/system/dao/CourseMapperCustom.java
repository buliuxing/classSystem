package com.system.dao;

import com.system.entity.CourseCustom;
import com.system.entity.PagingVO;

import java.util.List;

/**
 * @author ：yangzengrui
 * @date ：Created in 10/4/2019 5:19 PM
 * @description：
 */

public interface CourseMapperCustom {

    //分页查询学生信息
    List<CourseCustom> findByPaging(PagingVO pagingVO) throws Exception;

}

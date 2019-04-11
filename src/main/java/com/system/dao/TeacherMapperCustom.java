package com.system.dao;

import com.system.entity.PagingVO;
import com.system.entity.TeacherCustom;

import java.util.List;

/**
 * @author ：yangzengrui
 * @date ：Created in 10/4/2019 5:25 PM
 * @description：
 */

public interface TeacherMapperCustom {

    //分页查询老师信息
    List<TeacherCustom> findByPaging(PagingVO pagingVO) throws Exception;

}

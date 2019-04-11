package com.system.service;

import com.system.entity.College;

import java.util.List;

/**
 * @author ：yangzengrui
 * @date ：Created in 10/4/2019 6:45 PM
 * @description：
 */

public interface CollegeService {

    List<College> findAll() throws Exception;

}

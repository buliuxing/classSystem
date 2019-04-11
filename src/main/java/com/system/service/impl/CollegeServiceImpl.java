package com.system.service.impl;

import com.system.dao.CollegeMapper;
import com.system.entity.College;
import com.system.entity.CollegeExample;
import com.system.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：yangzengrui
 * @date ：Created in 10/4/2019 6:46 PM
 * @description：
 */
@Service
public class CollegeServiceImpl implements CollegeService {

    @Autowired
    private CollegeMapper collegeMapper;


    @Override
    public List<College> findAll() throws Exception {
        CollegeExample collegeExample = new CollegeExample();
        CollegeExample.Criteria criteria = collegeExample.createCriteria();

        criteria.andCollegeidIsNotNull();

        return collegeMapper.selectByExample(collegeExample);
    }
}

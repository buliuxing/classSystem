package com.system.service.impl;

import com.system.dao.UserloginMapper;
import com.system.entity.Userlogin;
import com.system.entity.UserloginExample;
import com.system.service.UserloginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：yangzengrui
 * @date ：Created in 10/4/2019 9:29 PM
 * @description：
 */
@Service
public class UserloginServiceImpl implements UserloginService {

    @Autowired
    private UserloginMapper userloginMapper;

    @Override
    public Userlogin findByName(String name) throws Exception {
        UserloginExample userloginExample = new UserloginExample();
        UserloginExample.Criteria criteria = userloginExample.createCriteria();
        criteria.andUsernameEqualTo(name);
        List<Userlogin> list = userloginMapper.selectByExample(userloginExample);

        return list.get(0);
    }

    @Override
    public void save(Userlogin userlogin) throws Exception {

        userloginMapper.insert(userlogin);
    }

    @Override
    public void removeByName(String name) throws Exception {

        UserloginExample userloginExample = new UserloginExample();
        UserloginExample.Criteria criteria = userloginExample.createCriteria();
        criteria.andUsernameEqualTo(name);
        userloginMapper.deleteByExample(userloginExample);
    }

    @Override
    public void updateByName(String name, Userlogin userlogin) {

        UserloginExample userloginExample = new UserloginExample();
        UserloginExample.Criteria criteria = userloginExample.createCriteria();
        criteria.andUsernameEqualTo(name);

        userloginMapper.updateByExample(userlogin, userloginExample);
    }
}

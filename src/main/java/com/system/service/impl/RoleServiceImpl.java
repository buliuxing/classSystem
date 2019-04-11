package com.system.service.impl;

import com.system.dao.RoleMapper;
import com.system.entity.Role;
import com.system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：yangzengrui
 * @date ：Created in 10/4/2019 8:27 PM
 * @description：
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Role findByid(Integer id) throws Exception {

        return roleMapper.selectByPrimaryKey(id);
    }
}

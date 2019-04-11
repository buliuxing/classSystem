package com.system.service;

import com.system.entity.Role;

/**
 * @author ：yangzengrui
 * @date ：Created in 10/4/2019 8:26 PM
 * @description：
 */

public interface RoleService {

    Role findByid(Integer id) throws Exception;

}

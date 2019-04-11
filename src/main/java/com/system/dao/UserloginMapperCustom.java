package com.system.dao;

import com.system.entity.UserloginCustom;

/**
 * @author ：yangzengrui
 * @date ：Created in 10/4/2019 5:28 PM
 * @description：
 */

public interface UserloginMapperCustom {

    UserloginCustom findOneByName(String name) throws Exception;

}

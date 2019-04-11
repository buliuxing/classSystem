package com.system.service;

import com.system.entity.Userlogin;

/**
 * @author ：yangzengrui
 * @date ：Created in 10/4/2019 9:24 PM
 * @description：
 */

public interface UserloginService {

    //根据名字查找用户
    Userlogin findByName(String name) throws Exception;

    //保存用户登陆信息
    void save(Userlogin userlogin) throws Exception;

    //根据姓名删除
    void removeByName(String name) throws Exception;

    //根据用户更新
    void updateByName(String name, Userlogin userlogin);

}

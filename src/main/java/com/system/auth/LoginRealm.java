package com.system.auth;

import com.system.entity.Role;
import com.system.entity.Userlogin;
import com.system.service.RoleService;
import com.system.service.UserloginService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ：yangzengrui
 * @date ：Created in 10/4/2019 9:47 PM
 * @description：
 */
@Component
public class LoginRealm extends AuthorizingRealm {

    @Resource(name = "userloginServiceImpl")
    private UserloginService userloginService;

    @Resource(name = "roleServiceImpl")
    private RoleService roleService;

    /**
     * 获取身份信息，我们可以在这个方法中，从数据库获取该用户的权限和角色信息
     *     当调用权限验证时，就会调用此方法
     */

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        String username = (String) getAvailablePrincipal(principalCollection);

        Role role = null;

        try {
            Userlogin userlogin = userloginService.findByName(username);
            //获取角色对象
            role = roleService.findByid(userlogin.getRole());
        }catch (Exception e){
            e.printStackTrace();
        }
        //通过用户名从数据库获取权限/角色信息
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> r = new HashSet<>();
        if(role != null){
            r.add(role.getRolename());
            info.setRoles(r);
        }

        return info;
    }

    /**
     * 在这个方法中，进行身份验证
     *         login时调用
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //用户名
        String username = (String) authenticationToken.getPrincipal();
        //密码
        String password = new String((char[])authenticationToken.getCredentials());

        Userlogin userlogin = null;
        try {
            userlogin = userloginService.findByName(username);
        }catch (Exception e){
            e.printStackTrace();
        }

        if(userlogin == null){
            //没有该用户名
            throw new UnknownAccountException();
        }else if(!password.equals(userlogin.getPassword())){
            //密码错误
            throw new IncorrectCredentialsException();
        }
        //身份验证通过，返回一个身份信息
        AuthenticationInfo aInfo = new SimpleAuthenticationInfo(username,password,getName());

        return aInfo;
    }
}

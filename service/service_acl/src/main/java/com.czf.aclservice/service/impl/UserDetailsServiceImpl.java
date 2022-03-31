package com.czf.aclservice.service.impl;

import com.czf.aclservice.entity.User;
import com.czf.aclservice.service.PermissionService;
import com.czf.aclservice.service.UserService;
import com.czf.serurity.entity.SecurityUser;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * <p>
 * 自定义userDetailsService - 认证用户详情
 * </p>
 *
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private PermissionService permissionService;

    /***
     * 根据账号获取用户信息
     * @param username:
     * @return: org.springframework.security.core.userdetails.UserDetails
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 从数据库中取出用户信息
        User user = userService.selectByUsername(username);

        // 判断用户是否存在
        if (user==null){
            throw new UsernameNotFoundException("用户名不存在！");
        }

        // 返回UserDetails实现类
        com.czf.serurity.entity.User curUser = new com.czf.serurity.entity.User();
        BeanUtils.copyProperties(user,curUser);

        //根据用户查询用户权限列表
        List<String> authorities = permissionService.selectPermissionValueByUserId(user.getId());


        //将用户信息放进secirtyuser中
        SecurityUser securityUser = new SecurityUser(curUser);


        securityUser.setPermissionValueList(authorities);
        return securityUser;
    }

}

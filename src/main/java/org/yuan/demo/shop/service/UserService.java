package org.yuan.demo.shop.service;

import java.util.List;

import org.yuan.demo.shop.entity.User;

public interface UserService {
    
    /**
     * 用户登录
     * @param username
     *      帐号名称
     * @param password
     *      帐号密码
     */
    User signIn(String username, String password);
    
    /**
     * 用户注册
     * @param user
     */
    User signUp(User user);
    
    /**
     * 获取所有用户
     * @return
     */
    List<User> selectList();
    
    /**
     * 获取用户记录
     * @param id 
     *      用户标识
     * @return
     */
    User selectSole(int id);
}

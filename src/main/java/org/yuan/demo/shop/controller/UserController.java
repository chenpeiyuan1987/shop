package org.yuan.demo.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yuan.demo.shop.entity.User;
import org.yuan.demo.shop.entity.external.Result;
import org.yuan.demo.shop.error.ShopMessage;
import org.yuan.demo.shop.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import static org.yuan.demo.shop.error.ShopException.error;

@Api("用户模块")
@RestController
@RequestMapping("user")
public class UserController {
    
    @Autowired
    private UserService userService;

    /**
     * 用户登录
     * @return
     */
    @ApiOperation("用户登录")
    @RequestMapping("signIn")
    public Result signIn(UserParam param) {
        if (!StringUtils.hasText(param.getUsername())) {
            throw error(ShopMessage.SIGN_IN_2);
        }
        if (!StringUtils.hasText(param.getPassword())) {
            throw error(ShopMessage.SIGN_IN_3);
        }
        User user = userService.signIn(param.getUsername(), param.getPassword());
        
        user.setPassword(null);
        return Result.success(user);
    }
    
    /**
     * 用户注册
     * @return
     */
    @ApiOperation("用户注册")
    @RequestMapping("signUp")
    public Result signUp(UserParam param) {
        if (!StringUtils.hasText(param.getUsername())) {
            throw error(ShopMessage.SIGN_UP_2);
        }
        if (!StringUtils.hasText(param.getPassword())) {
            throw error(ShopMessage.SIGN_UP_3);
        }
        
        User user = new User();
        user.setUsername(param.getUsername());
        user.setPassword(param.getPassword());
        user = userService.signUp(user);
        
        user.setPassword(null);
        return Result.success(user);
    }
    
    //----------------------------------------------------------
    // Param
    //----------------------------------------------------------
    
    /**
     * For signIn and signUp request
     */
    public static class UserParam {
        // 账号名称
        private String username;
        // 账号密码
        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
        
    }
    
}

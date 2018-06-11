package org.yuan.demo.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yuan.demo.shop.entity.User;
import org.yuan.demo.shop.entity.external.Result;
import org.yuan.demo.shop.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

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
    @ApiOperation("用户登录接口")
    @RequestMapping("signIn")
    public Result signIn(UserParam param) {
        if (!StringUtils.hasText(param.getUsername())) {
            return Result.failure("账号名称为空");
        }
        if (!StringUtils.hasText(param.getPassword())) {
            return Result.failure("账号密码为空");
        }
        User user = userService.signIn(param.getUsername(), param.getPassword());
        /*
        if (!param.getUsername().equals("chen") || !param.getPassword().equals("1234")) {
            return Result.failure("账号名称或者密码错误");
        }
        */
        user.setPassword(null);
        return Result.success(user);
    }
    
    /**
     * 用户注册
     * @return
     */
    @ApiOperation("用户注册接口")
    @RequestMapping("signUp")
    public Result signUp(UserParam param) {
        if (!StringUtils.hasText(param.getUsername())) {
            return Result.failure("账号名称为空");
        }
        if (!StringUtils.hasText(param.getPassword())) {
            return Result.failure("账号密码为空");
        }
        if (param.getUsername().endsWith("chen")) {
            return Result.failure("账号名称已被注册");
        }
        
        return Result.success(param);
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

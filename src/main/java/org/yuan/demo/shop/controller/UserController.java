package org.yuan.demo.shop.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yuan.demo.shop.output.Result;

@RestController
@RequestMapping("user")
public class UserController {

    /**
     * 用户登录
     * @return
     */
    @RequestMapping("signIn")
    public Result signIn(String username, String password) {
        return null;
    }
    
    /**
     * 用户注册
     * @return
     */
    @RequestMapping("signUp")
    public Result signUp() {
        return null;
    }
    
}

package org.yuan.demo.shop.entity;

public class User {
    // 用户标识
    private Integer id;
    // 账号名称
    private String username;
    // 帐号密码
    private String password;
    // 手机号码
    private String phone;
    // 邮箱地址
    private String email;
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
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
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
}

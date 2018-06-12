package org.yuan.demo.shop.error;

public enum ShopMessage {
    /**
     * 执行成功
     */
    SUCCESS(0, "执行成功"),
    
    /**
     * 执行失败
     */
    FAILURE(1, "执行失败"),
    
    /**
     * 帐号或密码错误
     */
    SIGN_IN_1(10001, "帐号或密码错误"),
    
    /**
     * 帐号不能为空
     */
    SIGN_IN_2(10002, "帐号不能为空"),
    
    /**
     * 密码不能为空
     */
    SIGN_IN_3(10003, "密码不能为空"),
    
    /**
     * 帐号已经被注册
     */
    SIGN_UP_1(10011, "帐号已经被注册"),
    
    /**
     * 帐号不能为空
     */
    SIGN_UP_2(10012, "帐号不能为空"),
    
    /**
     * 密码不能为空
     */
    SIGN_UP_3(10013, "密码不能为空"),
    
    /**
     * 用户注册失败
     */
    SIGN_UP_4(10014, "用户注册失败"),
    ;

    //------------------------------------------------
    //
    //------------------------------------------------
    
    // 结果编码
    private int code;
    // 结果描述
    private String info;
    
    private ShopMessage(int code, String info) {
        this.code = code;
        this.info = info;
    }

    public int getCode() {
        return code;
    }

    public String getInfo() {
        return info;
    }
    
}

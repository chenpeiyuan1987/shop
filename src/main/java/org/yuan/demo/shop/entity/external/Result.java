package org.yuan.demo.shop.entity.external;


public class Result {
    // 成功编码
    public static final int SUCCESS = 0;
    // 失败编码
    public static final int FAILURE = 1;

    // 结果编码
    private Integer code;
    // 结果描述
    private String info;
    // 结果数据
    private Object data;
    
    public Result() {
    }

    public Result(Integer code, String info, Object data) {
        this.code = code;
        this.info = info;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static Result success(Object data) {
        return new Result(SUCCESS, "执行成功", data);
    }
    public static Result failure(String info) {
        return new Result(FAILURE, info, null);
    }
    public static Result failure(Integer code, String info) {
        return new Result(code, info, null);
    }
}

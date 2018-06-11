package org.yuan.demo.shop.output;

public class Result {
    public static final int SUCCESS = 0;

    private Integer code;
    
    private String info;
    
    private Object data;
    
    public static Result success(Object data) {
        Result result = new Result();
        return result;
    }
}

package org.yuan.demo.shop.demo;

import org.yuan.demo.shop.entity.external.Result;

import com.fasterxml.jackson.databind.ObjectMapper;


public class ObjectMapperDemo {
    // {"code":0, "info":"执行成功", "data":{"username":"chen", "password":"1234"}}
    public static void main(String[] args) throws Exception {
        String json = "{\"code\":0, \"info\":\"执行成功\", \"data\":{\"username\":\"chen\", \"password\":\"1234\"}}";
        
        ObjectMapper mapper = new ObjectMapper();
        Result result = mapper.readValue(json, Result.class);
        
        System.out.println(result.getData());
    }
}

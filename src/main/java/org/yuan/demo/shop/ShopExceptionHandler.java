package org.yuan.demo.shop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yuan.demo.shop.entity.external.Result;
import org.yuan.demo.shop.error.ShopException;
import org.yuan.demo.shop.error.ShopMessage;

@ControllerAdvice
public class ShopExceptionHandler {
    private static Logger log = LoggerFactory.getLogger(ShopExceptionHandler.class);

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Result handle(Exception ex) {
        
        if (ex instanceof ShopException) {
            ShopException shopException = (ShopException) ex;
            ShopMessage sm = shopException.getShopMessage();
            
            // 打印日志
            StackTraceElement element = ex.getStackTrace()[1];;
            String msg = String.format("[%s: %s] ==> %s", 
                sm.getCode(), sm.getInfo(), element.toString());
            log.error(msg);
            
            // 返回结果
            return Result.failure(sm.getCode(), sm.getInfo());
        }
        else {
            log.error(ex.getMessage(), ex);
            
            String info = ex.getMessage();
            Integer code = ShopMessage.FAILURE.getCode();
            return Result.failure(code, info);
        }
    }
}

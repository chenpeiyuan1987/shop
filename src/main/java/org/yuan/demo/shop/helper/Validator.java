package org.yuan.demo.shop.helper;

/**
 * 检验器接口
 */
public interface Validator {

    /**
     * 参数类型是否匹配
     * @param param
     * @return
     */
    boolean matched(Object param);
    
    /**
     * 验证参数是否合法
     * @param param
     * @return
     */
    boolean validate(Object param);
}

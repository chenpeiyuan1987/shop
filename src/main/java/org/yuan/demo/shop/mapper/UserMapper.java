package org.yuan.demo.shop.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.yuan.demo.shop.entity.User;

@Mapper
public interface UserMapper {

    /**
     * 获取记录列表
     * @param queryMap
     * @return
     */
    List<User> selectList(Map<String,Object> queryMap);
    
    /**
     * 获取记录总数
     * @param queryMap
     * @return
     */
    int selectSize(Map<String,Object> queryMap);
    
    /**
     * 删除记录
     * @param id
     * @return
     */
    int delete(int id);
    
    /**
     * 新增记录
     * @param user
     * @return
     */
    int insertSelective(User user);
    
    /**
     * 更新记录
     * @param user
     * @return
     */
    int updateSelective(User user);
}

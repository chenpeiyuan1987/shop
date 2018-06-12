package org.yuan.demo.shop.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yuan.demo.shop.entity.User;
import org.yuan.demo.shop.error.ShopMessage;
import org.yuan.demo.shop.mapper.UserMapper;
import org.yuan.demo.shop.service.UserService;

import static org.yuan.demo.shop.error.ShopException.error;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User signIn(String username, String password) {
        Map<String, Object> queryMap = new HashMap<String, Object>();
        queryMap.put("username", username);
        queryMap.put("password", password);
        List<User> list = userMapper.selectList(queryMap);
        if (list.size() != 1) {
            throw error(ShopMessage.SIGN_IN_1);
        }

        return list.get(0);
    }

    @Override
    public User signUp(User user) {
        Map<String, Object> queryMap = new HashMap<String, Object>();
        queryMap.put("username", user.getUsername());
        int count = userMapper.selectSize(queryMap);
        if (count > 0) {
            throw error(ShopMessage.SIGN_UP_1);
        }

        count = userMapper.insertSelective(user);
        if (count != 1) {
            throw error(ShopMessage.SIGN_UP_4);
        }

        return selectSole(user.getId());
    }

    @Override
    public List<User> selectList() {
        Map<String, Object> queryMap = new HashMap<String, Object>();
        return userMapper.selectList(queryMap);
    }

    @Override
    public User selectSole(int id) {
        Map<String, Object> queryMap = new HashMap<String, Object>();
        queryMap.put("id", id);
        List<User> list = userMapper.selectList(queryMap);
        return list.size() > 0 ? list.get(0) : null;
    }

}

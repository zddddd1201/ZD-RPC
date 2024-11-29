package com.zd.example.common.service;

import com.zd.example.common.model.User;

//编写用户服务接口 UserService，提供一个获取用户的方法
public interface UserService {
    /**
     * 获取用户
     *
     * @param user
     * @return
     */
    User getUser(User user);
}

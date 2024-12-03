package com.zd.example.consumer;

import com.zd.example.common.model.User;
import com.zd.example.common.service.UserService;
import com.zd.yurpc.bootstrap.ConsumerBootstrap;

import com.zd.yurpc.proxy.ServiceProxyFactory;


public class ConsumerExample {
    public static void main(String[] args) {
        // 服务提供者初始化
        ConsumerBootstrap.init();

        // 获取代理
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("zd");
        // 调用
        User newUser = userService.getUser(user);
        if (newUser != null) {
            System.out.println(newUser.getName());
        } else {
            System.out.println("user == null");
        }


    }
}

package com.zd.example.provider;

import com.zd.example.common.service.UserService;
import com.zd.yurpc.registry.LocalRegistry;
import com.zd.yurpc.server.HttpServer;
import com.zd.yurpc.server.VertxHttpServer;

/**
 * 简易服务提供者示例
 */
public class EasyProviderExample {

    public static void main(String[] args) {
        // 注册服务
        LocalRegistry.register(UserService.class.getName(), UserServiceImpl.class);
        // 启动web服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(8080);
    }
}

package com.zd.example.provider;

import com.zd.example.common.service.UserService;
import com.zd.yurpc.RpcApplication;
import com.zd.yurpc.registry.LocalRegistry;
import com.zd.yurpc.server.HttpServer;
import com.zd.yurpc.server.VertxHttpServer;

public class ProviderExample {
    public static void main(String[] args) {
        // RPC 框架初始化
        RpcApplication.init();


        // 注册服务
        LocalRegistry.register(UserService.class.getName(), UserServiceImpl.class);

        // 启动 web 服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(RpcApplication.getRpcConfig().getServerPort());
    }
}

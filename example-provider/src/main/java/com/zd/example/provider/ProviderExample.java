package com.zd.example.provider;

import cn.hutool.core.net.NetUtil;
import com.zd.example.common.service.UserService;
import com.zd.yurpc.RpcApplication;
import com.zd.yurpc.config.RegistryConfig;
import com.zd.yurpc.config.RpcConfig;
import com.zd.yurpc.model.ServiceMetaInfo;
import com.zd.yurpc.registry.EtcdRegistry;
import com.zd.yurpc.registry.LocalRegistry;
import com.zd.yurpc.registry.Registry;
import com.zd.yurpc.registry.RegistryFactory;
import com.zd.yurpc.server.HttpServer;
import com.zd.yurpc.server.VertxHttpServer;
import com.zd.example.provider.UserServiceImpl;

/**
 * 服务提供者示例
 *
 */
public class ProviderExample {

    public static void main(String[] args) {
        // RPC 框架初始化
        RpcApplication.init();

        // 注册服务
        String serviceName = UserService.class.getName();
        LocalRegistry.register(serviceName, UserServiceImpl.class);

        // 注册服务到注册中心
        RpcConfig rpcConfig = RpcApplication.getRpcConfig();
        RegistryConfig registryConfig = rpcConfig.getRegistryConfig();
        Registry registry = RegistryFactory.getInstance(registryConfig.getRegistry());
        ServiceMetaInfo serviceMetaInfo = new ServiceMetaInfo();
        serviceMetaInfo.setServiceName(serviceName);
        serviceMetaInfo.setServiceHost(rpcConfig.getServerHost());
        serviceMetaInfo.setServicePort(rpcConfig.getServerPort());
        try {
            registry.register(serviceMetaInfo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // 启动 web 服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(RpcApplication.getRpcConfig().getServerPort());
    }
}

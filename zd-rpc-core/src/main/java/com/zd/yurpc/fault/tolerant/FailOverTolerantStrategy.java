package com.zd.yurpc.fault.tolerant;

import com.zd.yurpc.model.RpcResponse;
import com.zd.yurpc.fault.tolerant.TolerantStrategy;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * 转移到其他服务节点 - 容错策略
 */
@Slf4j
public class FailOverTolerantStrategy implements TolerantStrategy {

    @Override
    public RpcResponse doTolerant(Map<String, Object> context, Exception e) {
        // todo 可自行扩展，获取其他服务节点并调用
        return null;
    }
}

package cn.woniu.service.consumer;


import cn.woniu.utils.ResponseResult;

/**
 * (ConsumerAddress)表服务接口
 *
 * @author makejava
 * @since 2023-01-05 11:38:49
 */
public interface ConsumerAddressService {
    ResponseResult<?> queryClientAddressByClientId(String id);
}


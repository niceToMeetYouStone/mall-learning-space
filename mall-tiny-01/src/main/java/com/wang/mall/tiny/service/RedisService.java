package com.wang.mall.tiny.service;


/**
 * redis的相关操作的服务
 * 对象和数组都是以json的形式存储
 * @author zhangrui
 */
public interface RedisService {


    /**
     * 存储数据
     * @param key
     * @param value
     */
    void set(String key,String value);

    /**
     * 获取数据
     * @param key
     * @return
     */
    String get(String key);

    /**
     * 设置超时时间
     * @param key
     * @param expire
     * @return
     */
    boolean expire(String key,Long expire);

    /**
     * 删除数据
     * @param key
     */
    void  remove(String key);

    /**
     * 自增操作
     * @param key
     * @param delta
     * @return
     */
    Long increment(String key,Long delta);
}

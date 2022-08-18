package com.wang.mall.tiny.config;


import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * 配置mybaties
 */
@Configuration
@MapperScan("com.wang.mall.tiny.mbg.mapper")
public class MyBatisConfig {
}

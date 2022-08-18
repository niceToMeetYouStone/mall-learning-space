package com.wang.mall.tiny.mbg;


import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 生成model，mapper.xml文档
 */
public class Generator {
    public static void main(String[] args) throws Exception {
        // 执行过程中的警告信息
        List<String> warnings = new ArrayList<String>();
        // 当代码重复的时候覆盖原来的代码
        boolean overwrite = true;
        // 读取配置文件
        InputStream resource = Generator.class.getResourceAsStream("/generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(resource);
        resource.close();


        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        // 创建
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        // 执行代码
        myBatisGenerator.generate(null);
        //发出警告
        for (String warning : warnings) {
            System.out.println(warning);
        }
    }
}

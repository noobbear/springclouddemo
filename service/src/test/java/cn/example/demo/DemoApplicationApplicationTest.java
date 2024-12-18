package cn.example.demo;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import cn.example.demo.config.ExampleConfig;
import cn.example.demo.service.JasyptService;

/**
 * Description: <br>
 *
 */
@SpringBootTest
public class DemoApplicationApplicationTest {
    static {
        // 按实际请情况，推荐设置在系统环境变量
        // System.setProperty("jasypt.encryptor.password","yourpassword");
    }

    @Resource
    JasyptService jasyptUtils;

    @Resource
    ExampleConfig exampleConfig;

    @Test
    void contextLoads() {
        Assert.notNull(jasyptUtils);
        Assert.notNull(exampleConfig);
        System.out.println(jasyptUtils.encrypt("nacos"));
        System.out.println(jasyptUtils.decrypt("Oeo86y+aD8ZbhlJdPR3CZoY9zgWZth+6V3XCfp6Wd6fqrTcT9uhGf6PLkDzHbu1M=="));
        System.out.println(exampleConfig);
    }
}

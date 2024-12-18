package cn.example.demo.controller;

import javax.annotation.Resource;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.example.demo.config.ExampleConfig;
import cn.example.demo.service.JasyptService;

/**
 * Description: <br>
 */
@RestController
public class DemoController {
    @Resource
    JasyptService jasyptService;

    @Resource
    ExampleConfig exampleConfig;

    @GetMapping("/test")
    String contextLoads() {
        Assert.notNull(jasyptService, "jasyptService 为null");
        Assert.notNull(exampleConfig, "exampleConfig 为null");
        return "[exampleConfig]" + exampleConfig + " ------- test jasypt: [pwd]=" + jasyptService.encrypt("pwd");
    }
}

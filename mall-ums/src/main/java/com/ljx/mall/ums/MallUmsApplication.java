package com.ljx.mall.ums;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.ljx.mall.ums.mapper")
@EnableDubbo
@SpringBootApplication
public class MallUmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallUmsApplication.class, args);
    }

}

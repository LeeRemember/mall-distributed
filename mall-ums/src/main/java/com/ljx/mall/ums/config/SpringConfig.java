package com.ljx.mall.ums.config;

import com.ljx.mall.common.util.JwtTokenUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: SpringConfig
 * Description:TODO
 * date: 2020-02-13 16:39
 *
 * @author JianXin-Lee
 * @version 1.0
 * @since JDK 1.8
 */
@Configuration
public class SpringConfig {

    @Bean
    public JwtTokenUtil getJwtTokenUtil(){
        return new JwtTokenUtil();
    }
}

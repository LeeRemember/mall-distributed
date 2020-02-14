package com.ljx.mall.ums.config;

import io.shardingjdbc.core.api.MasterSlaveDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

/**
 * ClassName: PmsDataSourceConfig
 * Description:TODO 配置类
 * date: 2020-02-11 19:43
 *
 * @author JianXin-Lee
 * @version 1.0
 * @since JDK 1.8
 */
@Configuration
public class UmsDataSourceConfig {

    @Bean
    public DataSource dataSource() throws IOException, SQLException {
        File file = ResourceUtils.getFile("classpath:sharding-jdbc.yml");
        DataSource dataSource = MasterSlaveDataSourceFactory.createDataSource(file);
        return dataSource;
    }
}

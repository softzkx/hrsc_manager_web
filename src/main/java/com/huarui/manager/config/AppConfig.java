package com.huarui.manager.config;

import com.huarui.common.utils.FastDFSClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2017/11/12.
 */
@Configuration
public class AppConfig {
    @Bean
    public FastDFSClient fastDFSClient() throws Exception {
        return new FastDFSClient("classpath:conf/client.conf");
    }
}

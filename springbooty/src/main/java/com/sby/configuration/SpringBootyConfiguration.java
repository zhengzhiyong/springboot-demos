package com.sby.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zheng on 2018/6/28.
 */
@Configuration
public class SpringBootyConfiguration {

    @Bean
    public ServiceConfiguration serviceConfiguration(){
        return new ServiceConfigurationImp();
    }

}

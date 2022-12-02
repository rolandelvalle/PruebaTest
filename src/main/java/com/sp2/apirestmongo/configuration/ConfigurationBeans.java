package com.sp2.apirestmongo.configuration;

import com.sp2.apirestmongo.security.jwt.OperationJwt;
import com.sp2.apirestmongo.security.jwt.OperationJwtImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationBeans {

    @Bean
    public OperationJwt generationToken(){
        return new OperationJwtImpl();
    }
}

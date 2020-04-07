package com.ph.monitorPlatform.utils.jwt;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;


@Configuration
public class WebConfig implements WebMvcConfigurer {

//    @Bean
//    TokenInterceptor jwtInterceptor() {
//        return new TokenInterceptor();
//    }

    @Resource
    private TokenInterceptor tokenInterceptor;


    /**
     * 配置拦截路径
     *
     * @param registry
     */

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/user/login")
                .excludePathPatterns("/alert/exportAlert")
                .excludePathPatterns("/*.jpg");
        WebMvcConfigurer.super.addInterceptors(registry);
    }

}

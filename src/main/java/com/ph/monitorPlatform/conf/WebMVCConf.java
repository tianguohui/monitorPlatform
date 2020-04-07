package com.ph.monitorPlatform.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMVCConf implements WebMvcConfigurer {

    /**
     * 配置资源映射路径
     * addResourceHandler：访问映射路径
     * addResourceLocations：资源绝对路径
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/filesystem/**")
                .addResourceLocations("classpath:/filesystem/");
    }
}

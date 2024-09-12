package com.example.demo.config;

import com.example.demo.filter.TestFilter;
import com.example.demo.interceptor.TestInterceptor;
import jakarta.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TestInterceptor())
                .addPathPatterns("/test/*");
    }



//                .excludePathPatterns("/test/interceptor")

    @Bean
    public FilterRegistrationBean testFilter() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new TestFilter());
        filterRegistrationBean.setOrder(1);
        filterRegistrationBean.setUrlPatterns(List.of("/test/*"));

        return filterRegistrationBean;
    }
}



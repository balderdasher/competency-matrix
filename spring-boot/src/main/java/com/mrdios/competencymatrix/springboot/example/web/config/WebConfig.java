package com.mrdios.competencymatrix.springboot.example.web.config;

import com.mrdios.competencymatrix.springboot.example.web.filter.RequestAccessFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类：用于注册过滤器等
 *
 * @author MrDios
 * @date 2017-08-01
 */
@Configuration
public class WebConfig {
    @Bean
    public RequestAccessFilter requestAccessFilter() {
        return new RequestAccessFilter();
    }

    @Bean
    public FilterRegistrationBean getRegistration() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new RequestAccessFilter());
        registrationBean.addUrlPatterns("/");
        registrationBean.addInitParameter("paramName", "paramValue");
        registrationBean.setName("RequestAccessFilter");
        registrationBean.setOrder(1);
        return registrationBean;
    }
}

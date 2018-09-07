package com.eai.Filter;

import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * 
 * @author xudong.li
 * 过滤器，定义filter继承servlet的filter
 */
public class WebConfiguration {
    @Bean
    public RemoteIpFilter remoteIpFilter(){
        return new RemoteIpFilter();
    }

    @Bean
    public FilterRegistrationBean testFilterRegistration(){
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new MyFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName","paramValue");
        registration.setName("MyFilter");
        registration.setOrder(1);
        return registration;
    }
}

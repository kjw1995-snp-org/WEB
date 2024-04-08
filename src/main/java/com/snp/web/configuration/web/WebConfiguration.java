package com.snp.web.configuration.web;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.servlets.DefaultServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebConfiguration implements WebMvcConfigurer {

    private final AsyncHandlerInterceptor logInterceptor;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:templates/")
                .setCachePeriod(60 * 60 * 24 * 365);
        registry.addResourceHandler("/css/**")
                .addResourceLocations("classpath:/static/css/")
                .setCachePeriod(60 * 60 * 24 * 365);
        registry.addResourceHandler("/js/**")
                .addResourceLocations("classpath:/static/js/")
                .setCachePeriod(60 * 60 * 24 * 365);
        registry.addResourceHandler("/img/**","/assets/img/**")
                .addResourceLocations("classpath:/static/img/")
                .setCachePeriod(60 * 60 * 24 * 365);
        registry.addResourceHandler("/font/**", "/fonts/**")
                .addResourceLocations("classpath:/static/fonts/")
                .setCachePeriod(60 * 60 * 24 * 365);
        registry.addResourceHandler("/data/**", "/assets/data/**")
                .addResourceLocations("classpath:/static/js/data/")
                .setCachePeriod(60 * 60 * 24 * 365);
        registry.addResourceHandler("/docs/**")
                .addResourceLocations("classpath:/static/docs/");

    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(logInterceptor).addPathPatterns("/**");

    }

    /**
     * 정적리소스 는 DefaultServlet 에게 위임한다.
     * @return {@link ServletRegistrationBean}
     * @author kimjungwoo
     */
    @Bean
    public ServletRegistrationBean<DefaultServlet> defaultServlet() {
        return new ServletRegistrationBean<DefaultServlet>(
                new DefaultServlet(),
                "/css/**",
                "/js/**",
                "/img/**",
                "/assets/img/**",
                "/font/**",
                "/fonts/**",
                "/data/**",
                "/assets/data/**",
                "/docs/**"
        );
    }

}

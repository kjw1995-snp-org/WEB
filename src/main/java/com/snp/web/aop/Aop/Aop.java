package com.snp.web.aop.Aop;

import com.snp.web.common.GlobalUrl;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

@Aspect
@Component
@Order(1)
public class Aop {

    @Pointcut("execution(public * com.snp.web.controller..*(..))")
    public void controllerRoute() {}

    @AfterReturning(pointcut = "controllerRoute()", returning = "viewModel")
    public void addProperties(ModelAndView viewModel) {

        viewModel.addObject("urls", new GlobalUrl());

    }

}

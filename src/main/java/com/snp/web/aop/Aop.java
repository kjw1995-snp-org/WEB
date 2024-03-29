package com.snp.web.aop;

import com.snp.web.global.GlobalUrl;
import com.snp.web.util.SessionUtils;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

@Aspect
@Component
@Order(1)
public class Aop {

    @Autowired
    private SessionUtils sessionUtils;

    @Pointcut("execution(public * com.snp.web.controller..*(..))")
    public void controllerRoute() {}

    @AfterReturning(pointcut = "controllerRoute()", returning = "viewModel")
    public void addProperties(ModelAndView viewModel) {

        viewModel.addObject("urls", new GlobalUrl());
        viewModel.addObject("sessionInfo", sessionUtils.getUserSession());

    }

}

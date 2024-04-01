package com.snp.web.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public abstract class ServletUtils {

    public static HttpServletRequest getRequest() {

        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if(servletRequestAttributes == null) {
            return null;
        }

        return servletRequestAttributes.getRequest();

    }

    public static HttpSession getSession() {
        return getRequest().getSession();
    }

}

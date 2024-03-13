package com.snp.web.controller.login;

import com.snp.web.common.GlobalUrl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @GetMapping(GlobalUrl.LOGIN_URI + "/{version}")
    public ModelAndView v1(@PathVariable("version")String version) {

        if("v1".equals(version)) {
            return new ModelAndView("/login/login");
        }

        if("v2".equals(version)) {
            return new ModelAndView("/login/login-minimal");
        }

        return null;

    }


}

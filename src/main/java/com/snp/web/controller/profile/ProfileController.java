package com.snp.web.controller.profile;

import com.snp.web.global.GlobalUrl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProfileController {

    @GetMapping(GlobalUrl.PROFILE_URI)
    public ModelAndView profile() { return new ModelAndView("profile/profile"); }

}

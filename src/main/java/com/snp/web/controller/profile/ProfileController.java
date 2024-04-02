package com.snp.web.controller.profile;

import com.snp.web.global.GlobalUrl;
import com.snp.web.service.profile.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping(GlobalUrl.PROFILE_URI)
    public ModelAndView profile(HttpServletRequest request) {

        String viewName = profileService.getPage(request);

        return new ModelAndView(viewName);
    }

}

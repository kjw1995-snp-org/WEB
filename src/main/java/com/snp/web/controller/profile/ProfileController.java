package com.snp.web.controller.profile;

import com.snp.web.global.GlobalUrl;
import com.snp.web.service.profile.ProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping(GlobalUrl.PROFILE_URI)
    public ModelAndView profile() {

        log.info("프로파일 페이지 확인");

        return new ModelAndView("profile/profile");
    }

}

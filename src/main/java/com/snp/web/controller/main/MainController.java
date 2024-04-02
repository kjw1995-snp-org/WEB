package com.snp.web.controller.main;

import com.snp.web.global.GlobalUrl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    /**
     * "/" 경로 설정
     * @return {@link String} redirect main
     */
    @GetMapping(GlobalUrl.ROOT_URI)
    public String root() {
        return "redirect:" + GlobalUrl.MAIN_URI;
    }

    /**
     * 메인페이지
     * @return {@link ModelAndView} index.html
     */
    @GetMapping(GlobalUrl.MAIN_URI)
    public ModelAndView main() {
        return new ModelAndView("main/index");
    }

}

package com.snp.web.controller.main;

import com.snp.web.global.GlobalUrl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    /**
     * 메인페이지
     * @return {@link ModelAndView} index.html
     */
    @GetMapping(GlobalUrl.MAIN_URI)
    public ModelAndView main() {
        return new ModelAndView("main/index");
    }

}

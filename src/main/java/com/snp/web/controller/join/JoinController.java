package com.snp.web.controller.join;

import com.snp.web.common.GlobalUrl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JoinController {

    @GetMapping(GlobalUrl.JOIN_URI)
    public ModelAndView join() { return new ModelAndView("join/join"); }

}

package com.snp.web.controller.feed;

import com.snp.web.global.GlobalUrl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FeedController {

    @GetMapping(GlobalUrl.FEED_URI)
    public ModelAndView feed() { return new ModelAndView("feed/feed"); }

}

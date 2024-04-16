package com.snp.web.controller.feed;

import com.snp.web.dto.api.response.ApiResponseDto;
import com.snp.web.dto.feed.inquiry.response.FeedInquiryResponseDto;
import com.snp.web.global.GlobalUrl;
import com.snp.web.service.feed.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class FeedController {

    @Autowired
    private FeedService feedService;

    @GetMapping(GlobalUrl.FEED_URI)
    public ModelAndView feed() {

        ModelAndView mav = new ModelAndView("feed/feed");
        List<FeedInquiryResponseDto> feeds = feedService.feeds().getData();
        mav.addObject("feeds", feeds);

        return mav;
    }

    @PostMapping(GlobalUrl.FEED_URI)
    @ResponseBody
    public ApiResponseDto<List<FeedInquiryResponseDto>> feeds() { return feedService.feeds(); }

}

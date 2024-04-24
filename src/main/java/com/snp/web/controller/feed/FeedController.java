package com.snp.web.controller.feed;

import com.snp.web.dto.api.response.ApiResponseDto;
import com.snp.web.dto.feed.inquiry.response.FeedInquiryResponseDto;
import com.snp.web.dto.feed.register.request.FeedRegisterRequestDto;
import com.snp.web.global.GlobalUrl;
import com.snp.web.service.feed.FeedService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@Slf4j
public class FeedController {

    @Autowired
    private FeedService feedService;

    @GetMapping(GlobalUrl.FEED_URI)
    public ModelAndView feed() { return new ModelAndView("feed/feed"); }

    @PostMapping(GlobalUrl.FEED_URI)
    @ResponseBody
    public ApiResponseDto<List<FeedInquiryResponseDto>> feeds() { return feedService.feeds(); }

    @PostMapping(GlobalUrl.FEED_REGISTER)
    @ResponseBody
    public ApiResponseDto<Object> feedRegister(@RequestBody FeedRegisterRequestDto requestDto) {

        log.info("피드등록시작");

        return feedService.feedRegister(requestDto);
    }

}

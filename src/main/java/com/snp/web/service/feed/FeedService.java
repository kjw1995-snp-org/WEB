package com.snp.web.service.feed;

import com.snp.web.dto.api.response.ApiResponseDto;
import com.snp.web.dto.feed.inquiry.response.FeedInquiryResponseDto;
import com.snp.web.dto.feed.register.request.FeedRegisterRequestDto;

import java.util.List;

public interface FeedService {

    ApiResponseDto<List<FeedInquiryResponseDto>> feeds();

    ApiResponseDto<Object> feedRegister(FeedRegisterRequestDto feedRegisterRequestDto);

}

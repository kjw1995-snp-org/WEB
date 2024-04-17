package com.snp.web.service.feed;

import com.snp.web.common.url.FeedServiceUrl;
import com.snp.web.configuration.properties.BaseProperties;
import com.snp.web.dto.api.response.ApiResponseDto;
import com.snp.web.dto.feed.inquiry.response.FeedInquiryResponseDto;
import com.snp.web.dto.feed.register.request.FeedRegisterRequestDto;
import com.snp.web.util.SenderUtils;
import com.snp.web.util.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedServiceImpl implements FeedService {

    @Autowired
    private BaseProperties baseProperties;

    @Autowired
    private SenderUtils senderUtils;

    @Autowired
    private SessionUtils sessionUtils;

    @Override
    public ApiResponseDto<List<FeedInquiryResponseDto>> feeds() {
        return senderUtils.send
                (
                        baseProperties.getFeedService().getHost(),
                        FeedServiceUrl.FEED_INQUIRY,
                        HttpMethod.POST,
                        MediaType.APPLICATION_JSON,
                        null,
                        null,
                        new ParameterizedTypeReference<ApiResponseDto<List<FeedInquiryResponseDto>>>() {}
                );
    }

    @Override
    public ApiResponseDto<Object> feedRegister(FeedRegisterRequestDto feedRegisterRequestDto) {

        Integer memberIdx = sessionUtils.getUserSession().getMemberModel().getMemberIdx();

        feedRegisterRequestDto.setMemberIdx(memberIdx);

        return senderUtils.send(
                baseProperties.getFeedService().getHost(),
                FeedServiceUrl.FEED_REGISTER,
                HttpMethod.POST,
                MediaType.APPLICATION_JSON,
                MediaType.APPLICATION_JSON,
                feedRegisterRequestDto,
                new ParameterizedTypeReference<ApiResponseDto<Object>>() {}
        );
    }
}

package com.snp.web.service.feed;

import com.snp.web.common.url.FeedServiceUrl;
import com.snp.web.configuration.properties.BaseProperties;
import com.snp.web.dto.api.response.ApiResponseDto;
import com.snp.web.dto.feed.inquiry.response.FeedInquiryResponseDto;
import com.snp.web.util.SenderUtils;
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
}

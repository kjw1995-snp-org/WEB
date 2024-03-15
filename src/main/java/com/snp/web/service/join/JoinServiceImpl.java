package com.snp.web.service.join;

import com.snp.web.common.url.UserServiceUrl;
import com.snp.web.configuration.properties.base.BaseProperties;
import com.snp.web.dto.api.response.ApiResponseDto;
import com.snp.web.dto.join.request.JoinRequestDto;
import com.snp.web.dto.join.response.JoinResponseDto;
import com.snp.web.util.SenderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

@Service
public class JoinServiceImpl implements JoinService {

    @Autowired
    private SenderUtils senderUtils;

    @Autowired
    private BaseProperties baseProperties;

    @Override
    public ApiResponseDto joinProgress(JoinRequestDto requestDto) {

        ApiResponseDto response = senderUtils.send(
                baseProperties.getBaseUserService().getHost(),
                UserServiceUrl.USER_JOIN_PROGRESS,
                HttpMethod.POST,
                MediaType.APPLICATION_JSON,
                MediaType.APPLICATION_JSON,
                requestDto,
                new ParameterizedTypeReference<ApiResponseDto>() {}
        );

        return response;
    }

}

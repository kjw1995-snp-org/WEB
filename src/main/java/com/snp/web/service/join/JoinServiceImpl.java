package com.snp.web.service.join;

import com.snp.web.common.url.UserServiceUrl;
import com.snp.web.configuration.properties.BaseProperties;
import com.snp.web.dto.api.response.ApiResponseDto;
import com.snp.web.dto.join.request.JoinRequestDto;
import com.snp.web.util.SenderUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JoinServiceImpl implements JoinService {

    @Bean
    private PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }

    @Autowired
    private SenderUtils senderUtils;

    @Autowired
    private BaseProperties baseProperties;

    @Override
    public ApiResponseDto joinProgress(JoinRequestDto requestDto) {

        requestDto.setPassword(passwordEncoder().encode(requestDto.getPassword()));

        return senderUtils.send
                (
                        baseProperties.getUserService().getHost(),
                        UserServiceUrl.USER_JOIN_PROGRESS,
                        HttpMethod.POST,
                        MediaType.APPLICATION_JSON,
                        MediaType.APPLICATION_JSON,
                        requestDto,
                        new ParameterizedTypeReference<ApiResponseDto>() {}
                );

    }

}

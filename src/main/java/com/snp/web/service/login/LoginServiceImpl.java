package com.snp.web.service.login;

import com.snp.web.common.url.UserServiceUrl;
import com.snp.web.configuration.properties.BaseProperties;
import com.snp.web.dto.api.response.ApiResponseDto;
import com.snp.web.dto.login.LoginRequestDto;
import com.snp.web.util.SenderUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoginServiceImpl implements LoginService {



    @Autowired
    private BaseProperties baseProperties;

    @Autowired
    private SenderUtils senderUtils;

    @Override
    public ApiResponseDto login(LoginRequestDto loginRequestDto) {

        log.info("Login Request = {}", loginRequestDto);

        ApiResponseDto response = senderUtils.send
                (
                        baseProperties.getUserService().getHost(),
                        UserServiceUrl.USER_LOGIN_ACTION,
                        HttpMethod.POST,
                        MediaType.APPLICATION_JSON,
                        MediaType.APPLICATION_JSON,
                        loginRequestDto,
                        new ParameterizedTypeReference<ApiResponseDto>() {}
                );


        log.info("Login Response = {}", response);

        return response;

    }

}

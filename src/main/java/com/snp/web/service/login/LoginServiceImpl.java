package com.snp.web.service.login;

import com.snp.web.common.url.UserServiceUrl;
import com.snp.web.configuration.properties.BaseProperties;
import com.snp.web.dto.api.response.ApiResponseDto;
import com.snp.web.dto.login.request.LoginRequestDto;
import com.snp.web.dto.login.response.LoginResponseDto;
import com.snp.web.model.member.MemberModel;
import com.snp.web.model.session.SessionModel;
import com.snp.web.util.SenderUtils;
import com.snp.web.util.SessionUtils;
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

    @Autowired
    private SessionUtils sessionUtils;

    @Override
    public ApiResponseDto<LoginResponseDto> login(LoginRequestDto loginRequestDto) {

        log.info("Login Request = {}", loginRequestDto);

        ApiResponseDto<LoginResponseDto> response = senderUtils.send
                (
                        baseProperties.getUserService().getHost(),
                        UserServiceUrl.USER_LOGIN_ACTION,
                        HttpMethod.POST,
                        MediaType.APPLICATION_JSON,
                        MediaType.APPLICATION_JSON,
                        loginRequestDto,
                        new ParameterizedTypeReference<ApiResponseDto<LoginResponseDto>>() {}
                );

        if(response.getStatus() == ApiResponseDto.ApiResponseStatus.SUC) {

            MemberModel memberModel = MemberModel.builder()
                                                 .memberIdx(response.getData().getMemberIdx())
                                                 .id(response.getData().getId())
                                                 .name(response.getData().getName())
                                                 .build();

            log.info("세션설정");

            sessionUtils.setUserSession(SessionModel.builder()
                                                    .memberModel(memberModel)
                                                    .build()
            );

        }

        return response;

    }

}

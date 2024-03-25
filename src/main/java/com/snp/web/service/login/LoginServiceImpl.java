package com.snp.web.service.login;

import com.snp.web.dto.api.response.ApiResponseDto;
import com.snp.web.dto.login.LoginRequestDto;
import com.snp.web.util.SenderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    private SenderUtils senderUtils;

    @Override
    public ApiResponseDto login(LoginRequestDto loginRequestDto) {
        return null;
    }

}

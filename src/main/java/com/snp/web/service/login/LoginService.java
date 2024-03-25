package com.snp.web.service.login;

import com.snp.web.dto.api.response.ApiResponseDto;
import com.snp.web.dto.login.LoginRequestDto;

public interface LoginService {

    ApiResponseDto login(LoginRequestDto loginRequestDto);

}

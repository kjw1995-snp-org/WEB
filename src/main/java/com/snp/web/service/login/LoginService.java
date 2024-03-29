package com.snp.web.service.login;

import com.snp.web.dto.api.request.ApiRequestDto;
import com.snp.web.dto.api.response.ApiResponseDto;
import com.snp.web.dto.login.request.LoginRequestDto;
import com.snp.web.dto.login.response.LoginResponseDto;

public interface LoginService {

    ApiResponseDto<LoginResponseDto> login(ApiRequestDto<LoginRequestDto> loginRequestDto);

}

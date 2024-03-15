package com.snp.web.service.join;

import com.snp.web.dto.api.response.ApiResponseDto;
import com.snp.web.dto.join.request.JoinRequestDto;

public interface JoinService {

    ApiResponseDto joinProgress(JoinRequestDto requestDto);

}

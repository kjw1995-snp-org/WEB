package com.snp.web.dto.api.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponseDto<T> {

    public enum ApiResponseStatus {
        SUC, FAIL, ERR
    }

    private ApiResponseStatus status;

    private T data;

    private String message;

    private String jwtToken;

}

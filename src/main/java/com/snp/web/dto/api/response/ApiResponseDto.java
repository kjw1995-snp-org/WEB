package com.snp.web.dto.api.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponseDto {

    public enum ApiResponseStatus {
        SUC, FAIL, ERR
    }

    private ApiResponseStatus status;

    private Object data;

    private String message;

}

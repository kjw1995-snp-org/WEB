package com.snp.web.dto.feed.inquiry.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FeedInquiryResponseDto {

    private Integer id;

    private Integer memberIdx;

    private String content;

    private String memberId;

    private String memberName;

    private LocalDateTime registDate;

}

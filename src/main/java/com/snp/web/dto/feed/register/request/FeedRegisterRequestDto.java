package com.snp.web.dto.feed.register.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class FeedRegisterRequestDto {

    private Integer memberIdx;

    private String content;

}

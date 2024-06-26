package com.snp.web.model.member;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class MemberModel {

    private Integer memberIdx;

    private String id;

    private String name;

}

package com.snp.web.model.session;

import com.snp.web.model.member.MemberModel;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class SessionModel {

    private MemberModel memberModel;

}

package com.snp.web.service.profile;

import com.snp.web.util.SenderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class ProfileServiceImpl implements ProfileService{

    @Autowired
    private SenderUtils senderUtils;

    @Override
    public String getPage() { return "확인"; }

}

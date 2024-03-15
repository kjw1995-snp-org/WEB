package com.snp.web.controller.join;

import com.snp.web.dto.api.response.ApiResponseDto;
import com.snp.web.dto.join.request.JoinRequestDto;
import com.snp.web.global.GlobalUrl;
import com.snp.web.service.join.JoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JoinController {

    @Autowired
    private JoinService joinService;

    @GetMapping(GlobalUrl.JOIN_URI)
    public ModelAndView join() { return new ModelAndView("sign/signup-v2"); }

    @PostMapping(GlobalUrl.JOIN_PROGRESS)
    @ResponseBody
    public ApiResponseDto joinProgress(@RequestBody JoinRequestDto requestDto) { return joinService.joinProgress(requestDto); }


}

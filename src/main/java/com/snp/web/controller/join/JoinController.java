package com.snp.web.controller.join;

import com.snp.web.dto.api.response.ApiResponseDto;
import com.snp.web.dto.join.request.JoinRequestDto;
import com.snp.web.global.GlobalUrl;
import com.snp.web.service.join.JoinService;
import groovy.util.logging.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
public class JoinController {

    @Autowired
    private JoinService joinService;

    /**
     * 회원가입 페이지
     * @return {@link ModelAndView} signup-v2.html
     * @author kimjungwoo
     */
    @GetMapping(GlobalUrl.JOIN_URI)
    public ModelAndView join() { return new ModelAndView("sign/signup-v2"); }

    /**
     * 회원가입
     * @param requestDto
     * @return {@link ApiResponseDto} 회원가입 결과
     * @author kimjungwoo
     */
    @PostMapping(GlobalUrl.JOIN_PROGRESS)
    @ResponseBody
    public ApiResponseDto joinProgress(@RequestBody JoinRequestDto requestDto) { return joinService.joinProgress(requestDto); }


}

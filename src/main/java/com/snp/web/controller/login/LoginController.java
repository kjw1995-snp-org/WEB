package com.snp.web.controller.login;

import com.snp.web.dto.api.request.ApiRequestDto;
import com.snp.web.dto.api.response.ApiResponseDto;
import com.snp.web.dto.login.LoginRequestDto;
import com.snp.web.global.GlobalUrl;
import com.snp.web.service.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * 로그인 페이지
     * @param version
     * @return {@link ModelAndView} v1 = login.html, v2 = login-minimal.html
     * @author kimjungwoo
     */
    @GetMapping(GlobalUrl.LOGIN_URI + "/{version}")
    public ModelAndView v1(@PathVariable("version")String version) {

        if("v1".equals(version)) {
            return new ModelAndView("/login/login");
        }

        if("v2".equals(version)) {
            return new ModelAndView("/login/login-minimal");
        }

        return null;

    }

    /**
     * 로그인
     * @param loginRequestDto
     * @return {@link ApiResponseDto} 로그인 결과
     * @author kimjungwoo
     */
    @PostMapping(GlobalUrl.LOGIN_ACTION)
    @ResponseBody
    public ApiResponseDto<Object> login(@RequestBody ApiRequestDto<LoginRequestDto> loginRequestDto) { return loginService.login(loginRequestDto); }


}

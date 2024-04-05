package com.snp.web.common.url;


/**
 * 회원 서비스 URL 정보
 */
public class UserServiceUrl {
    
    public static final String USER_ROOT_URI = "/users";
    
    /*
     * 로그인
     */
    public static final String USER_LOGIN_URI = USER_ROOT_URI + "/login";
    public static final String USER_LOGIN_ACTION = USER_LOGIN_URI + "/action";
    
    /*
     * 회원가입
     */
    public static final String USER_JOIN_URI = USER_ROOT_URI + "/join";
    public static final String USER_JOIN_PROGRESS = USER_JOIN_URI + "/progress";

}

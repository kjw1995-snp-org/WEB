package com.snp.web.util;

import com.snp.web.model.session.SessionModel;
import org.springframework.stereotype.Component;

@Component
public class SessionUtils {

    private static final String USER_SESSION_KEY = "SESSION_USER";

    public void setUserSession(SessionModel sessionModel) {
        setAttribute(USER_SESSION_KEY, sessionModel);
    }

    public SessionModel getUserSession() { return getAttribute(USER_SESSION_KEY); }

    private SessionModel getAttribute(String key) {
        return (SessionModel)ServletUtils.getSession().getAttribute(key);
    }

    private void setAttribute(String key, Object value) {
        ServletUtils.getSession().setAttribute(key, value);
    }

}

package com.snp.web.util;

import com.snp.web.model.session.SessionModel;
import org.springframework.stereotype.Component;

@Component
public class SessionUtils {

    private static final String USER_SESSION_KEY = "SESSION_USER";

    public void setUserSession(SessionModel sessionModel) {
        setAttribute(USER_SESSION_KEY, sessionModel);
    }

    public SessionModel getUserSession() { return (SessionModel)getAttribute(USER_SESSION_KEY); }

    public void removeSession() { removeAttribute(USER_SESSION_KEY); }

    private Object getAttribute(String key) {
        return ServletUtils.getSession().getAttribute(key);
    }

    private void setAttribute(String key, Object value) {
        ServletUtils.getSession().setAttribute(key, value);
    }

    private void removeAttribute(String key) { ServletUtils.getSession().removeAttribute(key); }

}

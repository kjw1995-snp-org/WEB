package com.snp.web.configuration.jwt;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.Getter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.security.Key;

@Component
@Getter
public class JwtConfig implements InitializingBean {

    private Key key;

    private final String secret;

    public JwtConfig(@Value("${jwt.secret-key}") String secret) {
        this.secret = secret;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }

}

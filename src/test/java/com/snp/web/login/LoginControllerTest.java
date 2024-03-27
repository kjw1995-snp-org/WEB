package com.snp.web.login;

import com.snp.web.controller.login.LoginController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.RestDocumentationExtension;

@SpringBootTest(classes = LoginController.class)
@AutoConfigureMockMvc
@AutoConfigureRestDocs(uriScheme = "http", uriHost = "localhost", uriPort = 8889)
@ExtendWith(RestDocumentationExtension.class)
public class LoginControllerTest {

    @Test
    void

}

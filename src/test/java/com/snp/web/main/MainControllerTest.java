package com.snp.web.main;

import com.snp.web.controller.main.MainController;
import com.snp.web.global.GlobalUrl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;

@SpringBootTest(classes = MainController.class)
@AutoConfigureMockMvc
@AutoConfigureRestDocs(uriScheme = "http", uriHost = "localhost" , uriPort = 8889)
@ExtendWith(RestDocumentationExtension.class)
public class MainControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("메인 페이지")
    public void mainTest() throws Exception {

        //  given

        //  when
        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.get(GlobalUrl.MAIN_URI));

        //  then
        actions.andExpect(MockMvcResultMatchers.status().isOk())
               .andDo(document("{class-name}/{method-name}"));

    }

}

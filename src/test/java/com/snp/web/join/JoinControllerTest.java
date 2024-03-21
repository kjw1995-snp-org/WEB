package com.snp.web.join;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.snp.web.controller.join.JoinController;
import com.snp.web.dto.join.request.JoinRequestDto;
import com.snp.web.global.GlobalUrl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.ws.rs.core.MediaType;

@SpringBootTest(classes = JoinController.class)
@AutoConfigureMockMvc
@AutoConfigureRestDocs(uriScheme = "http", uriHost = "localhost", uriPort = 8889)
@ExtendWith(RestDocumentationExtension.class)
public class JoinControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    @DisplayName("회원가입 페이지 이동")
    public void joinTest() throws Exception{

        mockMvc.perform(MockMvcRequestBuilders.get(GlobalUrl.JOIN_URI))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcRestDocumentation.document(
                        "{class-name}/{method-name}"
                ));

    }

    @Test
    @DisplayName("회원가입")
    public void joinProgressTest() throws Exception {

        //given
        String request = objectMapper.writeValueAsString(
                JoinRequestDto.builder()
                              .id("test04")
                              .password("vkfksakswkd2@")
                              .name("테스트")
                              .gender("남자")
                              .email("rohawell@daum.net")
                              .phone("01029145146")
                              .build()
        );

        // when
        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.post(GlobalUrl.JOIN_PROGRESS)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(request));

        // then
        actions.andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("SUC"))
                .andDo(MockMvcRestDocumentation.document("{class-name}/{method-name}"));

    }

}

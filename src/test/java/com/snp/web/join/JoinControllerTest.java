package com.snp.web.join;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.snp.web.controller.join.JoinController;
import com.snp.web.dto.join.request.JoinRequestDto;
import com.snp.web.global.GlobalUrl;
import com.snp.web.service.join.JoinService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.ws.rs.core.MediaType;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;

@SpringBootTest(classes = JoinController.class)
@AutoConfigureMockMvc
@AutoConfigureRestDocs(uriScheme = "http", uriHost = "localhost", uriPort = 8889)
@ExtendWith(RestDocumentationExtension.class)
public class JoinControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ObjectMapper objectMapper;

    @Test
    @DisplayName("회원가입 페이지 이동")
    public void joinTest() throws Exception{

        mockMvc.perform(MockMvcRequestBuilders.get(GlobalUrl.JOIN_URI))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(document(
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
        actions.andExpect(MockMvcResultMatchers.jsonPath("$.status").value("SUC"))
               .andDo(MockMvcRestDocumentation.document("{class-name}/{method-name}",
                       requestFields(
                               fieldWithPath("id").type(JsonFieldType.STRING).description("아이디"),
                               fieldWithPath("password").type(JsonFieldType.STRING).description("비밀번호"),
                               fieldWithPath("name").type(JsonFieldType.STRING).description("이름"),
                               fieldWithPath("gender").type(JsonFieldType.STRING).description("성별"),
                               fieldWithPath("phone").type(JsonFieldType.STRING).description("휴대폰 번호"),
                               fieldWithPath("email").type(JsonFieldType.STRING).description("이메일")
                       ),
                       responseFields(
                            fieldWithPath("status").type(JsonFieldType.STRING).description("상태"),
                            fieldWithPath("data").type(JsonFieldType.STRING).description("데이터"),
                            fieldWithPath("message").type(JsonFieldType.STRING).description("메세지")
                               
                       )
               ))
               .andDo(MockMvcResultHandlers.print());

    }

}

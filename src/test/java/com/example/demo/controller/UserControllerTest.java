package com.example.demo.controller;

import com.example.demo.AbstractSpringTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@SpringJUnitConfig
@ActiveProfiles("test")
public class UserControllerTest extends AbstractSpringTest {

    @Autowired
    private MockMvc mockMvc;

    @DisplayName("ut_user_101 : 사용자 목록 조회 테스트")
    @Test
    public void ut_user_101() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/v1/user/")
        ).andDo(print()).andExpect(status().isOk());
    }

    @DisplayName("ut_user_102 : 사용자 정보 조회 테스트")
    @Test
    public void ut_user_102() throws Exception {
        final String emplyrId = "00000000000000000001";
        mockMvc.perform(MockMvcRequestBuilders
                .get(String.format("/v1/user/%s", emplyrId))
        ).andDo(print()).andExpect(status().isOk());
    }

}

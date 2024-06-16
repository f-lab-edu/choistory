package com.choistory.feed.controller;

import com.choistory.feed.dto.HttpFeedRequestDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@AutoConfigureMockMvc
@ActiveProfiles("local")
@DisplayName("Feed Controller Api Test")
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FeedControllerTest {
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp(WebApplicationContext webApplicationContext){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
            .build();
    }

    @Test
    @Transactional
    @DisplayName("POST /v1/feeds [CreateFeedSuccess]")
    void createFeedSuccessTest() throws Exception{
        // RequestBody
        String userId = "7e0bd998-2177-11ef-9e66-0242ac110002";
        String content = "text content";
        List<MultipartFile> images = null;
        String parentId = null;
        boolean isExpire = true;
        int duration = 90;

        HttpFeedRequestDto requestBody = HttpFeedRequestDto.builder()
            .writer(userId)
            .content(content)
            .images(images)
            .parentId(parentId)
            .isExpire(isExpire)
            .duration(duration)
            .build();

        this.mockMvc.perform(
            MockMvcRequestBuilders.post("/v1/feeds")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(requestBody))
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk()
        );
    }

    @Test
    @Transactional
    @DisplayName("GET /v1/feeds?userId={userId} [CreateFeedSuccess]")
    void readFeedsSuccessTest() throws Exception{
        // RequestBody
        String userId = "7e0bd998-2177-11ef-9e66-0242ac110002";

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/v1/feeds")
                    .param("userId", userId))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.feed[0].writer").value(userId));
    }
}

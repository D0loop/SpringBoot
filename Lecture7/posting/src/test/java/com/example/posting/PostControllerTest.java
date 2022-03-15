package com.example.posting;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author D0Loop
 * @since 2022-03-14 [2022.3월.14]
 */

@RunWith(SpringRunner.class)
@WebMvcTest(PostController.class)
public class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostService postService;

    @org.junit.Test
    public void readPost() throws Exception {
        // given
        final int id = 10;
        PostDto testDto = new PostDto();
        testDto.setId(id);
        testDto.setTitle("Unit Title");
        testDto.setContent("Unit Content");
        testDto.setWriter("unit");

        given(postService.readPost(id)).willReturn(testDto);

        // when
        final ResultActions actions = mockMvc.perform(get("/post/{id}", id)).andDo(print());

        // then
        actions.andExpectAll(
                status().isOk(),
                content().contentType(MediaType.APPLICATION_JSON),
                jsonPath("$.title", is("Unit Title")),
                jsonPath("$.content", is("Unit Content")),
                jsonPath("$.writer", is("unit"))
        );
    }

    @org.junit.Test
    public void readPostAll() throws Exception {
        PostDto testDto1 = new PostDto();
        testDto1.setTitle("Unit Title1");
        testDto1.setContent("Unit Content1");
        testDto1.setWriter("unit1");

        PostDto testDto2 = new PostDto();
        testDto2.setTitle("Unit Title2");
        testDto2.setContent("Unit Content2");
        testDto2.setWriter("unit2");

        List<PostDto> readAllPost = Arrays.asList(testDto1, testDto2);
        given(postService.readPostAll()).willReturn(readAllPost);

        final ResultActions actions = mockMvc.perform(get("/post")).andDo(print());


        actions.andExpectAll(
                status().isOk(),
                content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON),
                jsonPath("$", hasSize(readAllPost.size()))

        );
    }
}
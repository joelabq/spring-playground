package com.example.springplayground;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc

public class LessonsControllerTest {

    ObjectMapper objMap = new ObjectMapper();

    @Autowired
    MockMvc mvc;

    @Autowired
    LessonRepository repository;

    @Test
    @Transactional
    @Rollback
    public void testCreate() throws Exception {
        HashMap<String, Object> data = new HashMap<String,Object>(){
            {
                put("title", "something");
                put("deliveredOn", "2020-01-01");
            }
        };

        String json = objMap.writeValueAsString(data);

        MockHttpServletRequestBuilder req = post("/lessons")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(json);

        this.mvc.perform(req)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", instanceOf(Number.class)));
    }

    @Test
    @Transactional
    @Rollback
    public void getList() throws Exception {
        HashMap<String, Object> data = new HashMap<String,Object>(){
            {
                put("title", "something");
                put("deliveredOn", "2020-01-01");
            }
        };

        String json = objMap.writeValueAsString(data);

        MockHttpServletRequestBuilder req = post("/lessons")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        this.mvc.perform(req)
                .andExpect(status().isOk());

        String expected = "[{\"id\":2,\"title\":\"something\",\"deliveredOn\":\"2020-01-01\"}]";

        req = get("/lessons")
                    .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(req)
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }

    @Test
    @Transactional
    @Rollback
    public void patchList() throws Exception {
        HashMap<String, Object> data = new HashMap<String,Object>(){
            {
                put("title", "something");
                put("deliveredOn", "2020-01-01");
            }
        };
        HashMap<String, Object> data_updated = new HashMap<String,Object>(){
            {
                put("title", "something_updated");
                put("deliveredOn", "2020-01-01");
            }
        };

        String json = objMap.writeValueAsString(data);
        String json_updated = objMap.writeValueAsString(data_updated);

        MockHttpServletRequestBuilder req = post("/lessons")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        this.mvc.perform(req)
                .andExpect(status().isOk());

        req = patch("/lessons/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json_updated);

        String expected = "{\"id\":1,\"title\":\"something_updated\",\"deliveredOn\":\"2020-01-01\"}";

        this.mvc.perform(req)
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }

    @Test
    @Transactional
    @Rollback
    public void getByTitle() throws Exception {
        HashMap<String, Object> data = new HashMap<String,Object>(){
            {
                put("title", "something");
                put("deliveredOn", "2020-01-01");
            }
        };

        String json = objMap.writeValueAsString(data);

        MockHttpServletRequestBuilder req = post("/lessons")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        this.mvc.perform(req)
                .andExpect(status().isOk());

        //String expected = "[{\"id\":2,\"title\":\"something\",\"deliveredOn\":\"2020-01-01\"}]";

        req = get("/lessons/find/something")
                .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(req)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", equalTo("something")));
    }

}

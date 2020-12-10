package com.example.springplayground;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(Simplify.class)
public class SimplifyTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void verifyDetailed() throws Exception {
        String json = getJSON();

        MockHttpServletRequestBuilder req = post("/activities/simplify")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept("application/vnd.galvanize.detailed+json")
                    .content(json);

        this.mvc.perform(req)
                .andExpect(status().isOk())
                .andExpect(content().string(json));
    }
    @Test
    public void verifyCompact() throws Exception {
        String json = getJSON();

        MockHttpServletRequestBuilder req = post("/activities/simplify")
                .contentType(MediaType.APPLICATION_JSON)
                .accept("application/vnd.galvanize.compact+json")
                .content(json);

        this.mvc.perform(req)
                .andExpect(status().isOk())
                .andExpect(content().string(json));
    }
    private String getJSON() throws Exception {
        URL url = this.getClass().getResource("/data.json");
        return new String(Files.readAllBytes(Paths.get(url.getFile())));
    }
}

package com.example.springplayground;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MathController.class)

public class MathControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getRequestForPi() throws Exception {

        this.mvc.perform(get("/math/pi").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("3.141592653589793"));
    }
    @Test
    public void addsTwoNumbers() throws Exception {
        this.mvc.perform(get("/math/calculate?operation=add&x=4&y=6").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("4 + 6 = 10"));
    }
    @Test
    public void addsTwoNumbersWhenOperationIsNull() throws Exception {
        this.mvc.perform(get("/math/calculate?x=30&y=5").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("30 + 5 = 35"));
    }
    @Test
    public void multipliesTwoNumbers() throws Exception {
        this.mvc.perform(get("/math/calculate?operation=multiply&x=4&y=6").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("4 * 6 = 24"));
    }
    @Test
    public void subtractsTwoNumbers() throws Exception {
        this.mvc.perform(get("/math/calculate?operation=subtract&x=4&y=6").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("4 - 6 = -2"));
    }
    @Test
    public void divideTwoNumbers() throws Exception {
        this.mvc.perform(get("/math/calculate?operation=divide&x=30&y=5").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("30 / 5 = 6"));

    }
//    @Test
//    public void sumsMultipleNumbers() throws Exception {
//        this.mvc.perform(get("/math/sum?n=4&n=5&n=6").accept(MediaType.TEXT_PLAIN))
//                .andExpect(status().isOk())
//                .andExpect(content().string("4 + 5 + 6 = 15"));
//
//    }
//
    @Test
    public void returnVolOnPost() throws Exception {
        this.mvc.perform(post("/math/volume/3/4/5"))
                .andExpect(status().isOk())
                .andExpect(content().string("The volume of a 3x4x5 rectangle is 60"));

    }
    @Test
    public void returnVolOnGet() throws Exception {
        this.mvc.perform(get("/math/volume/3/4/5"))
                .andExpect(status().isOk())
                .andExpect(content().string("The volume of a 3x4x5 rectangle is 60"));

    }
    @Test
    public void returnVolOnPatch() throws Exception {
        this.mvc.perform(patch("/math/volume/3/4/5"))
                .andExpect(status().isOk())
                .andExpect(content().string("The volume of a 3x4x5 rectangle is 60"));

    }

    @Test
    public void getDataFromFormRect() throws Exception {
        this.mvc.perform(post("/math/area")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("type","rectangle" )
                .param("width", "7" )
                .param("height","4" )
                )
                .andExpect(status().isOk())
                .andExpect(content().string("Area of a 4x7 rectangle is 28"));
    }
    @Test
    public void getDataFromFormCircle() throws Exception {
        this.mvc.perform(post("/math/area")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("type","circle" )
                .param("radius", "4" ))
                .andExpect(status().isOk())
                .andExpect(content().string("Area of a circle with a radius of 4 is 50.26548"));
    }
    @Test
    public void getDataFromFormInvalid() throws Exception {
        this.mvc.perform(post("/math/area")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("type","circle" )
                .param("radius", "4" )
                .param("width", "4" ))
                .andExpect(status().isOk())
                .andExpect(content().string("Invalid"));
    }


}

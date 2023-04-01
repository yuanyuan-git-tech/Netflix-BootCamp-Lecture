package com.example.utilityapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@WebMvcTest(CalculatorController.class)
public class CalculatorControllerTest {

    // Wiring in the MockMvc object
    @Autowired
    private MockMvc mockMvc;

    // ObjectMapper used to convert Java objects to JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();

    // Testing GET calculator/divide/?value1={value1}&value2={value2}
    @Test
    public void shouldDivide() throws Exception {

        double expectedResult = 5;
        String outputJson = mapper.writeValueAsString(expectedResult);

        mockMvc.perform(get("/calculator/divide/?value1=125&value2=25"))
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    // Testing GET calculator/divide/?value1={value1}&value2={value2}
    @Test
    public void shouldDivideFractional() throws Exception {

        double expectedResult = 2.5;
        String outputJson = mapper.writeValueAsString(expectedResult);

        mockMvc.perform(get("/calculator/divide/?value1=5&value2=2"))
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    // Testing GET calculator/divide/?value1={value1}&value2={value2}
    @Test
    public void shouldHandleDivideByZero() throws Exception {

        mockMvc.perform(get("/calculator/divide/?value1=1&value2=0"))
                .andExpect(status().is4xxClientError());
    }

    // Testing GET calculator/isperfectsquare/{value1}
    @Test
    public void shouldDeterminePerfectSquare() throws Exception {

        mockMvc.perform(get("/calculator/isperfectsquare/9"))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }

    // Testing GET calculator/isperfectsquare/{value1}
    @Test
    public void shouldDetermineNonPerfectSquare() throws Exception {

        mockMvc.perform(get("/calculator/isperfectsquare/11"))
                .andExpect(status().isOk())
                .andExpect(content().string("false"));
    }

    // Testing GET calculator/factorial/{value1}
    @Test
    public void shouldComputeFactorial() throws Exception {

        int expectedResult = 6;
        String outputJson = mapper.writeValueAsString(expectedResult);

        mockMvc.perform(get("/calculator/factorial/3"))
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    // Testing GET calculator/factorial/{value1}
    @Test
    public void shouldHandleInvalidFactorial() throws Exception {

        mockMvc.perform(get("/calculator/factorial/-3"))
                .andExpect(status().is4xxClientError());
    }
}

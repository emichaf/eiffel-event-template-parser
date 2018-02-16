package com.ericsson.eiffel.remrem.publish.service.test;


import com.ericsson.eiffel.remrem.publish.controller.ProducerController;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.File;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Ignore("not ready yet")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration
public class ProducerController2Test {

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @Configuration
    @EnableAutoConfiguration
    public static class Config {
        @Bean
        public ProducerController apiController() {
            return new ProducerController();
        }
    }

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testGetSummary() throws Exception {
        final String inputFilePathData = "src/test/resources/test_data_for_parsing_EiffelActivityFinishedEvent.json";
        String dataToBeParsed = FileUtils.readFileToString(new File(inputFilePathData), "UTF-8");
        ObjectMapper mapper = new ObjectMapper();
        JsonNode dataToBeParsedJson = mapper.readTree(dataToBeParsed);

        mockMvc.perform(post("/fetchparsevalues")
                .param(String.valueOf(dataToBeParsedJson), "EiffelActivityFinishedEvent")
              //  .content()
                .accept(MediaType.APPLICATION_JSON_VALUE))
          //      .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
          //      .andExpect(jsonPath("$.first", is(1)))
                .andReturn();
        ;
    }
}
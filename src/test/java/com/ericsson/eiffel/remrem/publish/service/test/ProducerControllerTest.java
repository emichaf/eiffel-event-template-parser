package com.ericsson.eiffel.remrem.publish.service.test;

import com.ericsson.eiffel.remrem.publish.controller.ProducerController;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileReader;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@Ignore("not ready yet")
@RunWith(SpringRunner.class)
public class ProducerControllerTest {
    @Mock
    RestTemplate restTemplate;

    @InjectMocks
    ProducerController unit = new ProducerController();

    @Mock
    JsonNode body;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    ResponseEntity responseOK = new ResponseEntity("ok", HttpStatus.OK);


    @SuppressWarnings({ "rawtypes", "unchecked" })
    ResponseEntity responseBad = new ResponseEntity("ok", HttpStatus.NOT_FOUND);


    @Before
    public void setUp() throws Exception {
       /*
        MockitoAnnotations.initMocks(this);
        unit.setRestTemplate(restTemplate);

        File file = new File("src/integration-test/resources/EiffelActivityFinishedEvent.json");
        JsonParser parser = new JsonParser();
        JsonObject json = parser.parse(new FileReader(file)).getAsJsonObject();


        when(messageService.send(Matchers.anyString(), Matchers.any(MsgService.class), Matchers.anyString(),
                Matchers.anyString(), Matchers.anyString())).thenReturn(res);
        when(body.getAsJsonObject()).thenReturn(json);
*/
    }


    @SuppressWarnings("unchecked")
    @Test
    public void testRestTemplateCallFail() throws Exception {
        final String inputFilePathData = "src/test/resources/test_data_for_parsing_EiffelActivityFinishedEvent.json";
        final String inputFilePathExpectedData = "src/test/resources/expected_parsed_EiffelActivityFinishedEvent.json";
        String expectedDocument = FileUtils.readFileToString(new File(inputFilePathExpectedData), "UTF-8");

        String dataToBeParsed = FileUtils.readFileToString(new File(inputFilePathData), "UTF-8");

        ObjectMapper mapper = new ObjectMapper();
        JsonNode dataToBeParsedJson = mapper.readTree(dataToBeParsed);
        JsonNode expectedJson = mapper.readTree(expectedDocument);

        String inCorrectURL = "/doitx";
        when(restTemplate.postForEntity(Mockito.contains(inCorrectURL), Mockito.<HttpEntity<String>>any(),
                Mockito.eq(String.class), Mockito.anyMap())).thenReturn(responseBad);

        //JsonNode actualParsedEventJson = unit.parseValuesInEventTemplate(dataToBeParsedJson, "EiffelActivityFinishedEvent");

        ResponseEntity<JsonNode> elem = unit.parseValuesInEventTemplate(dataToBeParsedJson, "EiffelActivityFinishedEvent");

       // JSONAssert.assertEquals(expectedJson.toString(), actualParsedEventJson.toString(), true);

        assertEquals(elem.getStatusCode(), HttpStatus.NOT_FOUND);

    }
//    public JsonNode parseValuesInEventTemplate(@RequestBody JsonNode bodyJson, @RequestParam("msgType") String msgType) {


}
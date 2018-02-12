package com.ericsson.eiffel.remrem.publish.service.test;

import com.ericsson.eiffel.remrem.publish.service.EventTemplateHandler;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.io.File;

@RunWith(SpringJUnit4ClassRunner.class)
public class EventTemplateHandlerTest {

    private static Logger log = LoggerFactory.getLogger(EventTemplateHandlerTest.class);
    static private final String inputFilePathData = "src/test/resources/test_data_for_parsing_EiffelActivityFinishedEvent.json";
    static private final String inputFilePathExpectedData = "src/test/resources/expected_parsed_EiffelActivityFinishedEvent.json";

    @Test
    public void testParseEiffelActivityFinishedEvent() {
        try {
            String EventName = "EiffelActivityFinishedEvent";
            EventTemplateHandler eventTemplateHandler = new EventTemplateHandler();
            String dataToBeParsed = FileUtils.readFileToString(new File(inputFilePathData), "UTF-8");
            String expectedDocument = FileUtils.readFileToString(new File(inputFilePathExpectedData), "UTF-8");

            ObjectMapper mapper = new ObjectMapper();
            JsonNode expectedJson = mapper.readTree(expectedDocument);

            JsonNode actualParsedEventJson = eventTemplateHandler.eventTemplateParser(dataToBeParsed, EventName);

            System.out.println("expectedJsonString: " + expectedJson.toString());
            System.out.println("actualParsedEventJson: " + actualParsedEventJson.toString());

            JSONAssert.assertEquals(expectedJson.toString(), actualParsedEventJson.toString(), true);

        } catch (Exception e) {
            log.info(e.getMessage(),e);
        }

    }
}

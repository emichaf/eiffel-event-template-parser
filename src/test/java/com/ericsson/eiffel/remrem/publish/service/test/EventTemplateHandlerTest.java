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
    static private final String inputFilePathData = "src/test/resources/";
    static private final String inputFilePathExpectedData = "src/test/resources/";

    @Test
    public void testParseEiffelActivityFinishedEvent() {
        try {
            String EventName = "EiffelActivityFinishedEvent";
            EventTemplateHandler eventTemplateHandler = new EventTemplateHandler();
            String dataToBeParsed = FileUtils.readFileToString(new File(inputFilePathData+"test_data_for_parsing_"+EventName+".json"), "UTF-8");
            String expectedDocument = FileUtils.readFileToString(new File(inputFilePathExpectedData+"expected_parsed_"+EventName+".json"), "UTF-8");

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



    @Test
    public void testParseEiffelSourceChangeCreatedEvent() {
        try {
            String EventName = "EiffelSourceChangeCreatedEvent";
            EventTemplateHandler eventTemplateHandler = new EventTemplateHandler();
            String dataToBeParsed = FileUtils.readFileToString(new File(inputFilePathData+"test_data_for_parsing_"+EventName+".json"), "UTF-8");
            String expectedDocument = FileUtils.readFileToString(new File(inputFilePathExpectedData+"expected_parsed_"+EventName+".json"), "UTF-8");

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


    @Test
    public void testParseEiffelSourceChangeSubmittedEvent() {
        try {
            String EventName = "EiffelSourceChangeSubmittedEvent";
            EventTemplateHandler eventTemplateHandler = new EventTemplateHandler();
            String dataToBeParsed = FileUtils.readFileToString(new File(inputFilePathData+"test_data_for_parsing_"+EventName+".json"), "UTF-8");
            String expectedDocument = FileUtils.readFileToString(new File(inputFilePathExpectedData+"expected_parsed_"+EventName+".json"), "UTF-8");

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



    @Test
    public void testParseEiffelCompositionDefinedEvent() {
        try {
            String EventName = "EiffelCompositionDefinedEvent";
            EventTemplateHandler eventTemplateHandler = new EventTemplateHandler();
            String dataToBeParsed = FileUtils.readFileToString(new File(inputFilePathData+"test_data_for_parsing_"+EventName+".json"), "UTF-8");
            String expectedDocument = FileUtils.readFileToString(new File(inputFilePathExpectedData+"expected_parsed_"+EventName+".json"), "UTF-8");

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


    @Test
    public void testParseEiffelActivityTriggeredEvent() {
        try {
            String EventName = "EiffelActivityTriggeredEvent";
            EventTemplateHandler eventTemplateHandler = new EventTemplateHandler();
            String dataToBeParsed = FileUtils.readFileToString(new File(inputFilePathData+"test_data_for_parsing_"+EventName+".json"), "UTF-8");
            String expectedDocument = FileUtils.readFileToString(new File(inputFilePathExpectedData+"expected_parsed_"+EventName+".json"), "UTF-8");

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



    @Test
    public void testParseEiffelActivityStartedEvent() {
        try {
            String EventName = "EiffelActivityStartedEvent";
            EventTemplateHandler eventTemplateHandler = new EventTemplateHandler();
            String dataToBeParsed = FileUtils.readFileToString(new File(inputFilePathData+"test_data_for_parsing_"+EventName+".json"), "UTF-8");
            String expectedDocument = FileUtils.readFileToString(new File(inputFilePathExpectedData+"expected_parsed_"+EventName+".json"), "UTF-8");

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


    @Test
    public void testParseEiffelActivityCanceledEvent() {
        try {
            String EventName = "EiffelActivityCanceledEvent";
            EventTemplateHandler eventTemplateHandler = new EventTemplateHandler();
            String dataToBeParsed = FileUtils.readFileToString(new File(inputFilePathData+"test_data_for_parsing_"+EventName+".json"), "UTF-8");
            String expectedDocument = FileUtils.readFileToString(new File(inputFilePathExpectedData+"expected_parsed_"+EventName+".json"), "UTF-8");

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



    @Test
    public void testParseEiffelArtifactCreatedEvent() {
        try {
            String EventName = "EiffelArtifactCreatedEvent";
            EventTemplateHandler eventTemplateHandler = new EventTemplateHandler();
            String dataToBeParsed = FileUtils.readFileToString(new File(inputFilePathData+"test_data_for_parsing_"+EventName+".json"), "UTF-8");
            String expectedDocument = FileUtils.readFileToString(new File(inputFilePathExpectedData+"expected_parsed_"+EventName+".json"), "UTF-8");

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



    @Test
    public void testParseEiffelTestCaseTriggeredEvent() {
        try {
            String EventName = "EiffelTestCaseTriggeredEvent";
            EventTemplateHandler eventTemplateHandler = new EventTemplateHandler();
            String dataToBeParsed = FileUtils.readFileToString(new File(inputFilePathData+"test_data_for_parsing_"+EventName+".json"), "UTF-8");
            String expectedDocument = FileUtils.readFileToString(new File(inputFilePathExpectedData+"expected_parsed_"+EventName+".json"), "UTF-8");

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




    @Test
    public void testParseEiffelTestCaseStartedEvent() {
        try {
            String EventName = "EiffelTestCaseStartedEvent";
            EventTemplateHandler eventTemplateHandler = new EventTemplateHandler();
            String dataToBeParsed = FileUtils.readFileToString(new File(inputFilePathData+"test_data_for_parsing_"+EventName+".json"), "UTF-8");
            String expectedDocument = FileUtils.readFileToString(new File(inputFilePathExpectedData+"expected_parsed_"+EventName+".json"), "UTF-8");

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


    @Test
    public void testParseEiffelTestCaseFinishedEvent() {
        try {
            String EventName = "EiffelTestCaseFinishedEvent";
            EventTemplateHandler eventTemplateHandler = new EventTemplateHandler();
            String dataToBeParsed = FileUtils.readFileToString(new File(inputFilePathData+"test_data_for_parsing_"+EventName+".json"), "UTF-8");
            String expectedDocument = FileUtils.readFileToString(new File(inputFilePathExpectedData+"expected_parsed_"+EventName+".json"), "UTF-8");

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


    @Test
    public void testParseEiffelConfidenceLevelModifiedEvent() {
        try {
            String EventName = "EiffelConfidenceLevelModifiedEvent";
            EventTemplateHandler eventTemplateHandler = new EventTemplateHandler();
            String dataToBeParsed = FileUtils.readFileToString(new File(inputFilePathData+"test_data_for_parsing_"+EventName+".json"), "UTF-8");
            String expectedDocument = FileUtils.readFileToString(new File(inputFilePathExpectedData+"expected_parsed_"+EventName+".json"), "UTF-8");

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


    @Test
    public void testParseEiffelAnnouncementPublishedEvent() {
        try {
            String EventName = "EiffelAnnouncementPublishedEvent";
            EventTemplateHandler eventTemplateHandler = new EventTemplateHandler();
            String dataToBeParsed = FileUtils.readFileToString(new File(inputFilePathData+"test_data_for_parsing_"+EventName+".json"), "UTF-8");
            String expectedDocument = FileUtils.readFileToString(new File(inputFilePathExpectedData+"expected_parsed_"+EventName+".json"), "UTF-8");

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



    @Test
    public void testParseEiffelArtifactReusedEvent() {
        try {
            String EventName = "EiffelArtifactReusedEvent";
            EventTemplateHandler eventTemplateHandler = new EventTemplateHandler();
            String dataToBeParsed = FileUtils.readFileToString(new File(inputFilePathData+"test_data_for_parsing_"+EventName+".json"), "UTF-8");
            String expectedDocument = FileUtils.readFileToString(new File(inputFilePathExpectedData+"expected_parsed_"+EventName+".json"), "UTF-8");

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


    @Test
    public void testParseEiffelEnvironmentDefinedEvent() {
        try {
            String EventName = "EiffelEnvironmentDefinedEvent";
            EventTemplateHandler eventTemplateHandler = new EventTemplateHandler();
            String dataToBeParsed = FileUtils.readFileToString(new File(inputFilePathData+"test_data_for_parsing_"+EventName+".json"), "UTF-8");
            String expectedDocument = FileUtils.readFileToString(new File(inputFilePathExpectedData+"expected_parsed_"+EventName+".json"), "UTF-8");

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



    @Test
    public void testParseEiffelFlowContextDefinedEvent() {
        try {
            String EventName = "EiffelFlowContextDefinedEvent";
            EventTemplateHandler eventTemplateHandler = new EventTemplateHandler();
            String dataToBeParsed = FileUtils.readFileToString(new File(inputFilePathData+"test_data_for_parsing_"+EventName+".json"), "UTF-8");
            String expectedDocument = FileUtils.readFileToString(new File(inputFilePathExpectedData+"expected_parsed_"+EventName+".json"), "UTF-8");

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

    @Test
    public void testParseEiffelIssueVerifiedEvent() {
        try {
            String EventName = "EiffelIssueVerifiedEvent";
            EventTemplateHandler eventTemplateHandler = new EventTemplateHandler();
            String dataToBeParsed = FileUtils.readFileToString(new File(inputFilePathData+"test_data_for_parsing_"+EventName+".json"), "UTF-8");
            String expectedDocument = FileUtils.readFileToString(new File(inputFilePathExpectedData+"expected_parsed_"+EventName+".json"), "UTF-8");

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


    @Test
    public void testParseEiffelTestCaseCanceledEvent() {
        try {
            String EventName = "EiffelTestCaseCanceledEvent";
            EventTemplateHandler eventTemplateHandler = new EventTemplateHandler();
            String dataToBeParsed = FileUtils.readFileToString(new File(inputFilePathData+"test_data_for_parsing_"+EventName+".json"), "UTF-8");
            String expectedDocument = FileUtils.readFileToString(new File(inputFilePathExpectedData+"expected_parsed_"+EventName+".json"), "UTF-8");

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


    @Test
    public void testParseEiffelTestExecutionRecipeCollectionCreatedEvent() {
        try {
            String EventName = "EiffelTestExecutionRecipeCollectionCreatedEvent";
            EventTemplateHandler eventTemplateHandler = new EventTemplateHandler();
            String dataToBeParsed = FileUtils.readFileToString(new File(inputFilePathData+"test_data_for_parsing_"+EventName+".json"), "UTF-8");
            String expectedDocument = FileUtils.readFileToString(new File(inputFilePathExpectedData+"expected_parsed_"+EventName+".json"), "UTF-8");

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


    @Test
    public void testParseEiffelTestSuiteFinishedEvent() {
        try {
            String EventName = "EiffelTestSuiteFinishedEvent";
            EventTemplateHandler eventTemplateHandler = new EventTemplateHandler();
            String dataToBeParsed = FileUtils.readFileToString(new File(inputFilePathData+"test_data_for_parsing_"+EventName+".json"), "UTF-8");
            String expectedDocument = FileUtils.readFileToString(new File(inputFilePathExpectedData+"expected_parsed_"+EventName+".json"), "UTF-8");

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


    @Test
    public void testParseEiffelTestSuiteStartedEvent() {
        try {
            String EventName = "EiffelTestSuiteStartedEvent";
            EventTemplateHandler eventTemplateHandler = new EventTemplateHandler();
            String dataToBeParsed = FileUtils.readFileToString(new File(inputFilePathData+"test_data_for_parsing_"+EventName+".json"), "UTF-8");
            String expectedDocument = FileUtils.readFileToString(new File(inputFilePathExpectedData+"expected_parsed_"+EventName+".json"), "UTF-8");

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



    @Test
    public void testParseEiffelAlertAcknowledgedEvent() {
        try {
            String EventName = "EiffelAlertAcknowledgedEvent";
            EventTemplateHandler eventTemplateHandler = new EventTemplateHandler();
            String dataToBeParsed = FileUtils.readFileToString(new File(inputFilePathData+"test_data_for_parsing_"+EventName+".json"), "UTF-8");
            String expectedDocument = FileUtils.readFileToString(new File(inputFilePathExpectedData+"expected_parsed_"+EventName+".json"), "UTF-8");

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


    @Test
    public void testParseEiffelAlertCeasedEvent() {
        try {
            String EventName = "EiffelAlertCeasedEvent";
            EventTemplateHandler eventTemplateHandler = new EventTemplateHandler();
            String dataToBeParsed = FileUtils.readFileToString(new File(inputFilePathData+"test_data_for_parsing_"+EventName+".json"), "UTF-8");
            String expectedDocument = FileUtils.readFileToString(new File(inputFilePathExpectedData+"expected_parsed_"+EventName+".json"), "UTF-8");

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


    @Test
    public void testParseEiffelAlertRaisedEvent() {
        try {
            String EventName = "EiffelAlertRaisedEvent";
            EventTemplateHandler eventTemplateHandler = new EventTemplateHandler();
            String dataToBeParsed = FileUtils.readFileToString(new File(inputFilePathData+"test_data_for_parsing_"+EventName+".json"), "UTF-8");
            String expectedDocument = FileUtils.readFileToString(new File(inputFilePathExpectedData+"expected_parsed_"+EventName+".json"), "UTF-8");

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

    @Test
    public void testParseEiffelArtifactDeployedEvent() {
        try {
            String EventName = "EiffelArtifactDeployedEvent";
            EventTemplateHandler eventTemplateHandler = new EventTemplateHandler();
            String dataToBeParsed = FileUtils.readFileToString(new File(inputFilePathData+"test_data_for_parsing_"+EventName+".json"), "UTF-8");
            String expectedDocument = FileUtils.readFileToString(new File(inputFilePathExpectedData+"expected_parsed_"+EventName+".json"), "UTF-8");

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

    @Test
    public void testParseEiffelServiceAllocatedEvent() {
        try {
            String EventName = "EiffelServiceAllocatedEvent";
            EventTemplateHandler eventTemplateHandler = new EventTemplateHandler();
            String dataToBeParsed = FileUtils.readFileToString(new File(inputFilePathData+"test_data_for_parsing_"+EventName+".json"), "UTF-8");
            String expectedDocument = FileUtils.readFileToString(new File(inputFilePathExpectedData+"expected_parsed_"+EventName+".json"), "UTF-8");

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


    @Test
    public void testParseEiffelServiceDeployedEvent() {
        try {
            String EventName = "EiffelServiceDeployedEvent";
            EventTemplateHandler eventTemplateHandler = new EventTemplateHandler();
            String dataToBeParsed = FileUtils.readFileToString(new File(inputFilePathData+"test_data_for_parsing_"+EventName+".json"), "UTF-8");
            String expectedDocument = FileUtils.readFileToString(new File(inputFilePathExpectedData+"expected_parsed_"+EventName+".json"), "UTF-8");

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


    @Test
    public void testParseEiffelServiceDiscontinuedEvent() {
        try {
            String EventName = "EiffelServiceDiscontinuedEvent";
            EventTemplateHandler eventTemplateHandler = new EventTemplateHandler();
            String dataToBeParsed = FileUtils.readFileToString(new File(inputFilePathData+"test_data_for_parsing_"+EventName+".json"), "UTF-8");
            String expectedDocument = FileUtils.readFileToString(new File(inputFilePathExpectedData+"expected_parsed_"+EventName+".json"), "UTF-8");

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


    @Test
    public void testParseEiffelServiceReturnedEvent() {
        try {
            String EventName = "EiffelServiceReturnedEvent";
            EventTemplateHandler eventTemplateHandler = new EventTemplateHandler();
            String dataToBeParsed = FileUtils.readFileToString(new File(inputFilePathData+"test_data_for_parsing_"+EventName+".json"), "UTF-8");
            String expectedDocument = FileUtils.readFileToString(new File(inputFilePathExpectedData+"expected_parsed_"+EventName+".json"), "UTF-8");

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


    @Test
    public void testParseEiffelServiceStartedEvent() {
        try {
            String EventName = "EiffelServiceStartedEvent";
            EventTemplateHandler eventTemplateHandler = new EventTemplateHandler();
            String dataToBeParsed = FileUtils.readFileToString(new File(inputFilePathData+"test_data_for_parsing_"+EventName+".json"), "UTF-8");
            String expectedDocument = FileUtils.readFileToString(new File(inputFilePathExpectedData+"expected_parsed_"+EventName+".json"), "UTF-8");

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

    @Test
    public void testParseEiffelServiceStoppedEvent() {
        try {
            String EventName = "EiffelServiceStoppedEvent";
            EventTemplateHandler eventTemplateHandler = new EventTemplateHandler();
            String dataToBeParsed = FileUtils.readFileToString(new File(inputFilePathData+"test_data_for_parsing_"+EventName+".json"), "UTF-8");
            String expectedDocument = FileUtils.readFileToString(new File(inputFilePathExpectedData+"expected_parsed_"+EventName+".json"), "UTF-8");

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

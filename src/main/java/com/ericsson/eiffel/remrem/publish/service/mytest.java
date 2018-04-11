package com.ericsson.eiffel.remrem.publish.service;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class mytest {

    public static void main(String[] args) {

        //String EventName = "EiffelActivityFinishedEvent";
        //String EventName = "EiffelSourceChangeSubmittedEvent";
        //String EventName = "EiffelSourceChangeCreatedEvent";
        //String EventName = "EiffelCompositionDefinedEvent";
        //String EventName = "EiffelActivityTriggeredEvent";
        //String EventName = "EiffelActivityStartedEvent";
        //String EventName = "EiffelActivityCanceledEvent";
        //String EventName = "EiffelArtifactCreatedEvent";
        //String EventName = "EiffelTestCaseTriggeredEvent";
        //String EventName = "EiffelTestCaseStartedEvent";
        //String EventName = "EiffelTestCaseFinishedEvent";
        //String EventName ="EiffelConfidenceLevelModifiedEvent";
        //String EventName ="EiffelAnnouncementPublishedEvent";
        //String EventName ="EiffelArtifactReusedEvent";
        //String EventName ="EiffelEnvironmentDefinedEvent";
        //String EventName ="EiffelFlowContextDefinedEvent";
        //String EventName ="EiffelIssueVerifiedEvent";
        //String EventName ="EiffelTestCaseCanceledEvent";
        //String EventName ="EiffelTestExecutionRecipeCollectionCreatedEvent";
        //String EventName ="EiffelTestSuiteFinishedEvent";
        //String EventName ="EiffelTestSuiteStartedEvent";

        // Operation extension
        //String EventName ="EiffelAlertAcknowledgedEvent";
        //String EventName ="EiffelAlertCeasedEvent";
        //String EventName ="EiffelAlertRaisedEvent";
        //String EventName ="EiffelArtifactDeployedEvent";
        //String EventName ="EiffelServiceAllocatedEvent";
        //String EventName ="EiffelServiceDeployedEvent";
        //String EventName ="EiffelServiceDiscontinuedEvent";
        //String EventName ="EiffelServiceReturnedEvent";
        //String EventName ="EiffelServiceStartedEvent";
        String EventName ="EiffelServiceStoppedEvent";

        EventTemplateHandler eventTemplateHandler = new EventTemplateHandler();

        // dummy data for test
        String FetchDummyData = fetchDummyData("./testdummydata/test_data_for_parsing_" +EventName+".json");

        System.out.println( eventTemplateHandler.eventTemplateParser(FetchDummyData, EventName).toString());

    }

    // FetchEventSchema
    public static String fetchDummyEventEventSchema(String eventname){
        String EventSchemaString = null;
        try {
            EventSchemaString = new String(Files.readAllBytes(Paths.get("./testschemas/" +eventname+".json")), StandardCharsets.UTF_8);
        }catch (IOException e1) {
            System.out.println(e1.toString());
        }
        return EventSchemaString;
    }

    // FetchEventTemplate
    public static String fetchDummyEventTemplate(String eventname){
        String TemplateString = null;
        try {
            TemplateString = new String(Files.readAllBytes(Paths.get("./testtemplates/"+eventname.toLowerCase()+".json")), StandardCharsets.UTF_8);
        }catch (IOException e1) {
            System.out.println(e1.toString());
        }
        return TemplateString;
    }

    // dummy data
    public static String fetchDummyData(String filename){
        String DummyDataString = null;
        try {
            DummyDataString = new String(Files.readAllBytes(Paths.get(filename)), StandardCharsets.UTF_8);
        }catch (IOException e1) {
            System.out.println(e1.toString());
        }
        return DummyDataString;
    }
}

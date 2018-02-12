package com.ericsson.eiffel.remrem.publish.service;


public class mytest {

    public static void main(String[] args) {
        String EventName = "EiffelActivityFinishedEvent";

        EventTemplateHandler mytemplatehandler = new EventTemplateHandler();

        // Semantics
        String Template = mytemplatehandler.accessFileInSemanticJar(mytemplatehandler.EVENT_TEMPLATE_PATH + EventName.toLowerCase() + ".json");

        // TODO: remove dummy data
        String FetchDummyData = mytemplatehandler.fetchDummyData("./testdummydata/dummy_data_" +EventName+".json");

        System.out.println( mytemplatehandler.templateParser(Template, FetchDummyData, EventName).toString());

    }
}

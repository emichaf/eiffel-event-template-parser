package com.ericsson.eiffel.remrem.publish.service;

import static com.ericsson.eiffel.remrem.publish.service.EventParserTest.*;

/**
 * Created by EMICHAF on 2018-02-12.
 */
public class mytest {

    public static void main(String[] args) {
        String EventName = "EiffelActivityFinishedEvent";

        EventTemplateHandler mytemplatehandler = new EventTemplateHandler();

        // Semantics
        String Template = accessFileInSemanticJar(mytemplatehandler.EVENT_TEMPLATE_PATH + EventName.toLowerCase() + ".json");

        // TODO: remove dummy data
        String FetchDummyData = fetchDummyData("./testdummydata/dummy_data_" +EventName+".json");

        templateParser(Template, FetchDummyData, EventName);
    }
}

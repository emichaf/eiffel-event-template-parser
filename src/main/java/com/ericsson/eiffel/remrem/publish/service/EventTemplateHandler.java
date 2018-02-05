package com.ericsson.eiffel.remrem.publish.service;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.spi.json.JacksonJsonNodeJsonProvider;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;
import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class EventTemplateHandler {
    private static final Configuration configuration = Configuration.builder()
            .jsonProvider(new JacksonJsonNodeJsonProvider())
            .mappingProvider(new JacksonMappingProvider())
            .build();

    // Path in Semantics JAR
    private static final String EVENT_TEMPLATE_PATH = "templates/";
    private static final String EVENT_SCHEMA_PATH = "schemas/input/";

    public static void main(String[] args) {
        String EventName = "EiffelActivityFinishedEvent";

        // Semantics faulty at the moment use dummy below
        //String Template = accessFileInSemanticJar(EVENT_TEMPLATE_PATH + EventName.toLowerCase() + ".json");
        //TODO: to be removed
        String Template = fetchDummyEventTemplate(EventName);

        // TODO: remove dummy data
        String FetchDummyData = fetchDummyData("./testdummydata/dummy_data_" +EventName+".json");

        templateParser(Template, FetchDummyData, EventName);
    }

    //TODO: to be removed
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

    //TODO: to be removed
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

    // TemplateParser
    public static void templateParser(String event_template, String json_data , String event_name){
        JsonNode updatedJson = null;
        JsonFactory factory = new JsonFactory();
        ObjectMapper mapper = new ObjectMapper(factory);
        JsonNode rootNode = null;
        try {
            rootNode = mapper.readTree(json_data);
            updatedJson = mapper.readValue(event_template, JsonNode.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // For each key/value pair for parsing to template
        Iterator<Map.Entry<String,JsonNode>> fieldsIterator = rootNode.fields();
        while (fieldsIterator.hasNext()) {
            Map.Entry<String,JsonNode> field = fieldsIterator.next();
            //System.out.println("Key: " + field.getKey() + "\tValue:" + field.getValue());

            // Parse values to template
            // Check if POJO required for update in event template
            Pattern p = Pattern.compile("\\[\\d+\\]$");  // if ends with [d+]
            Matcher m = p.matcher(field.getKey());
            if(m.find()){
                String mykey = "$." + templateParamHandler(field.getKey());
                String myvalue = field.getValue().toString();
            try {
                    // Fetch Class name in Event Schema
                    // TODO : remove dummy
                    //String event_schema = fetchDummyEventEventSchema(event_name);
                    String event_schema = accessFileInSemanticJar(EVENT_SCHEMA_PATH + event_name + ".json");

                    // Filter javatype from Event Schema = class name
                    JsonNode Json_from_schema = JsonPath.using(configuration).parse(event_schema.toString()).read(schemaClassPathHandler(field.getKey().replaceAll("\\[\\d+\\]$", "")));
                    String myclass = Json_from_schema.toString().replace("[","").replace("]","").replace("\"","");  // Ex ["com.ericsson.eiffel.semantics.events.PersistentLog"] to com.ericsson.eiffel.semantics.events.PersistentLog

                    // Initiate Class via reflection and map values - POJO
                    Class myClass = Class.forName(myclass);
                    Object mapped_2_pojo = mapper.readValue(myvalue, myClass);

                    //updatedJson = JsonPath_Handler_Add(updatedJson, mykey, mapped_2_pojo);
                    updatedJson = jsonPathHandlerSet(updatedJson, mykey, mapped_2_pojo);

                } catch (ClassNotFoundException e) {
                    //e.printStackTrace();
                    // No POJO required for adding new item in Array (ie no key/value pairs)
                    updatedJson = jsonPathHandlerSet(updatedJson, mykey, myvalue.toString().replace("\"",""));
                } catch (JsonParseException e) {
                    e.printStackTrace();
                } catch (JsonMappingException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }else{  // No POJO needed for update
                    String mykey = "$." + templateParamHandler(field.getKey());
                    Object myvalue = field.getValue();
                    updatedJson = jsonPathHandlerSet(updatedJson, mykey, myvalue);
            }
        } // while

        System.out.println(updatedJson.toString());
    }

    public static JsonNode jsonPathHandlerAdd(JsonNode updated_Json, String jsonkey, Object pojo){
        updated_Json = JsonPath.using(configuration).parse(updated_Json.toString()).add(jsonkey, pojo).json();
        return updated_Json;
    }

    public static JsonNode jsonPathHandlerSet(JsonNode updated_Json, String jsonkey, Object Jsonvalue){
        updated_Json = JsonPath.using(configuration).parse(updated_Json.toString()).set(jsonkey, Jsonvalue).json();
        return updated_Json;
    }

    public static String templateParamHandler(String jsonkey){
        String[] strArray = jsonkey.split("\\.");
        Pattern p = Pattern.compile("links\\[\\d+\\]$");  // if ends with [d+]
        Matcher m = p.matcher(strArray[0]);
        try {
            if (strArray[0].equals("meta")) {
                jsonkey = "msgParams." + jsonkey;
            } else if (strArray[0].equals("data") || m.find()) {
                jsonkey = "eventParams." + jsonkey;
            } else {
                throw new IllegalArgumentException("jsonkey in data to be parsed is not valid : " + jsonkey);
            }
        }catch (ArrayIndexOutOfBoundsException e){
            throw new IllegalArgumentException("jsonkey in data to be parsed is not valid : " + jsonkey);
        }
      return jsonkey;
    }

    public static String schemaClassPathHandler(String jsonkey){
        String[] strArray = jsonkey.split("\\.");
        jsonkey = "";
        for (String s: strArray) {
            jsonkey = jsonkey + s+"[*].";
        }
        jsonkey = "$.properties." + jsonkey + "javaType";
        return jsonkey;
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

    public static String accessFileInSemanticJar(String path) {
        String result="";
        // this is the path within the jar file
        InputStream input = EventTemplateHandler.class.getResourceAsStream(path);
        if (input == null) {
            input = EventTemplateHandler.class.getClassLoader().getResourceAsStream(path);
            try {
                result= IOUtils.toString(input, StandardCharsets.UTF_8);
                //System.out.println(result.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
} // class EventHandler

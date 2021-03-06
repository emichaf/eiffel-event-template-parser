package com.ericsson.eiffel.remrem.publish.controller;

import com.ericsson.eiffel.remrem.publish.service.EventTemplateHandler;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/*")
public class ProducerController {

    RestTemplate restTemplate = new RestTemplate();
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(value = "/startjenkins", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity startjenkins() {

        String url = "http://docker104-eiffel999.lmera.ericsson.se:8082/job/test3/build";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("json", "{\"parameter\": [{\"name\":\"PARAM1\", \"value\":'{\"metatags\":\"my_metatags_fromJava_Client\", \"metatags2\":\"my_metatags2_fromJava_Client\", \"metatags3\":\"my_metatags3_fromJava_Client\"}'}]}");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(params, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

        return response;
    }


    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(value = "/fetchparsevalues", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<JsonNode> parseValuesInEventTemplate(@RequestBody JsonNode bodyJson, @RequestParam("msgType") String msgType) {

        EventTemplateHandler eventTemplateHandler = new EventTemplateHandler();

        return new ResponseEntity<JsonNode>(eventTemplateHandler.eventTemplateParser(bodyJson.toString(), msgType), HttpStatus.OK);

    }


    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(value = "/doit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> doit(@RequestBody JsonNode bodyJson, @RequestParam("msgType") String msgType) {

        // TODO: handle other params like mp semantic
        String url = "http://docker104-eiffel999.lmera.ericsson.se:8096/generateAndPublish/?mp=eiffelsemantics&msgType="+msgType;

        // -- parse params in incoming request body -------------
        EventTemplateHandler eventTemplateHandler = new EventTemplateHandler();
        JsonNode parsedTemplate = eventTemplateHandler.eventTemplateParser(bodyJson.toString(), msgType);

        // ----- RemRem Gen & Pub -------------
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<JsonNode> requestGenAndPub = new HttpEntity<JsonNode>(bodyJson, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(url, parsedTemplate, String.class);

        return response;
    }





    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(value = "/doit2", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> doit2(@RequestBody JsonNode bodyJson, @RequestParam("msgType") String msgType) {

        // TODO: handle other params like mp semantic

        String url_gen = "http://docker104-eiffel999.lmera.ericsson.se:8095/eiffelsemantics?msgType="+msgType;
        String url_pub = "http://docker104-eiffel999.lmera.ericsson.se:8096/producer/msg/?mp=eiffelsemantics&msgType="+msgType;

        // -- parse params in incoming request body -------------
        EventTemplateHandler eventTemplateHandler = new EventTemplateHandler();
        JsonNode parsedTemplate = eventTemplateHandler.eventTemplateParser(bodyJson.toString(), msgType);

        // ---- RemRem Generate --------------
        HttpHeaders headers_gen = new HttpHeaders();
        headers_gen.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<JsonNode> requestGen = new HttpEntity<JsonNode>(bodyJson, headers_gen);

        ResponseEntity<JsonNode> response_gen = restTemplate.postForEntity(url_gen, parsedTemplate, JsonNode.class);

        // ---- RemRem Published --------------
        HttpHeaders headers_pub = new HttpHeaders();
        headers_pub.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<JsonNode> requestPub = new HttpEntity<JsonNode>(bodyJson, headers_pub);

        ResponseEntity<JsonNode> response_pub = restTemplate.postForEntity(url_pub, response_gen, JsonNode.class);

        //return new ResponseEntity<>(response_gen.toString(), HttpStatus.OK);

        //return response_gen;
        return response_pub;
    }



}





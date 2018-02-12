package com.ericsson.eiffel.remrem.publish.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
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
    public ResponseEntity fetchparsevalues() {

/*
        String url = "http://docker104-eiffel999.lmera.ericsson.se:8082/job/test3/build";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("json", "{\"parameter\": [{\"name\":\"PARAM1\", \"value\":'{\"metatags\":\"my_metatags_fromJava_Client\", \"metatags2\":\"my_metatags2_fromJava_Client\", \"metatags3\":\"my_metatags3_fromJava_Client\"}'}]}");


        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(params, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

        return response;
        */

return "hej";
    }


}





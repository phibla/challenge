package com.coup.api.web;


import com.coup.api.domain.OperationInput;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OperationControllerTest {


    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;


    HttpHeaders headers = new HttpHeaders();

    @Test
    public void calculateMinimumNumberOfFleetEngineers() throws Exception {

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(11);
        list.add(15);
        list.add(13);
        //OperationInput operationInput = new OperationInput(list, 9, 5);
        String operationInput = "{ \"scooters\": [11, 15, 13], \"C\": 9, \"P\": 5 }";

        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(operationInput, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/operation/calculateMinimumNumberOfFleetEngineers"),
                HttpMethod.POST, entity, String.class);

        String expected = "{\"fleet_engineers\":7}";

        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}
package com.SDETTest.SDETTest;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.springframework.core.io.ClassPathResource;
import picocli.CommandLine;

import java.net.URL;
import java.util.concurrent.Callable;

import static org.junit.Assert.assertEquals;

/*

This test checks that the endpoint does not accept anything but a int.  I added a checkExpectedStatus method to the HelperMethods class.

*/

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StewartTest4_getPeopleNotInt32Chars {

    private Response response = null; // Response object

    @Before
    public void setup() throws Exception {
        RestUtil.setBaseURI("http://localhost:8080/"); // Setup Base URI
        RestUtil.setBasePath("getPeople?fromId=*&toId=%"); // Setup Base Path
        RestUtil.setContentType(ContentType.JSON); // Setup Content Type
        response = RestUtil.getResponse();
    }

    @Test
    public void T01_StatusCodeTest() {
        /* I thought I would show that having a helper method that checks that response is not null then checks that it's also not a 500 or 200
        * might be a more fail proof method of checking for a 400, take a look at this checkStatus400 helper method*/
        boolean codeBool = HelperMethods.checkExpectedStatus(response, 400);
        Assert.assertTrue("The response code was not 400 as expected", codeBool);
    }

    @After
    public void afterTest() {
        // Reset Values
        RestUtil.resetBaseURI();
        RestUtil.resetBasePath();
    }

}

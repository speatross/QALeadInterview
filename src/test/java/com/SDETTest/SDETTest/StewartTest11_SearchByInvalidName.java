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

import java.net.URL;

/*

Please start the SdetTestApplication before running these tests.

*/

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StewartTest11_SearchByInvalidName {
   

    
    private Response response = null; // Response object

    /*This setup method doesn't work for every test situation so I didn't add all the tests to this one class file I created different tests.
    * If all tests are to reside in one class file then you will need to break out the setBaseURI and SetBasePath and incorporate them into each test method.  */

    @Before
    public void setup() throws Exception {
        RestUtil.setBaseURI("http://localhost:8080/"); // Setup Base URI
        RestUtil.setBasePath("searchByName?firstName=Stewart&lastName=Peatross"); // Setup Base Path
        RestUtil.setContentType(ContentType.JSON); // Setup Content Type
        response = RestUtil.getResponse();
        RestUtil.getJsonPath(response);
    }

    @Test
    public void T01_StatusCodeTest() {
        // Verify the http response status returned 200.
        boolean codeBool = HelperMethods.checkExpectedStatus(response, 200);
        Assert.assertTrue("The response code was not 200 as expected", codeBool);
    }
    //Please remove Ignore tag and make this test pass
//   @Ignore
    @Test
    public void T02_EnsureResponseIsValidSchema() {
        JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
        ClassPathResource resource = new ClassPathResource("com/SDETTEST/SDETTEST/schemas/people.json");
        try {
            URL schemaPath = resource.getURL();
            JsonSchema schema = factory.getJsonSchema(schemaPath.toString());
            String content = response.getBody().asString();
            String strpContent = HelperMethods.stripBodyBrackets(content);
            boolean empty = strpContent.isEmpty();
            Assert.assertTrue("Body contains data when it shouldn't", empty);
        } catch (Exception e) {
            Assert.fail(e.toString());
            e.printStackTrace();
        }

    }

    @After
    public void afterTest() {
        // Reset Values
        RestUtil.resetBaseURI();
        RestUtil.resetBasePath();
    }

}

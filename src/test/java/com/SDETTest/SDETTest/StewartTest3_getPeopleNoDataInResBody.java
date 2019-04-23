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
public class StewartTest3_getPeopleNoDataInResBody {
   

    
    private Response response = null; // Response object

    @Before
    public void setup() throws Exception {
        RestUtil.setBaseURI("http://localhost:8080/"); // Setup Base URI
        RestUtil.setBasePath("getPeople?fromId=501&toId=600"); // Setup Base Path
        RestUtil.setContentType(ContentType.JSON); // Setup Content Type
        response = RestUtil.getResponse();
        RestUtil.getJsonPath(response);
    }

    @Test
    public void T01_StatusCodeTest() {
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

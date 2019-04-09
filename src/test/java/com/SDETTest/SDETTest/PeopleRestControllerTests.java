package com.SDETTest.SDETTest;

import com.github.tomakehurst.wiremock.WireMockServer;
import io.restassured.RestAssured;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.configureFor;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
public class PeopleRestControllerTests {
    private static final int PORT = 8083;
    private static WireMockServer wireMockServer = new WireMockServer(PORT);



    @BeforeClass
    public static void before() throws Exception {
        System.out.println("Setting up!");
       
           
    }


    @Test
    public void firstTest() {
        wireMockServer.start();
        RestAssured.port = PORT;
        configureFor("localhost", PORT);
        stubFor(get(urlEqualTo("/getPeople?fromId=0&toId=10")).willReturn(
          aResponse().withStatus(200)));

    }

}

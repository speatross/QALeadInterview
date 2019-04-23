package com.SDETTest.SDETTest;

import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import org.junit.Assert;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class HelperMethods {
    /*
    Verify the http response status returned. Check Status Code is 200?
    We can use Rest Assured library's response's getStatusCode method
    */
    public static void checkStatusIs200(Response res) {
        assertEquals("Status Check Failed!", 200, res.getStatusCode());
    }

    /*Acceptes an expected status code and returns true or false if the response code matches or does not match.
     */
    public static boolean checkExpectedStatus(Response res, int expectedSatusCode) {
        if (res != null) {
            int actualCode = HelperMethods.getResponseStatusCode(res);
            if (actualCode == 500) {
                Assert.fail("Test failed, the server returned a 500."); //Just put this in for fun in case a 500 is returned.
                return false;
            } else if (actualCode != expectedSatusCode){
                return false;
            }
        }
        return true;
    }

    public static int getResponseStatusCode(Response res) {
        int code = res.getStatusCode();
        return code;
    }

    public static String stripBodyBrackets(String body) {
        String stripped = body.replace("[]", "");
        return stripped;
    }
}
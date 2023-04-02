package org.example;

import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.regex.Matcher;

public class Demo2 {

    static String userId = "";

    static RequestSpecification requestSpecification;
    static Response response;

    @Before
    public static void setUp(){
        final String BASE_URL = "https://amanzadr.talentlms.com/"; //"https://gorest.co.in/public/v2/";
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri(BASE_URL);
        requestSpecification.auth().basic("apikey","ifCuTZiG2uwWee5bY28ax71ptCBinb");
      //  requestSpecification.header("Authorization","Bearer d94eeef4d5635c3f1b28d29289abda90265b56a07abe9e2c91c93ef3fcc595ea");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.accept(ContentType.JSON);
    }



    @Test
    public void createNewUser(){
        String payload = "{\n" +
                "        \"name\": \"Bohn Boneko\",\n" +
                "        \"email\": \"DDAlsuk@doe.com\",\n" +
                "        \"gender\": \"male\",\n" +
                "        \"status\": \"active\"\n" +
                "    }";


        requestSpecification.body(payload);
        response = requestSpecification
                .request(Method.POST,"groups");

        JsonPath jsonPath = response.jsonPath();
        userId = jsonPath.getString("id");

        response.prettyPrint();
        Assert.assertEquals(201,response.getStatusCode());
        System.out.println(userId);

    }

    @Test
    public void updateNewUserName(){
        String payload = "{\n" +
                "        \"name\": \" Muskat\",\n" +
                "        \"email\": \"mohan12345@doe.com\",\n" +
                "        \"gender\": \"male\",\n" +
                "        \"status\": \"active\"\n" +
                "    }";
        requestSpecification.body(payload);
        response = requestSpecification
                .request(Method.PATCH,"users/"+userId);
        response.prettyPrint();
        Assert.assertEquals(200,response.getStatusCode());

       // response.then().body("id", Matchers.is(userId)); mojem konkretno sravnit s dannimy
    }

}


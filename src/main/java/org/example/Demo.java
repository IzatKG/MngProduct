package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.util.Asserts;
import org.junit.Assert;

public class
Demo {
    public static void main(String[] args) {
        //d94eeef4d5635c3f1b28d29289abda90265b56a07abe9e2c91c93ef3fcc595ea

        final String Base_URL ="https://gorest.co.in/public/v2/";
        RequestSpecification requestSpecification = RestAssured.given();//interface(headers)(dlya sozdanya peremennih)
        requestSpecification.baseUri(Base_URL);
        requestSpecification.header("Authorization","Beareer d94eeef4d5635c3f1b28d29289abda90265b56a07abe9e2c91c93ef3fcc595ea");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.accept(ContentType.JSON);

        Response response = requestSpecification   //poluchit dostup k otvetam
                .request(Method.GET,"users");

        System.out.println(response.prettyPrint());
        //proveryam response code
        Assert.assertEquals(200,response.getStatusCode());
        System.out.println("_________________________________________");
    }
}

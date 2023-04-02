package org.example;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.example.pojo.User;
import org.junit.Test;

public class GsonDataConverter {
    static RequestSpecification requestSpecification;
    static Response response;
    Gson gson =new Gson();
    @Test
    public void  testGsonSerialization(){
        String payload = "{\n" +
                "        \"name\": \"Bohn Boneko\",\n" +
                "        \"email\": \"DDAlsuk@doe.com\",\n" +
                "        \"gender\": \"male\",\n" +
                "        \"status\": \"active\"\n" +
                "    }";

        User user =gson.fromJson(payload, User.class);
        System.out.println(user.getId());
        System.out.println(user.getEmail());
        System.out.println(user.getGender());
        System.out.println(user.getName());
     //deserialization

    }
    @Test
    public void testGsonDeserialization(){
        User user =new User();
        user.setName("Ilon Mask");
        user.setEmail("Masko@gmail.com");
        user.setGender("male");
        user.setStatus("active");

        String payload =gson.toJson(user);
        //System.out.println(payload);

        final String BASE_URL = "https://gorest.co.in/public/v2/";
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri(BASE_URL);
        requestSpecification.header("Authorization","Bearer d94eeef4d5635c3f1b28d29289abda90265b56a07abe9e2c91c93ef3fcc595ea");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.accept(ContentType.JSON);

        response=requestSpecification
                .body(payload)
                .request(Method.POST,"users");
        response.prettyPrint();
    }

    @Test
    public void testGsonSerializationToXML(){

        User user =new User();
        user.setName("Ilon Mask");
        user.setEmail("Masko@gmail.com");
        user.setGender("male");
        user.setStatus("active");

        String payload =gson.toJson(user);
        //System.out.println(payload);

        final String BASE_URL = "https://gorest.co.in/public/v2/";
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri(BASE_URL);
        requestSpecification.header("Authorization","Bearer d94eeef4d5635c3f1b28d29289abda90265b56a07abe9e2c91c93ef3fcc595ea");
        requestSpecification.contentType(ContentType.XML);
        requestSpecification.accept(ContentType.XML);

        response=requestSpecification
                .body(payload)
                .request(Method.POST,"users");
        response.prettyPrint();
    }
}

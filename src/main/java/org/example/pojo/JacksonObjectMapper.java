package org.example.pojo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JacksonObjectMapper {
    private static final ObjectMapper MAPPER = new ObjectMapper();
    @Test
    public void javaToJson() throws JsonProcessingException {
        User user =new User();
        user.setName("Ilon Mask");
        user.setEmail("asko@gmail.com");
        user.setGender("male");
        user.setStatus("active");
        user.setId(90477);
        String url ="https://gorest.co.in/public/v2/users";

        String json = MAPPER.writeValueAsString(user);
        Response response = RestAssured.given().contentType("application/json")
                .log().all(true).body(json).post(url).andReturn();
        assertEquals(201,response.getStatusCode());






    }
    @Test
    public void jsonToJava() throws JsonProcessingException {

        User user =new User();
        user.setName("Ilon Mask");
        user.setEmail("asko@gmail.com");
        user.setGender("male");
        user.setStatus("active");
        user.setId(90477);
        String url ="https://gorest.co.in/public/v2/users";

        String json = MAPPER.writeValueAsString(user);
        Response response = RestAssured.given().contentType("application/json")
                .log().all(true).body(json).post(url).andReturn();
        assertEquals(201,response.getStatusCode());






    }
}

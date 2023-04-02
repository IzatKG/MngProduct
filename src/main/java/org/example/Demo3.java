package org.example;

import io.restassured.RestAssured;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Demo3 {
    public static void main(String[] args) {
        RestAssured.baseURI="https://gorest.co.in/public/v2/users";
          given().header("Authorization","Beareer d94eeef4d5635c3f1b28d29289abda90265b56a07abe9e2c91c93ef3fcc595ea").

        body("")
                  .when().
                        get()
                  .then().
                    assertThat().statusCode(200);


    }

}

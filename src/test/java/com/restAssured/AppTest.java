package com.restAssured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.BeforeClass;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

public class AppTest {

    @BeforeClass
    public static void setup(){
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    public void testeListaDadosUsuarios() {
        when().
             get("https://reqres.in/api/users?page=2").
        then().
             statusCode(HttpStatus.SC_OK).
             body("page",is(2)).
             body("data",is(notNullValue()));
    }

    @Test
    public void testeCriarUsuarioComSucesso(){
        given().
              contentType(ContentType.JSON).
              body("{\"name\": \"ana\", \"job\": \"eng teste\"}").
        when().
              post("https://reqres.in/api/users").
        then().
              statusCode(HttpStatus.SC_CREATED).
              body("name", is("ana"));
    }
}

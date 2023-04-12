package com.restAssured.testes;

import com.restAssured.dominio.Usuario;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.is;
import org.apache.http.HttpStatus;
import org.junit.BeforeClass;
import org.junit.Test;

public class LoginTeste {
    @BeforeClass
    public static void setUp(){
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        baseURI = "https://reqres.in";
        basePath = "/api";
    }

    @Test
    public void testeFalhaLoginSemSenha(){
        Usuario usuario = new Usuario();
        usuario.setEmail("test@test");

        given().
                contentType(ContentType.JSON).
                body(usuario).
        when().
                post("/register").
        then().
                statusCode(HttpStatus.SC_BAD_REQUEST).
                body("error", is("Missing password"));

    }
}

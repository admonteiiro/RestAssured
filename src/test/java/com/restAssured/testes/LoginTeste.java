package com.restAssured.testes;

import com.restAssured.dominio.Usuario;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class LoginTeste extends BaseTeste {

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

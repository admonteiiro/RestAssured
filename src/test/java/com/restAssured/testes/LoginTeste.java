package com.restAssured.testes;

import com.restAssured.dominio.Usuario;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class LoginTeste extends BaseTeste {

    private static final String REGISTRA_LOGIN_ENDPOINT = "/register";

    @Test
    public void testeFalhaLoginSemSenha(){
        Usuario usuario = new Usuario();
        usuario.setEmail("test@test");

        given().
                body(usuario).
        when().
                post(REGISTRA_LOGIN_ENDPOINT).
        then().
                statusCode(HttpStatus.SC_BAD_REQUEST).
                body("error", is("Missing password"));

    }
}

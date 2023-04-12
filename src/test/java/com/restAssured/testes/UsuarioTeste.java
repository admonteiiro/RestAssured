package com.restAssured.testes;

import com.restAssured.dominio.Usuario;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

public class UsuarioTeste extends BaseTeste {

    private static final String LISTAR_USUARIOS_ENDPOINT = "/users";
    private static final String CRIAR_USUARIO_ENDPOINT = "/user";

    @Test
    public void testeListaDadosUsuarios() {
        given().
             params("page", "2").
        when().
             get(LISTAR_USUARIOS_ENDPOINT).
        then().
             statusCode(HttpStatus.SC_OK).
             body("page",is(2)).
             body("data",is(notNullValue()));
    }

    @Test
    public void testeCriarUsuarioComSucesso(){
        Usuario usuario = new Usuario("ana", "eng", "email@gmail.com");
        given().
              body(usuario).
        when().
              post(CRIAR_USUARIO_ENDPOINT).
        then().
              statusCode(HttpStatus.SC_CREATED).
              body("name", is("ana"));
    }
}

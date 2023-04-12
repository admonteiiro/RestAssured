package com.restAssured.testes;

import com.restAssured.dominio.Usuario;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

public class UsuarioTeste extends BaseTeste {

    @Test
    public void testeListaDadosUsuarios() {
        given().
             params("page", "2").
        when().
             get("/users").
        then().
             statusCode(HttpStatus.SC_OK).
             body("page",is(2)).
             body("data",is(notNullValue()));
    }

    @Test
    public void testeCriarUsuarioComSucesso(){
        Usuario usuario = new Usuario("ana", "eng", "email@gmail.com");
        given().
              contentType(ContentType.JSON).
              body(usuario).
        when().
              post("/users").
        then().
              statusCode(HttpStatus.SC_CREATED).
              body("name", is("ana"));
    }
}

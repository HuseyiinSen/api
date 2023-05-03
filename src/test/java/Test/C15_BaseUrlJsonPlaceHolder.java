package Test;

import baseURL.JsonPlaceHolderBaseURL;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;

public class C15_BaseUrlJsonPlaceHolder extends JsonPlaceHolderBaseURL {

    @Test
    public void get01(){
/*
        1-  https://jsonplaceholder.typicode.com/posts endpointine bir GET
          request gonderdigimizde donen response’un status code’unun 200 oldugunu
         ve Response’ta 100 kayit oldugunu test edin.
        */
        // 1 - Url hazirla ( Path parametreleri )
        speciJasonPage.pathParam("pp1","posts");
        //Response kaydet
        Response response=given()
                .spec(speciJasonPage)
                .when()
                .get("/{pp1}");
        //Assert et
        response
                .then()
                .assertThat()
                .statusCode(200)
                .body("title", hasSize(100));

    }
    @Test
    public void get02(){
        /*
        2- https://jsonplaceholder.typicode.com/posts/44 endpointine bir GET
            request gonderdigimizde donen response’un status code’unun 200 oldugunu
            ve “title” degerinin “optio dolor molestias sit” oldugunu test edin
         */
        // 1 - Url hazirla
        speciJasonPage.pathParams("pp1","posts","pp2",44);

        Response response=given()
                .spec(speciJasonPage)
                .when()
                .get("/{pp1}/{pp2}");

        response
                .then()
                .assertThat()
                .statusCode(200)
                .body("title",Matchers.equalTo("optio dolor molestias sit"));

    }
    @Test
    public void delete01(){
        /*
        3- https://jsonplaceholder.typicode.com/posts/50 endpointine bir DELETE
            request gonderdigimizde donen response’un status code’unun 200 oldugunu ve
            response body’sinin null oldugunu test edin
         */

        // 1 - Url hazirla
        speciJasonPage.pathParams("pp1","posts","pp2",50);

        Response response=given().spec(speciJasonPage).when().delete("/{pp1}/{pp2}");

        response
                .then()
                .assertThat()
                .statusCode(200)
                .body("id",Matchers.nullValue());

    }
}

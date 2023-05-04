package Test;

import TestData.TestDataJsonPlaceHolder;
import baseURL.JsonPlaceHolderBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.regex.Matcher;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C22_Put_DeSerialization extends JsonPlaceHolderBaseURL {
     /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki
    body’e sahip bir PUT request yolladigimizda donen response’in
    response body’sinin asagida verilen ile ayni oldugunu test ediniz

    Request Body

        {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }

    Expected Data :

        {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }
     */
    @Test
    public void put01(){
        speciJasonPage.pathParams("pp1","posts","pp2",70);
        TestDataJsonPlaceHolder testDataJsonPlaceHolder=new TestDataJsonPlaceHolder();
        HashMap<String,Object> reqBadyMaps=testDataJsonPlaceHolder.reqBodyOlusturMap();
        HashMap<String,Object> expbodyMaps=testDataJsonPlaceHolder.reqBodyOlusturMap();
        Response response=given()
                .spec(speciJasonPage)
                .contentType(ContentType.JSON)
                .when()
                .body(reqBadyMaps).put("/{pp1}/{pp2}");
        response.prettyPrint();
        HashMap<String,Object> reqMaps=response.as(HashMap.class);

        assertEquals(testDataJsonPlaceHolder.basariliStatusCode,response.getStatusCode());
        assertEquals(expbodyMaps.get("id"), reqMaps.get("id"));
        assertEquals(expbodyMaps.get("userId"), reqMaps.get("userId"));
        assertEquals(expbodyMaps.get("body"), reqMaps.get("body"));
        assertEquals(expbodyMaps.get("title"), reqMaps.get("title"));


    }
}

package Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C11_Get_ExpectedDataOlusturma {
     /*
    https://jsonplaceholder.typicode.com/posts/22 url'ine
    bir GET request yolladigimizda donen response body’sinin
    asagida verilen ile ayni oldugunu test ediniz
   Response body :
    {
    "userId":3,
    "id":22,
    "title":"dolor sint quo a velit explicabo quia nam",
    "body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita
    earum mollitia molestiae aut atque rem suscipit\nnam impedit esse"
    }
     */
    @Test
    public void get01(){

        String url="https://jsonplaceholder.typicode.com/posts/22";
        JSONObject expJSON=new JSONObject();
        expJSON.put("userId",3)
                .put("id",22)
                .put("title","dolor sint quo a velit explicabo quia nam")
                .put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

        Response response=given().when().get(url);
        JsonPath resJSP=response.jsonPath();
        Assert.assertEquals(expJSON.get("userId"),resJSP.get("userId"));
        Assert.assertEquals(expJSON.get("id"),resJSP.get("id"));
        Assert.assertEquals(expJSON.get("title"),resJSP.get("title"));
        Assert.assertEquals(expJSON.get("body"),resJSP.get("body"));


    }
}

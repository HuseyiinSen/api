package Test;

import TestData.TestDataJsonPlaceHolder;
import baseURL.JsonPlaceHolderBaseURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.protocol.ResponseServer;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Matcher;

import static io.restassured.RestAssured.given;

public class C18_Get_TestDataClassKullanimi extends JsonPlaceHolderBaseURL {

    /*

  https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET
  request yolladigimizda donen response’in status kodunun 200 ve
  response body’sinin asagida verilen ile ayni oldugunu test ediniz

   Response body = Expected Body
    {
    "userId":3,
    "id":22,
    "title":"dolor sint quo a velit explicabo quia nam",
    "body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
    um mollitia molestiae aut atque rem suscipit\nnam impedit esse"
    }
     */
    @Test
    public  void get01(){
        speciJasonPage.pathParams("pp1","posts","pp2",22);
        TestDataJsonPlaceHolder testDataJsonPlaceHolder=new TestDataJsonPlaceHolder();
       JSONObject expectedData= testDataJsonPlaceHolder.expectedBodyOlusturJson();
        Response response=given().spec(speciJasonPage).when().get("/{pp1}/{pp2}");
        JsonPath reponseJpath=response.jsonPath();

        Assert.assertEquals(testDataJsonPlaceHolder.basariliStatusCode,response.getStatusCode());
        Assert.assertEquals(expectedData.get("userId"),reponseJpath.get("userId"));
        Assert.assertEquals(expectedData.get("id"),reponseJpath.get("id"));
        Assert.assertEquals(expectedData.get("title"),reponseJpath.get("title"));
        Assert.assertEquals(expectedData.get("body"),reponseJpath.get("body"));





    }
}

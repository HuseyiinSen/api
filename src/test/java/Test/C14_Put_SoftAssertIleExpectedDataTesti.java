package Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.put;

public class C14_Put_SoftAssertIleExpectedDataTesti { /*
    https://dummy.restapiexample.com/api/v1/update/21 url’ine asagidaki
    body’ye sahip bir PUT request gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.

            Request Body
            {
                "status":"success",
                "data":{
                        "name":“Ahmet",
                        "salary":"1230",
                        "age":"44",
                        "id":40
                        }
            }

            Response Body

            {
            "status":"success",
            "data":{
                "status":"success",
                "data":{
                        "name":“Ahmet",
                        "salary":"1230",
                        "age":"44",
                        "id":40
                        }
                   },
            "message":"Successfully! Record has been updated."
            }
                 */
    @Test
    public void put01(){
        String url="https://dummy.restapiexample.com/api/v1/update/21";

        JSONObject data=new JSONObject();
        data.put("status","success");
        data.put("salary","1230");
        data.put("name","Ahmet");
        data.put("age","44");
        data.put("id",40);

        JSONObject requestBody=new JSONObject();
        requestBody.put("status","success");
        requestBody.put("data",data);


        Response response=given().
                contentType(ContentType.JSON).
                when().
                body(requestBody.toString()).
                put(url);

        response.prettyPrint();

        JSONObject expectedData=new JSONObject();
        expectedData.put("status","success");
        expectedData.put("data",requestBody);
        //expectedData.put("data",data);
        expectedData.put("message","Successfully! Record has been updated.");

        JsonPath rspJp=response.jsonPath();

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(rspJp.get("status"),expectedData.get("status"));
        softAssert.assertEquals(rspJp.get("data.status"),expectedData.getJSONObject("data").get("status"));
        softAssert.assertEquals(rspJp.get("data.data.name"),expectedData.getJSONObject("data").getJSONObject("data").get("name"));

        softAssert.assertAll();


    }
}

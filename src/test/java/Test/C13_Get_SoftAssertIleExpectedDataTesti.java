package Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C13_Get_SoftAssertIleExpectedDataTesti {
    /*
    http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
    gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.

        Response Body
        {
        "status":"success",
        "data":{
                "id":3,
                "employee_name":"Ashton Cox",
                "employee_salary":86000,
                "employee_age":66,
                "profile_image":""
                },
        "message":"Successfully! Record has been fetched."
        }
     */

    @Test
    public void get01(){
        String url="http://dummy.restapiexample.com/api/v1/employee/3";

        JSONObject data=new JSONObject();
        data.put("id",3);
        data.put("employee_name","Ashton Cox");
        data.put("employee_salary",86000);
        data.put("employee_age",66);
        data.put("profile_image","");

        JSONObject expdata=new JSONObject();
        expdata.put( "data",data);
        expdata.put( "status","success");
        expdata.put( "message","Successfully! Record has been fetched.");

        Response response= given().when().get(url);

        response.prettyPrint();

        JsonPath respJp=response.jsonPath();

        SoftAssert softAssert=new SoftAssert();

        softAssert.assertEquals(respJp.get("status"),expdata.get("status"));
        softAssert.assertEquals(respJp.get("message"),expdata.get("message"));
        softAssert.assertEquals(respJp.get("data.id"),expdata.getJSONObject("data").get("id"));
        softAssert.assertEquals(respJp.get("data.employee_name"),expdata.getJSONObject("data").get("employee_name"));
        softAssert.assertEquals(respJp.get("data.employee_salary"),expdata.getJSONObject("data").get("employee_salary"));
        softAssert.assertEquals(respJp.get("data.employee_age"),expdata.getJSONObject("data").get("employee_age"));
        softAssert.assertEquals(respJp.get("data.profile_image"),expdata.getJSONObject("data").get("profile_image"));


        softAssert.assertAll();



    }
}

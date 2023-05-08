package Test;

import TestData.TestDataHerokuApp;
import baseURL.HerokuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class C24_Post_Deserialization extends HerokuAppBaseUrl {
        /*
      https://restful-booker.herokuapp.com/booking url'ine asagidaki
      body'ye sahip bir POST request gonderdigimizde donen response'un
      id haric asagidaki gibi oldugunu test edin.

        Request body
   {
        "firstname" : "Ali",
        "lastname" : "Bak",
        "totalprice" : 500,
        "depositpaid" : false,
        "bookingdates" : {
                 "checkin" : "2021-06-01",
                 "checkout" : "2021-06-10"
                          },
        "additionalneeds" : "wi-fi"
    }

       Response Body
       {
       "bookingid":24,
       "booking":{
           "firstname":"Ali",
           "lastname":"Bak",
           "totalprice":500,
           "depositpaid":false,
           "bookingdates":{
               "checkin":"2021-06-01",
               "checkout":"2021-06-10"
           },
           "additionalneeds":"wi-fi"
           }
       }
   */
  @Test
    public void post(){

      specHerokuApp.pathParam("pp1","booking");
      TestDataHerokuApp testDataHerokuApp=new TestDataHerokuApp();
      HashMap<String,Object> reqBody= testDataHerokuApp.reqBodyMap();
      HashMap<String,Object> respBody=testDataHerokuApp.resBodyMap();
    Response response=given()
            .spec(specHerokuApp)
            .contentType(ContentType.JSON)
            .when()
            .body(reqBody)
            .post("/{pp1}");
    response.prettyPrint();



  }

}

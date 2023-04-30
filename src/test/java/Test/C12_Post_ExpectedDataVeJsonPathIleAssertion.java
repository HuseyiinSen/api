package Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C12_Post_ExpectedDataVeJsonPathIleAssertion {
/*
    https://restful-booker.herokuapp.com/booking url’ine
    asagidaki body'ye sahip bir POST request gonderdigimizde
    donen response’un id disinda asagidaki gibi oldugunu test edin.
    	                Request body
    	           {
    	                "firstname" : "Ahmet",
    	                "lastname" : “Bulut",
    	                "totalprice" : 500,
    	                "depositpaid" : false,
    	                "bookingdates" : {
    	                         "checkin" : "2021-06-01",
    	                         "checkout" : "2021-06-10"
    	                                  },
    	                "additionalneeds" : "wi-fi"
    	            }


    	            	Response Body - Expected Body
    	           {
                    "bookingid":24,
                    "booking":{
                        "firstname":"Ahmet",
                        "lastname":"Bulut",
                        "totalprice":500,
                        "depositpaid":false,
                        "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-10"
                                        }
                        ,
                        "additionalneeds":"wi-fi"
                             }
                    }
*/

    @Test
    public void post01() {
        String url="https://restful-booker.herokuapp.com/booking";

        JSONObject bookingdates=new JSONObject();
        bookingdates.put( "checkin" ,"2021-06-01")
                     .put("checkout","2021-06-10");

        JSONObject reqbody=new JSONObject();
            reqbody.put("firstname" , "Ahmet")
                .put("lastname" , "Bulut")
                .put("totalprice" , 500)
                .put("depositpaid",false)
                .put("bookingdates",bookingdates)
                .put("additionalneeds" , "wi-fi");
        System.out.println(reqbody);

        ////////////////////************************************////////////////////////

        JSONObject expbody =new JSONObject();
        expbody.put("bookingid",24)
                .put("booking",reqbody);

        Response response=given().
                contentType(ContentType.JSON).
                when().
                body(reqbody.toString()).
                post(url);

////////////////////////************************************************////////////////////////////
        JsonPath respJpath=response.jsonPath();

          assertEquals(expbody.getJSONObject("booking").get("firstname"),respJpath.get("booking.firstname"));
          assertEquals(expbody.getJSONObject("booking").get("lastname"),respJpath.get("booking.lastname"));
          assertEquals(expbody.getJSONObject("booking").get("totalprice"),respJpath.get("booking.totalprice"));
          assertEquals(expbody.getJSONObject("booking").get("depositpaid"),respJpath.get("booking.depositpaid"));
          assertEquals(expbody.getJSONObject("booking").get("additionalneeds"),respJpath.get("booking.additionalneeds"));

          assertEquals(expbody.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),
                  respJpath.get("booking.bookingdates.checkin"));
          assertEquals(expbody.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),
                  respJpath.get("booking.bookingdates.checkout"));


    }
}

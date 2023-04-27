package Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C09_Post_JsonPathIleBodyTesti {
    @Test
    public void post01(){
        /*
            https://restful-booker.herokuapp.com/booking
            url’ine asagidaki body'ye sahip
            bir POST request gonderdigimizde
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
                        */
        String url="https://restful-booker.herokuapp.com/booking";
        JSONObject bookingDates=new JSONObject();
        bookingDates.put("checkin" , "2021-06-01");
        bookingDates.put("checkout" , "2021-06-10");

        JSONObject booking=new JSONObject();
        booking.put("firstname" ,"Ali")
               .put("lastname" , "Bak")
               .put("totalprice" , 500)
               .put("depositpaid", false)
               .put("bookingdates" ,bookingDates)
               .put("additionalneeds" , "wi-fi");

        Response response=given()
                            .contentType(ContentType.JSON)
                            .when()
                            .body(booking.toString())
                            .post(url);

        System.out.println(booking);

        /*
            donen Response’un,
            status code’unun 200,
            ve content type’inin application/json; charset=utf-8,
            ve response body’sindeki
                "firstname“in,"Ali",
                ve "lastname“in, "Bak",
                ve "totalprice“in,500,
                ve "depositpaid“in,false,
                ve "checkin" tarihinin 2021-06-01
                ve "checkout" tarihinin 2021-06-10
                ve "additionalneeds“in,"wi-fi"
            oldugunu test edin
     */
           response
                   .then()
                   .assertThat()
             .statusCode(200)
                   .contentType("application/json; charset=utf-8")
                   .body("booking.firstname", Matchers.equalTo("Ali")
                           ,"booking.lastname",Matchers.equalTo("Bak")
                           ,"booking.totalprice",Matchers.equalTo(500)
                           ,"booking.depositpaid",Matchers.equalTo(false)
                           ,"booking.additionalneeds",Matchers.equalTo("wi-fi")
                           ,"booking.bookingDates.checkin",Matchers.equalTo("2021-06-01")
                           ,"booking.bookingDates.checkout",Matchers.equalTo("2021-06-10"));

    }
}

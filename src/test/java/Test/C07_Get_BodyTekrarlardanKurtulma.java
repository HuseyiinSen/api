package Test;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class C07_Get_BodyTekrarlardanKurtulma {
    /*
       https://restful-booker.herokuapp.com/booking/10 url’ine
       bir GET request gonderdigimizde donen Response’un,

       status code’unun 200,
       ve content type’inin application/json; charset=utf-8,
       ve response body’sindeki
           "firstname“in,"Jim",
           ve "lastname“in, "Wilson",
           ve "totalprice“in, 609,
           ve "depositpaid“in,false,
           ve "additionalneeds“in,"Breakfast"
       oldugunu test edin


*/
    @Test
    public void get02(){
        String url="https://restful-booker.herokuapp.com/booking/10";

        Response response=given().when().get(url);

        response.then().assertThat()
                .statusCode(200).body("firstname",equalTo("Jim"),
                            "lastname",equalTo("Wilson"),
                            "totalprice",equalTo(609),
                            "depositpaid",equalTo(false),
                            "additionalneeds",equalTo("Breakfast"));

    }
}

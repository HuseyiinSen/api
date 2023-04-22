package Test;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C02_GetResponseBilgileriAssert {
    @Test
    public void get02(){
        /*
        https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request
        gonderdigimizde donen Response’un,
        status code’unun 200,
        ve content type’inin application/json; charset=utf-8,
        ve Server isimli Header’in degerinin Cowboy,
        ve status Line’in HTTP/1.1 200 OK
        oldugunu test edin.
     */
        String url="https://restful-booker.herokuapp.com/booking/10";
        Response response=given().when().get(url);
        // status code’unun 200
        response.then().assertThat().statusCode(200);
        response.then().assertThat().contentType("application/json; charset=utf-8");
        //ve Server isimli Header’in degerinin Cowboy,
        response.then().assertThat().header("Server","Cowboy");
        //ve status Line’in HTTP/1.1 200 OK
        response.then().assertThat().statusLine("HTTP/1.1 200 OK");




    }
}

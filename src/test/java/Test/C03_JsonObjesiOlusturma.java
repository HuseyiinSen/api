package Test;

import com.google.gson.JsonObject;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class C03_JsonObjesiOlusturma {
    /*
    Asagidaki JSON Objesini olusturup konsolda yazdirin.

    {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":1
    }
    */
    @Test
            public void JasonObje()
    {

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("title","Ahmet");
        jsonObject.put("body","Merhaba");
        jsonObject.put("userId",1);
        System.out.println(jsonObject);

    }
    @org.junit.Test
    public void jsonObje02(){

        /*
                {
                 "firstname":"Jim",
                 "additionalneeds":"Breakfast",
                 "bookingdates":{
                         "checkin":"2018-01-01",
                         "checkout":"2019-01-01"
                    },
                  "totalprice":111,
                  "depositpaid":true,
                  "lastname":"Brown"
                  }
         */
            JSONObject booking=new JSONObject();
             booking.put("checkin","2018-01-01");
             booking.put("checkout","2019-01-01");

             JSONObject ikinciObje=new JSONObject();
             ikinciObje.put("firstname","Jim");
             ikinciObje.put("additionalneeds","Breakfast");
             ikinciObje.put("bookingdates",booking);
             ikinciObje.put("totalprice",111);
             ikinciObje.put("depositpaid",true);
             ikinciObje.put( "lastname","Brown");
        System.out.println(ikinciObje);


    }
}

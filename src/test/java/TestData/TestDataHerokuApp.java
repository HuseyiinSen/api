package TestData;

import org.json.JSONObject;

public class TestDataHerokuApp {

    public int basariliStatusCode=200;
    /*
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
    public JSONObject bookingDatesJson(){
       JSONObject bookingdates=new JSONObject();
       bookingdates.put("checkin","2021-06-01");
        bookingdates.put("checkout" ,"2021-06-10");
        return bookingdates;
    }

    public JSONObject reqBodyJson(){
        JSONObject reqBodyJson=new JSONObject();
        reqBodyJson.put("firstname" , "Ali");
        reqBodyJson.put("lastname" , "Bak");
        reqBodyJson.put("totalprice" , 500);
        reqBodyJson.put("depositpaid" , false);
        reqBodyJson.put("bookingdates",bookingDatesJson());
        reqBodyJson.put("additionalneeds" , "wi-fi");
        return reqBodyJson;
    }
    /*
    Expected Body
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
    public JSONObject expBodyJson(){
        JSONObject expBody=new JSONObject();
        expBody.put("bookingid",24);
        expBody.put("booking",reqBodyJson());

        return expBody;
    }





}

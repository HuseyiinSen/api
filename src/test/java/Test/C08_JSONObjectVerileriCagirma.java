package Test;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class C08_JSONObjectVerileriCagirma {


    @Test
    public void jsonPath01(){

        JSONObject iphone=new JSONObject();
        JSONObject home=new JSONObject();
        JSONArray phoneNumbers= new JSONArray();
        JSONObject adres=new JSONObject();
        JSONObject kisiBilgileri=new JSONObject();


        /*
    {
    "firstName": "John",
    "lastName": "doe",
    "age": 26,
    "address": {
        "streetAddress": "naist street",
        "city": "Nara",
        "postalCode": "630-0192"
                },
    "phoneNumbers": [
                    {
                        "type": "iPhone",
                        "number": "0123-4567-8888"
                    },
                    {
                        "type": "home",
                        "number": "0123-4567-8910"
                    }
                    ]
    }
     */
        iphone.put("type","iPhone")
                .put("number", "0123-4567-8888");
        home.put("type","home")
                .put("number","0123-4567-8910");
        phoneNumbers.put(0,"iphone")
                    .put(1,"home");
        adres.put("streetAddress","naist street")
                .put("city","Nara")
                .put("postalCode", "630-0192");
        kisiBilgileri.put("firstName","John").
                    put("lastName", "doe").
                    put("address",adres).
                    put("phoneNumbers",phoneNumbers).
                    put("age",26);

        System.out.println(kisiBilgileri);


    }
}



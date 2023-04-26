package Test;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class C08_JSONObjectVerileriCagirma {


    @Test
    public void jsonPath01(){

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
        JSONObject iphone=new JSONObject();

        iphone.put("type","iPhone")
                .put("number", "0123-4567-8888");

        JSONObject home=new JSONObject();

        home.put("type","home")
                .put("number","0123-4567-8910");

        JSONArray phoneNumbers= new JSONArray();

        phoneNumbers.put(0,iphone)
                    .put(1,home);

        JSONObject adres=new JSONObject();

        adres.put("streetAddress","naist street")
                .put("city","Nara")
                .put("postalCode", "630-0192");

        JSONObject kisiBilgileri=new JSONObject();
        kisiBilgileri.put("firstName","John").
                    put("lastName", "doe").
                    put("address",adres).
                    put("phoneNumbers",phoneNumbers).
                    put("age",26);

        System.out.println(kisiBilgileri);

        //******KİSİ BİLGİLERİ GETİRME*********
        /*
   { "firstName": "John",
    "lastName": "doe",
    "age": 26,
    "address": {
        "streetAddress": "naist street",
        "city": "Nara",
        "postalCode": "630-0192"},
                   "phoneNumbers":  { [
                        "type": "iPhone",
                        "number": "0123-4567-8888"},
                      { "type": "home",
                        "number": "0123-4567-8910"}]  }
     */
        System.out.println("isim===> " + kisiBilgileri
                .get("firstName"));
        System.out.println("soyisim ===>" + kisiBilgileri
                .get("lastName"));
        System.out.println("sehir Adi ===>"+kisiBilgileri
                .getJSONObject("address")
                .get("city"));
        System.out.println("Cep Tel No : " + kisiBilgileri
                        .getJSONArray("phoneNumbers")
                        .getJSONObject(0)
                        .get("number"));
        System.out.println("Telefon Tipi: ===>" + kisiBilgileri
                .getJSONArray("phoneNumbers")
                .getJSONObject(0)
                .get("type"));


    }
}



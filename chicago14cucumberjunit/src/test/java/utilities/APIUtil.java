package utilities;

import apiModels.RequestBody;
import apiModels.ResponseBody;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;


public class APIUtil {

//      1. Have a generalized get() methods. It should handle any method
//      - There are 9 get methods in API documentation of api.cybertektraining.com
//      - CRUD operation
//      - We always work with STATIC methods in Utils

        private static ResponseBody responseBody;
            // but, this is still private. So, create a public method:
//    We will need later an array of ResponseBody when we will get a list, not object,
//    of ResponseBody in the delete API.
        public static ResponseBody [] responseBodies;

        public static void hitGET(String resource) {

            String uri = Config.getProperty("baseURL") + resource;
            Response response = RestAssured.get(uri); // headers could be added here

            System.out.println(response.asString());

//            Assert.assertEquals("GET API failed", 200, response.statusCode());

            ObjectMapper objectMapper = new ObjectMapper();

            try {

                responseBody = objectMapper.readValue(response.asString(), ResponseBody.class);
//                by handling here, we don't need to handle it anywhere when we call it
//                declare ResponseBody at Class level so that it can be accessed by a public method
            }
            catch (Exception j) {
//                j.printStackTrace();
                System.out.println(resource + " Not found");
            }
        }

        public static ResponseBody getResponseBody() {

            return responseBody;
        }

        public static void hitPost(String resource, RequestBody body) {

            String uri = Config.getProperty("baseURL") + resource;

            ObjectMapper objectMapper = new ObjectMapper();

            String bodyJSON = "";

            try {
                bodyJSON = objectMapper.writeValueAsString(body);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

            Response response = RestAssured.given().contentType(ContentType.JSON).body(bodyJSON).when().post(uri);

            System.out.println(response.asString());
            Assert.assertEquals("GET API failed", 200, response.statusCode());

            try {
                responseBody = objectMapper.readValue(response.asString(), ResponseBody.class);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }

        public static void hitDelete(String resource) {

            String uri = Config.getProperty("baseURL") + resource;
            Response response = RestAssured.delete(uri);

            System.out.println(response.asString());
            System.out.println("Status Code: " + response.statusCode());

            ObjectMapper objectMapper = new ObjectMapper();

            try {
                responseBody = objectMapper.readValue(response.asString(), ResponseBody.class);
//                responseBodies = objectMapper.readValue(response.asString(), ResponseBody [].class);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
//
//                  System.out.println("Response couldn't map properly with Jackson Library");
//                  IN case you get the teacher ID from scenario outline:
//              System.out.println(resource + " successfully deleted");
            }

        }


    public static void hitPUT(String resource, RequestBody body) {

        String uri = Config.getProperty("baseURL") + resource;

        ObjectMapper objectMapper = new ObjectMapper();

        String bodyJson = "";

        try {
            bodyJson = objectMapper.writeValueAsString(body);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        Response response = RestAssured.given().contentType(ContentType.JSON).body(bodyJson).when().put(uri);

        System.out.println(response.asString());
        System.out.println("Status Code: " + response.statusCode());

        try {
            responseBody = objectMapper.readValue(response.asString(), ResponseBody.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}

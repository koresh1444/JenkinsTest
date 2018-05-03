package org.jbehave.core.rest.RequestShema;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.ValidatableResponse;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.equalTo;

public class RestRequest extends RestAssured {

    private String api = "https://openweathermap.org";
    private String weatherApi = "http://api.openweathermap.org/data/2.5";
    private long millis = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
    private String appid = "69f35d79e989566d943aca0a5d2c2a0f";
    private String method = "weather";
    private String apiVersion = "2.5";
    private String city = "London,uk";
    private String pitsburghZip = "17266";
    private String lat = "42";
    private String lon = "-102";
    private String zip = "17266";


    public ValidatableResponse checkApiState(){
        return given().baseUri(weatherApi).
                params("q", city, "appid", appid).
                when().get("/weather").then().statusCode(200);
    }

    public ValidatableResponse getWeatherByCityInLondon() {
        return given().baseUri(weatherApi).
                params("q", city, "appid", appid).
                when().get("/weather").then().body("name",equalTo("London"));
    }

    public ValidatableResponse getWeatherByIDInHarrisburg() {
        return given().baseUri(weatherApi).
                params("zip", zip, "appid", appid).
                when().get("/weather").then().body("name",equalTo("Harrisburg"));
    }


    public ValidatableResponse getWeatherByCoordinatesInHyannis() {
        return given().baseUri(weatherApi).
                params("lat", lat, "lon", lon, "appid", appid).
                when().get("/weather").then().body("name",equalTo("Hyannis"));
    }

}
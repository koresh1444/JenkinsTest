package org.jbehave.core.rest.steps;

import com.jayway.restassured.response.ValidatableResponse;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.rest.RequestShema.RestRequest;

public class RESTSteps {

    @Given("Check the state of API")
    public void givenCheckApiState() {
        ValidatableResponse checkTheWeatherByCity = new RestRequest().checkApiState();
    }

    @Given("Check The Weather By City Name")
	public void givenCheckTheWeatherByCityName() {
        ValidatableResponse checkTheWeatherByCity = new RestRequest().getWeatherByCityInLondon();
	}

    @Given("Check The Weather By CityID")
    public void givenCheckTheWeatherByCityID() {
        ValidatableResponse checkTheWeatherByCityID = new RestRequest().getWeatherByIDInHarrisburg();
    }

    @Given("Check The Weather By City Coordinates")
    public void givenCheckTheWeatherByCityCoordinates() {
        ValidatableResponse checkTheWeatherByCityCoordinates = new RestRequest().getWeatherByCoordinatesInHyannis();
    }

}

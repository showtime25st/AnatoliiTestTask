package tests.regress;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import models.Planet;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PlannetListTests {

    Response resp;

    int statusValue;

    int countValue;

    String nextValue;

    int allPlanets;

    List<Object> planetsList;

    Planet firstPlanet;

    Planet lastPlanet;

    String responseAsString;

    HashMap<String, Integer> statusMap = new HashMap<String, Integer>();


    @Test
    public void testListOfPlanetsResponse() {

        resp = RestAssured.get("https://swapi.co/api/planets/");


        RestAssured.baseURI = "https://swapi.co/api/planets/";
        RequestSpecification request = RestAssured.given();

        Response response = request.get();
        System.out.println("Response Body -> " + response.body().asString());

        Planet[] planets = response.jsonPath().getObject("results",Planet[].class );


        statusValue = resp.getStatusCode();

        countValue = resp.jsonPath().get("count");

        nextValue = resp.jsonPath().get("next");

        allPlanets = planets.length;

        firstPlanet = planets[0];

        lastPlanet = planets[9];

        responseAsString = resp.asString().toLowerCase();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(statusValue == 200,
                "Response status incorrect " + statusValue);
        softAssert.assertTrue(countValue == 61,
                "Number of planets incorrect " + countValue);
        softAssert.assertTrue(nextValue.contains("https://swapi.co/api/planets/?page=2"),
                "Next page in response incorrect " + nextValue);
        softAssert.assertTrue(firstPlanet.getName().contains("Alderaan"),
                "FirstPlanet in the list incorrect " + firstPlanet);
        softAssert.assertTrue(allPlanets == 10,
                "Number of planets on the list incorrect " + allPlanets);
        softAssert.assertFalse(responseAsString.contains("error"),
                "In response there is error, response text: " + responseAsString);
        softAssert.assertTrue(lastPlanet.getGravity().contains("0.9 standard"),
                "Gravity of the last planet in the list incorrect " + lastPlanet);

        softAssert.assertAll();

    }

    @Test
    public void checkStatus() {

        statusMap.put("0", 404);
        statusMap.put("1", 200);
        statusMap.put("4", 200);
        statusMap.put("7", 200);
        statusMap.put("8", 404);
        statusMap.put("-1", 404);
        statusMap.put("1000", 404);

        for (Map.Entry<String, Integer> statusEntry : statusMap.entrySet()) {

            String currentKey = statusEntry.getKey();
            Integer currentValue = statusEntry.getValue();

            resp = RestAssured.get("https://swapi.co/api/planets/?page=" + currentKey);
            statusValue = resp.getStatusCode();

            Assert.assertTrue(statusValue == currentValue, "Status on page " + currentKey
                    + " incorrect, expected: " + currentValue + ", actual: " + statusValue);
        }
    }

}

package tests;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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

    String firstPlanet;

    String lastPlanet;

    String responseAsString;

    HashMap<String, Integer> statusMap = new HashMap<String, Integer>();


    @Test
    public void testListOfPlanetsResponse() {

        resp = RestAssured.get("https://swapi.co/api/planets/");

        statusValue = resp.getStatusCode();

        countValue = resp.jsonPath().get("count");

        nextValue = resp.jsonPath().get("next");

        allPlanets = resp.jsonPath().getList("results").size();

        planetsList = resp.jsonPath().getList("results");

        firstPlanet = planetsList.get(0).toString();

        lastPlanet = planetsList.get(9).toString();

        responseAsString = resp.asString().toLowerCase();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(statusValue == 200,
                "Response status incorrect " + statusValue);
        softAssert.assertTrue(countValue == 61,
                "Number of planets incorrect " + countValue);
        softAssert.assertTrue(nextValue.contains("https://swapi.co/api/planets/?page=2"),
                "Next page in response incorrect " + nextValue);
        softAssert.assertTrue(firstPlanet.contains("name=Alderaan"),
                "FirstPlanet in the list incorrect " + firstPlanet);
        softAssert.assertTrue(allPlanets == 10,
                "Number of planets on the list incorrect " + allPlanets);
        softAssert.assertFalse(responseAsString.contains("error"),
                "In response there is error, response text: " + responseAsString);
        softAssert.assertTrue(lastPlanet.contains("gravity=0.9 standard"),
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

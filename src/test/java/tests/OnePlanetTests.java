package tests;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Map;

public class OnePlanetTests {

    String name;
    int residents;
    Response resp;
    int statusValue;

    @Test
    public void checkFirstPlanetFields() {

        resp = RestAssured.get("https://swapi.co/api/planets/1/");
        statusValue = resp.getStatusCode();

        name = resp.jsonPath().get("name");
        residents = resp.jsonPath().getList("residents").size();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(name.equals("Tatooine"),
                "Planet name incorrect " + statusValue);
        softAssert.assertTrue(residents == 10,
                "Number of residents incorrect " + residents);

        softAssert.assertAll();

    }

}

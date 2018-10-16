package tests.smoke;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

import models.Planet;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import test_data.ChandrilaPlanet;
import test_data.PlanetTestData;
import test_data.TatooinePlanetTestData;


public class OnePlanetTests {

    String name;
    int residents;
    Response resp;
    int statusValue;

    @DataProvider(name = "test1")
    public static Object[][] primeNumbers() {
        return new Object[][] { { new TatooinePlanetTestData() },{new ChandrilaPlanet()} };
    }



    @Test(dataProvider = "test1")
    public void checkFirstPlanetFields(PlanetTestData planet) {

        resp = RestAssured.get(planet.getUrl());
        statusValue = resp.getStatusCode();

        Planet planetData = resp.as(Planet.class);

        name = planetData.getName();
        residents = planetData.getResidents().length;

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(name.equals(planet.getName()),
                "PlanetTestData name incorrect " + statusValue);
        softAssert.assertTrue(residents == planet.getResidents().size(),
                "Number of residents incorrect " + residents);

        softAssert.assertAll();

    }

}

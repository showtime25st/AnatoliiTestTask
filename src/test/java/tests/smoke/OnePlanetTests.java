package tests.smoke;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import test_objects.ChandrilaPlanet;
import test_objects.Planet;
import test_objects.TatooinePlanet;


public class OnePlanetTests {

    String name;
    int residents;
    Response resp;
    int statusValue;

    @DataProvider(name = "test1")
    public static Object[][] primeNumbers() {
        return new Object[][] { { new TatooinePlanet() },{new ChandrilaPlanet()} };
    }



    @Test(dataProvider = "test1")
    public void checkFirstPlanetFields(Planet planet) {

        resp = RestAssured.get(planet.getUrl());
        statusValue = resp.getStatusCode();

        name = resp.jsonPath().get("name");
        residents = resp.jsonPath().getList("residents").size();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(name.equals(planet.getName()),
                "Planet name incorrect " + statusValue);
        softAssert.assertTrue(residents == planet.getResidents().size(),
                "Number of residents incorrect " + residents);

        softAssert.assertAll();

    }

}

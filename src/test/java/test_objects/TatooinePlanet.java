package test_objects;

import java.util.ArrayList;
import java.util.List;

public class TatooinePlanet implements Planet {

    @Override
    public String getName() {
        return "Tatooine";
    }

    @Override
    public int getRotationPeriod() {
        return 23;
    }

    @Override
    public int getOrbitalPeriod() {
        return 304;
    }

    @Override
    public int getDiameter() {
        return 10465;
    }

    @Override
    public String getClimate() {
        return "arid";
    }

    @Override
    public String getGravity() {
        return "1 standard";
    }

    @Override
    public String getTerrain() {
        return "desert";
    }

    @Override
    public int getSurfaceWater() {
        return 1;
    }

    @Override
    public int getPopulation() {
        return 200000;
    }

    @Override
    public String getCreatedDate() {
        return "2014-12-09T13:50:49.641000Z";
    }

    @Override
    public String getEditedDate() {
        return "2014-12-21T20:48:04.175778Z";
    }

    @Override
    public String getUrl() {
        return "https://swapi.co/api/planets/1/";
    }

    @Override
    public List<String> getResidents() {
        List<String> list = new ArrayList<>();
        list.add("https://swapi.co/api/people/1/");
        list.add("https://swapi.co/api/people/2/");
        list.add("https://swapi.co/api/people/4/");
        list.add("https://swapi.co/api/people/6/");
        list.add("https://swapi.co/api/people/7/");
        list.add("https://swapi.co/api/people/8/");
        list.add("https://swapi.co/api/people/9/");
        list.add("https://swapi.co/api/people/11/");
        list.add("https://swapi.co/api/people/43/");
        list.add("https://swapi.co/api/people/62/");

        return  list;
    }

    @Override
    public List<String> getFilms() {
        List<String> list = new ArrayList<>();
        list.add("https://swapi.co/api/films/5/");
        list.add("https://swapi.co/api/films/4/");
        list.add("https://swapi.co/api/films/3/");
        list.add("https://swapi.co/api/films/2/");
        list.add("https://swapi.co/api/films/1/");

        return  list;
    }
}

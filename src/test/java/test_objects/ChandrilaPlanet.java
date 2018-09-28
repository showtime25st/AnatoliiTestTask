package test_objects;

import java.util.ArrayList;
import java.util.List;

public class ChandrilaPlanet implements Planet {

    @Override
    public String getName() {
        return "Chandrila";
    }

    @Override
    public int getRotationPeriod() {
        return 20;
    }

    @Override
    public int getOrbitalPeriod() {
        return 368;
    }

    @Override
    public int getDiameter() {
        return 13500;
    }

    @Override
    public String getClimate() {
        return "temperate";
    }

    @Override
    public String getGravity() {
        return "1";
    }

    @Override
    public String getTerrain() {
        return "plains, forests";
    }

    @Override
    public int getSurfaceWater() {
        return 40;
    }

    @Override
    public int getPopulation() {
        return 1200000000;
    }

    @Override
    public String getCreatedDate() {
        return "2014-12-18T11:11:51.872000Z";
    }

    @Override
    public String getEditedDate() {
        return "2014-12-20T20:58:18.472000Z";
    }

    @Override
    public String getUrl() {
        return "https://swapi.co/api/planets/32/";
    }

    @Override
    public List<String> getResidents() {
        List<String> list = new ArrayList<>();
        list.add("https://swapi.co/api/people/28/");

        return  list;
    }

    @Override
    public List<String> getFilms() {
        return null;
    }
}

package test_data;

import java.util.List;

public interface PlanetTestData {

    default String getName() {
        return "";
    }

    default int getRotationPeriod() {
        return 0;
    }

    default int getOrbitalPeriod() {
        return 0;
    }

    default int getDiameter() {
        return 0;
    }

    default String getClimate() {
        return "";
    }

    default String getGravity() {
        return "";
    }

    default String getTerrain() {
        return "";
    }

    default int getSurfaceWater() {
        return 0;
    }

    default int getPopulation() {
        return 0;
    }

    default String getCreatedDate() {
        return "";
    }

    default String getEditedDate() {
        return "";
    }

    default String getUrl() {
        return "";
    }

    default List<String> getResidents(){
        return null;
    }

    default List<String> getFilms(){
        return null;
    }

}

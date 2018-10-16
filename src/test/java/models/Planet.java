package models;

import java.util.Arrays;

public class Planet {

    private String name;
    private String rotation_period;
    private String orbital_period;
    private String diameter;
    private String climate;
    private String gravity;
    private String terrain;
    private String surface_water;
    private String population;
    private String[] residents;
    private String[] films;
    private String created;
    private String edited;
    private String url;


    public Planet(){

    }

    public Planet(String name, int rotation_period, int orbital_period, int diametr, String climate, String gravity, String terrain, int surface_water, int population, String[] residents, String[] films, String created, String edited, String url) {
        this.name = name;
        this.rotation_period = String.valueOf(rotation_period);
        this.orbital_period = String.valueOf(orbital_period);
        this.diameter = String.valueOf(diametr);
        this.climate = climate;
        this.gravity = gravity;
        this.terrain = terrain;
        this.surface_water = String.valueOf(surface_water);
        this.population = String.valueOf(population);
        this.residents = residents;
        this.films = films;
        this.created = created;
        this.edited = edited;
        this.url = url;
    }

    public Planet(String name, String rotation_period, String orbital_period, String diametr, String climate, String gravity, String terrain, String surface_water, String population, String[] residents, String[] films, String created, String edited, String url) {
        this.name = name;
        this.rotation_period = rotation_period;
        this.orbital_period = orbital_period;
        this.diameter = diametr;
        this.climate = climate;
        this.gravity = gravity;
        this.terrain = terrain;
        this.surface_water = surface_water;
        this.population = population;
        this.residents = residents;
        this.films = films;
        this.created = created;
        this.edited = edited;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getRotation_period() {
        return rotation_period;
    }

    public String getOrbital_period() {
        return orbital_period;
    }

    public String getDiameter() {
        return diameter;
    }

    public String getClimate() {
        return climate;
    }

    public String getGravity() {
        return gravity;
    }

    public String getTerrain() {
        return terrain;
    }

    public String getSurface_water() {
        return surface_water;
    }

    public String getPopulation() {
        return population;
    }

    public String[] getResidents() {
        return residents;
    }

    public String[] getFilms() {
        return films;
    }

    public String getCreated() {
        return created;
    }

    public String getEdited() {
        return edited;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "name='" + name + '\'' +
                ", rotation_period=" + rotation_period +
                ", orbital_period=" + orbital_period +
                ", diametr=" + diameter +
                ", climate='" + climate + '\'' +
                ", gravity=" + gravity +
                ", terrain='" + terrain + '\'' +
                ", surface_water=" + surface_water +
                ", population=" + population +
                ", residents=" + Arrays.toString(residents) +
                ", films=" + Arrays.toString(films) +
                ", created='" + created + '\'' +
                ", edited='" + edited + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}

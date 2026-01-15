package org.example.jdbcdatenvisualisierung;

public class city_class {

    private String cityName;
    private int population;
    private String country;
    Database db;

    public city_class(String cityName, int population, String country) {
        this.cityName = cityName;
        this.population = population;
        this.country = country;
    }

    public String getCityName() {
        return cityName;
    }

    public int getPopulation() {
        return population;
    }

    public String getCountry() {
        return country;
    }
}

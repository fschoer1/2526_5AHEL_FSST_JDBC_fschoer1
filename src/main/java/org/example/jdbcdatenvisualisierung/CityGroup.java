package org.example.jdbcdatenvisualisierung;

public class CityGroup {

    private String populationClass;
    private int cityCount;

    public CityGroup(String populationClass, int cityCount) {
        this.populationClass = populationClass;
        this.cityCount = cityCount;
    }

    public String getPopulationClass() {
        return populationClass;
    }

    public int getCityCount() {
        return cityCount;
    }
}

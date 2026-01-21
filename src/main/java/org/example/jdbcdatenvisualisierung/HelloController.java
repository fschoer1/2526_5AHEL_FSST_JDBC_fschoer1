package org.example.jdbcdatenvisualisierung;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.sql.*;
import java.util.List;


public class HelloController {
    @FXML
    private Label welcomeText;

    CityRepository cityRepository = new CityRepository();

    List<city_class> cities = cityRepository.getAllCities();

    public HelloController() throws Exception {
    }


    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText(cities.get(9).getCityName());
    }






}


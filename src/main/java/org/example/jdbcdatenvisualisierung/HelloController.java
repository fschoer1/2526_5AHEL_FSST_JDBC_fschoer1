package org.example.jdbcdatenvisualisierung;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.sql.*;
import java.util.List;


public class HelloController {
    @FXML
    private Label welcomeText;

    CityRepository cityRepository = new CityRepository();

    List<CityGroup> groups = cityRepository.getAllCities();

    public HelloController() throws Exception {
        welcomeText.setText(groups.get(0).getPopulationClass());
    }


    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText(groups.get(0).getPopulationClass());
    }






}


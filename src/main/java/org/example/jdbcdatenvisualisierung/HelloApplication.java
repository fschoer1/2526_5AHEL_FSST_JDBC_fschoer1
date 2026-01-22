package org.example.jdbcdatenvisualisierung;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.List;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        CityRepository cityRepository = new CityRepository();

        List<CityGroup> groups = cityRepository.getAllCities();



        PieChart pieChart = new PieChart();
        pieChart.setTitle("Städte nach Größe");

        pieChart.getData().add(new PieChart.Data("<100k", groups.get(1).getCityCount())); // letzter Parameter zu skalieren
        pieChart.getData().add(new PieChart.Data("100k–1M", groups.get(2).getCityCount()));
        pieChart.getData().add(new PieChart.Data(">1M", groups.get(0).getCityCount()));


        StackPane root = new StackPane(pieChart);
        Scene scene = new Scene(root, 600, 400);


        stage.setScene(scene);
        stage.setTitle("PieChart Demo");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

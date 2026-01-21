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

        List<city_class> cities = cityRepository.getAllCities();



        PieChart pieChart = new PieChart();
        pieChart.setTitle("Städte nach Größe");

        pieChart.getData().add(new PieChart.Data("<100k", 81.45)); // letzter Parameter zu skalieren
        pieChart.getData().add(new PieChart.Data("100k–1M", 12.72));
        pieChart.getData().add(new PieChart.Data(">1M", 5.83));

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

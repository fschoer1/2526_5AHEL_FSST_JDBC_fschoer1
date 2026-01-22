package org.example.jdbcdatenvisualisierung;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        CityRepository cityRepository = new CityRepository();
        List<CityGroup> groups = cityRepository.getAllCities();

        // --- PieChart ---
        PieChart pieChart = new PieChart();
        pieChart.setTitle("Städte nach Größe");

        PieChart.Data small = new PieChart.Data("<100k", groups.get(1).getCityCount());
        PieChart.Data medium = new PieChart.Data("100k–1M", groups.get(2).getCityCount());
        PieChart.Data large = new PieChart.Data(">1M", groups.get(0).getCityCount());

        pieChart.getData().addAll(small, medium, large);

        // --- CheckList ---

        CheckBox cbextraSmall = new CheckBox("<50k");
        cbextraSmall.setSelected(true);

        CheckBox cbSmall = new CheckBox("<100k");
        cbSmall.setSelected(true);

        CheckBox cbMedium = new CheckBox("100k–1M");
        cbMedium.setSelected(true);

        CheckBox cbLarge = new CheckBox(">1M");
        cbLarge.setSelected(true);

        // Verhalten: Checkbox steuert Sichtbarkeit im PieChart -> sollte aber noch verändert werden
        cbSmall.setOnAction(e -> small.getNode().setVisible(cbSmall.isSelected()));
        cbMedium.setOnAction(e -> medium.getNode().setVisible(cbMedium.isSelected()));
        cbLarge.setOnAction(e -> large.getNode().setVisible(cbLarge.isSelected()));

        VBox checkList = new VBox(10, cbextraSmall, cbSmall, cbMedium, cbLarge);

        // --- Layout: PieChart links, CheckList rechts ---
        HBox root = new HBox(20, pieChart, checkList);

        Scene scene = new Scene(root, 800, 400);

        stage.setScene(scene);
        stage.setTitle("PieChart mit CheckList");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

package com.example.screens;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.*;

public class NearbyMarketsScreen extends Application {

    private Map<String, List<String>> mockMarketData = new HashMap<>();

    @Override
    public void start(Stage primaryStage) {
        initializeMockMarkets();

        // Title
        Label titleLabel = new Label("Find Nearby Mandis");
        titleLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        // Location input
        TextField locationField = new TextField();
        locationField.setPromptText("Enter your village/city");

        // Search button
        Button searchBtn = new Button("Find Markets");

        // Results display
        ListView<String> resultList = new ListView<>();

        searchBtn.setOnAction(e -> {
            String location = locationField.getText().trim().toLowerCase();
            if (location.isEmpty()) {
                showAlert(Alert.AlertType.WARNING, "Missing Input", "Please enter your location.");
                return;
            }

            List<String> markets = mockMarketData.getOrDefault(location, new ArrayList<>());
            resultList.getItems().clear();

            if (markets.isEmpty()) {
                resultList.getItems().add("No markets found nearby.");
            } else {
                resultList.getItems().addAll(markets);
            }
        });

        // Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(titleLabel, locationField, searchBtn, resultList);
        layout.setStyle("-fx-alignment: center; -fx-background-color: #f9f9f9;");

        // Scene
        Scene scene = new Scene(layout, 400, 350);
        primaryStage.setTitle("Nearby Mandis");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initializeMockMarkets() {
        mockMarketData.put("nagpur", Arrays.asList("Nagpur Mandi", "Itwari Sabji Market", "Kalamna Market"));
        mockMarketData.put("amravati", Arrays.asList("Amravati Mandi", "Badnera Grain Market"));
        mockMarketData.put("pune", Arrays.asList("Pune Market Yard", "Kothrud Sabji Market", "Hadapsar Mandi"));
        mockMarketData.put("wardha", Arrays.asList("Wardha Main Mandi", "Hinganghat Market"));
    }

    private void showAlert(Alert.AlertType type, String title, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


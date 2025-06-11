package com.example.screens;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class PredictCropScreen extends Application {

    private Map<String, Double> mockPriceData = new HashMap<>();

    @Override
    public void start(Stage primaryStage) {
        initializeMockPrices();

        // Title
        Label titleLabel = new Label("Crop Price Predictor");
        titleLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        // Crop type dropdown
        ComboBox<String> cropSelector = new ComboBox<>();
        cropSelector.getItems().addAll("Wheat", "Rice", "Cotton", "Sugarcane", "Maize");
        cropSelector.setPromptText("Select Crop");

        // Location input
        TextField locationField = new TextField();
        locationField.setPromptText("Enter your location");

        // Season input
        ComboBox<String> seasonSelector = new ComboBox<>();
        seasonSelector.getItems().addAll("Kharif", "Rabi", "Zaid");
        seasonSelector.setPromptText("Select Season");

        // Predict button
        Button predictBtn = new Button("Predict Price");
        Label resultLabel = new Label();
        resultLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: green;");

        predictBtn.setOnAction(e -> {
            String crop = cropSelector.getValue();
            String location = locationField.getText();
            String season = seasonSelector.getValue();

            if (crop == null || location.isEmpty() || season == null) {
                showAlert(Alert.AlertType.WARNING, "Missing Input", "Please fill all fields.");
                return;
            }

            // Simulate price prediction (use static or average data for now)
            double price = mockPriceData.getOrDefault(crop, 0.0);
            resultLabel.setText("Predicted price of " + crop + " in " + location + " (" + season + "): ₹" + price + " per quintal");
        });

        // Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(titleLabel, cropSelector, locationField, seasonSelector, predictBtn, resultLabel);
        layout.setStyle("-fx-alignment: center; -fx-background-color: #ffffff;");

        // Scene
        Scene scene = new Scene(layout, 400, 350);
        primaryStage.setTitle("Predict Crop Price");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initializeMockPrices() {
        mockPriceData.put("Wheat", 2200.0);
        mockPriceData.put("Rice", 2500.0);
        mockPriceData.put("Cotton", 6400.0);
        mockPriceData.put("Sugarcane", 3100.0);
        mockPriceData.put("Maize", 1900.0);
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


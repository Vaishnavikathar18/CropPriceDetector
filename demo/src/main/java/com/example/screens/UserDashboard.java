package com.example.screens;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class UserDashboard extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Header label
        Label welcomeLabel = new Label("Welcome to Farmer Dashboard");
        welcomeLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        // Predict Crop Price button
        Button predictPriceBtn = new Button("Predict Crop Price");
        predictPriceBtn.setPrefWidth(200);
        predictPriceBtn.setOnAction(e -> {
            System.out.println("Navigating to PredictCropScreen...");
            // TODO: Load PredictCrop screen
        });

        // Find Nearby Mandis button
        Button findMarketsBtn = new Button("Find Nearby Mandis");
        findMarketsBtn.setPrefWidth(200);
        findMarketsBtn.setOnAction(e -> {
            System.out.println("Navigating to NearbyMarketsScreen...");
            // TODO: Load NearbyMarkets screen
        });

        // Logout button
        Button logoutBtn = new Button("Logout");
        logoutBtn.setPrefWidth(200);
        logoutBtn.setOnAction(e -> {
            System.out.println("Logging out...");
            primaryStage.close(); // Or redirect to login
        });

        // Layout
        VBox layout = new VBox(15);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(welcomeLabel, predictPriceBtn, findMarketsBtn, logoutBtn);
        layout.setStyle("-fx-alignment: center; -fx-background-color: #f0f0f0;");

        // Scene
        Scene scene = new Scene(layout, 350, 300);
        primaryStage.setTitle("Farmer Dashboard");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // For testing this screen directly
    public static void main(String[] args) {
        launch(args);
    }
}


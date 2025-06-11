package com.example.screens;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class LoginScreen extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Title label
        Label titleLabel = new Label("Farmer Login");
        titleLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        // Username input
        TextField usernameField = new TextField();
        usernameField.setPromptText("Enter your username");

        // Password input
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter your password");

        // Login button
        Button loginButton = new Button("Login");
        loginButton.setPrefWidth(100);
        loginButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();

            // Dummy login logic (later you’ll call API here)
            if ("farmer".equals(username) && "1234".equals(password)) {
                showAlert(Alert.AlertType.INFORMATION, "Login Successful", "Welcome, " + username + "!");
                // Load next screen here
            } else {
                showAlert(Alert.AlertType.ERROR, "Login Failed", "Invalid credentials. Try again.");
            }
        });

        // Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(titleLabel, usernameField, passwordField, loginButton);
        layout.setStyle("-fx-alignment: center; -fx-background-color: #f5f5f5;");

        // Scene setup
        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setTitle("Login | Farmer App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Alert helper
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

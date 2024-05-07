package com.example.act0_14;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class RegistroUsuarioApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Registro de Usuario");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(10);

        Label correoLabel = new Label("Correo:");
        TextField correoField = new TextField();
        grid.add(correoLabel, 0, 0);
        grid.add(correoField, 1, 0);

        Label passwordLabel = new Label("Contraseña:");
        PasswordField passwordField = new PasswordField();
        grid.add(passwordLabel, 0, 1);
        grid.add(passwordField, 1, 1);

        Label confirmPasswordLabel = new Label("Confirmar Contraseña:");
        PasswordField confirmPasswordField = new PasswordField();
        grid.add(confirmPasswordLabel, 0, 2);
        grid.add(confirmPasswordField, 1, 2);

        Label fechaAltaLabel = new Label("Fecha de Alta:");
        DatePicker fechaAltaPicker = new DatePicker();
        grid.add(fechaAltaLabel, 0, 3);
        grid.add(fechaAltaPicker, 1, 3);

        CheckBox privacidadCheckBox = new CheckBox("Activar privacidad");
        grid.add(privacidadCheckBox, 0, 4, 2, 1);

        Button registrarButton = new Button("Registrar");
        grid.add(registrarButton, 0, 5, 2, 1);

        registrarButton.setOnAction(e -> {
            // Verificar si las contraseñas coinciden
            if (!passwordField.getText().equals(confirmPasswordField.getText())) {
                showAlert(Alert.AlertType.ERROR, "Error", "Las contraseñas no coinciden.");
                return;
            }

            // Verificar si el correo está vacío
            if (correoField.getText().isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "Error", "Por favor, introduce un correo válido.");
                return;
            }

            // Verificar si la fecha de alta está seleccionada
            if (fechaAltaPicker.getValue() == null) {
                showAlert(Alert.AlertType.ERROR, "Error", "Por favor, selecciona una fecha de alta.");
                return;
            }

            // Mostrar mensaje de usuario registrado
            showAlert(Alert.AlertType.INFORMATION, "Éxito", "Usuario registrado correctamente.");
        });

        Button iniciarSesionButton = new Button("Iniciar Sesión");
        grid.add(iniciarSesionButton, 0, 6, 2, 1);

        iniciarSesionButton.setOnAction(e -> {
            Stage loginStage = new Stage();
            loginStage.setTitle("Iniciar Sesión");

            GridPane loginGrid = new GridPane();
            loginGrid.setPadding(new Insets(20, 20, 20, 20));
            loginGrid.setVgap(10);
            loginGrid.setHgap(10);

            Label userLabel = new Label("Usuario:");
            TextField userField = new TextField();
            loginGrid.add(userLabel, 0, 0);
            loginGrid.add(userField, 1, 0);

            Label passLabel = new Label("Contraseña:");
            PasswordField passField = new PasswordField();
            loginGrid.add(passLabel, 0, 1);
            loginGrid.add(passField, 1, 1);

            Button loginButton = new Button("Iniciar Sesión");
            loginGrid.add(loginButton, 0, 2, 2, 1);

            loginButton.setOnAction(event -> {
                if (userField.getText().equals("admin@gmail.com") && passField.getText().equals("123")) {
                    showAlert(Alert.AlertType.INFORMATION, "Éxito", "Inicio de sesión correcto.");
                    loginStage.close();
                } else {
                    showAlert(Alert.AlertType.ERROR, "Error", "Usuario o contraseña incorrectos.");
                }
            });

            Scene loginScene = new Scene(loginGrid, 300, 150);
            loginStage.setScene(loginScene);
            loginStage.show();
        });

        Scene scene = new Scene(grid, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

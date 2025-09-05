package com.libraries;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import org.kordamp.ikonli.javafx.FontIcon;
import org.controlsfx.control.Notifications;
import javafx.util.Duration;

import com.dlsc.formsfx.model.structure.Field;
import com.dlsc.formsfx.model.structure.Form;
import com.dlsc.formsfx.model.structure.Group;
import com.dlsc.formsfx.view.renderer.FormRenderer;

public class PrimaryController {

    @FXML
    private VBox rootVBox;

    @FXML
    public void initialize() {
        // Título principal estilizado
        Label label = new Label("Demo JavaFX: BootstrapFX, Ikonli, FormsFX, ControlsFX"); // Título principal
        label.getStyleClass().addAll("h5", "mb-4");
        rootVBox.getChildren().add(label);

        // Botón Ikonli con BootstrapFX
        Button iconButton = new Button("Java Icon", new FontIcon("di-java")); // Botón con icono
        iconButton.getStyleClass().addAll("btn", "btn-primary", "mb-3", "px-4", "py-2");
        rootVBox.getChildren().add(iconButton);

        // Formulario FormsFX con mejor distribución
        Form form = Form.of(
                Group.of(
                        Field.ofStringType("").label("Usuario"),
                        Field.ofStringType("").label("Email")))
                .title("Formulario de ejemplo"); // Formulario simple
        FormRenderer formRenderer = new FormRenderer(form);
        formRenderer.setStyle(
                "-fx-background-color: #f8f9fa; -fx-padding: 20; -fx-border-radius: 8; -fx-background-radius: 8; -fx-border-color: #dee2e6;");
        VBox formBox = new VBox(formRenderer);
        formBox.setSpacing(10);
        formBox.setStyle("-fx-alignment: center;");
        rootVBox.getChildren().add(formBox);

        // Botón de notificación ControlsFX
        Button notifButton = new Button("Mostrar Notificación"); // Botón
                                                                 // notificación
        notifButton.getStyleClass().addAll("btn", "btn-success", "mt-3", "px-4", "py-2");
        notifButton.setOnAction(e -> {
            Notifications.create()
                    .title("Mensaje Importante")
                    .text("¡Hola desde ControlsFX!")
                    .hideAfter(Duration.seconds(3))
                    .showInformation();
        });
        rootVBox.getChildren().add(notifButton);
    }

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}

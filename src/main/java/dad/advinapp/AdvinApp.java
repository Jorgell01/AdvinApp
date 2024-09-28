package dad.advinapp;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;

public class AdvinApp extends Application {

    private TextField numeroText;
    private Label numeroLabel;
    private Button comprobarButton;
    private int numeroAdvinar;
    private int intentos = 0;

    @Override
    public void start(Stage stage) throws Exception {

        Random random = new Random();
        numeroAdvinar = random.nextInt(100);

        numeroText = new TextField();
        numeroText.setText("0");
        numeroText.setAlignment(Pos.CENTER);
        numeroText.setPrefColumnCount(8);

        numeroLabel = new Label("Introduce un número del 1 al 100");

        comprobarButton = new Button();
        comprobarButton.setText("Comprobar");
        comprobarButton.setDefaultButton(true);
        comprobarButton.setOnAction(e -> comprobarNumero());

        HBox HboxnumeroText = new HBox();
        HboxnumeroText.setSpacing(5);
        HboxnumeroText.setAlignment(Pos.CENTER);
        HboxnumeroText.getChildren().add(numeroText);


        HBox Hboxnumerolabel = new HBox();
        Hboxnumerolabel.setSpacing(5);
        Hboxnumerolabel.setAlignment(Pos.CENTER);
        Hboxnumerolabel.getChildren().add(numeroLabel);

        HBox HboxcomprobarButton = new HBox();
        HboxcomprobarButton.setSpacing(5);
        HboxcomprobarButton.setAlignment(Pos.CENTER);
        HboxcomprobarButton.getChildren().add(comprobarButton);

        VBox root = new VBox();
        root.setSpacing(5);
        root.setFillWidth(false);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(Hboxnumerolabel, HboxnumeroText, HboxcomprobarButton);

        Scene scene = new Scene(root, 320, 240);

        stage.setTitle("AdvinApp");
        stage.setScene(scene);
        stage.show();

        numeroText.textProperty().addListener((o, ov, nv)-> {
            if (!nv.matches("\\d*")) {
                numeroText.setText(nv.replaceAll("[^\\d]", ""));
            }
        });
    }

    private void comprobarNumero() {
        String text =numeroText.getText();

        if (text.isEmpty()) {
            mostrarError("AdvinApp", "Error", "El número introducido no es válido.");
            return;
        }

        try {
            int numeroIntroducido = Integer.parseInt(text);
            intentos++;

            if (numeroIntroducido == numeroAdvinar) {
                mostrarAlerta(Alert.AlertType.INFORMATION, "AdvinApp", "¡Has ganado!", "Solo has necesitado " + intentos + " intentos. \n\nVuelve a jugar y hazlo mejor.");

                numeroAdvinar = new Random().nextInt(100);
                intentos = 0;
            } else if (numeroIntroducido < numeroAdvinar) {
                mostrarAlerta(Alert.AlertType.WARNING, "AdvinApp", "¡Has fallado!", "El número a adivinar es mayor que " + numeroIntroducido + ". \n\nVuelve a intentarlo");
            } else {
                mostrarAlerta(Alert.AlertType.WARNING, "AdvinApp", "¡Has fallado!", "El número a adivinar es menor que " + numeroIntroducido + ". \n\nVuelve a intentarlo");
            }
        } catch (NumberFormatException e) {
            mostrarError("AdvinApp", "Error", "El número introducido no es válido");
        }
    }

    private void mostrarAlerta(AlertType tipo, String titulo, String mensaje1, String mensaje2) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(mensaje1);
        alert.setContentText(mensaje2);
        alert.show();
    }

    private void mostrarError(String titulo, String mensaje1, String mensaje2) {
        mostrarAlerta(Alert.AlertType.ERROR, titulo, mensaje1, mensaje2);
    }
}

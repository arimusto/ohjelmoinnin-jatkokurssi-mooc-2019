package sovellus;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TervehtijaSovellus extends Application {

    public static void main(String[] args) {
        launch(TervehtijaSovellus.class);
    }

    @Override
    public void start(Stage ikkuna) {
        Label aloitusLabel = new Label("Kirjoita nimesi ja aloita.");
        TextField aloitusTextField = new TextField();
        Button aloitusButton = new Button("Aloita");
        Label tervetuloaLabel = new Label();

        GridPane aloitaAsettelu = new GridPane();
        aloitaAsettelu.setPrefSize(200, 100);
        aloitaAsettelu.add(aloitusLabel, 0, 0);
        aloitaAsettelu.add(aloitusTextField, 0, 1);
        aloitaAsettelu.add(aloitusButton, 0, 2);
        aloitaAsettelu.setAlignment(Pos.CENTER);
        aloitaAsettelu.setVgap(10);
        aloitaAsettelu.setHgap(10);
        aloitaAsettelu.setPadding(new Insets(20, 20, 20, 20));

        GridPane tervetuloaAsettelu = new GridPane();
        tervetuloaAsettelu.setPrefSize(200, 100);
        tervetuloaAsettelu.add(tervetuloaLabel, 0, 0);
        tervetuloaAsettelu.setAlignment(Pos.CENTER);
        tervetuloaAsettelu.setVgap(10);
        tervetuloaAsettelu.setHgap(10);
        tervetuloaAsettelu.setPadding(new Insets(20, 20, 20, 20));

        Scene aloitusNakyma = new Scene(aloitaAsettelu);
        Scene tervetuloaNakyma = new Scene(tervetuloaAsettelu);

        aloitusButton.setOnAction((event) -> {
            tervetuloaLabel.setText("Tervetuloa " + aloitusTextField.getText() + "!");
            ikkuna.setScene(tervetuloaNakyma);
        });

        ikkuna.setScene(aloitusNakyma);
        ikkuna.show();
    }
}

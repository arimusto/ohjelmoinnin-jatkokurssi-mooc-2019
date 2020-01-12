package tekstitilastointia;

import java.util.Arrays;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TekstitilastointiaSovellus extends Application {

    public static void main(String[] args) {
        launch(TekstitilastointiaSovellus.class);
    }

    @Override
    public void start(Stage ikkuna) {
        BorderPane asettelu = new BorderPane();

        TextArea tekstikentta = new TextArea();
        Label kirjaimiaLabel = new Label("Kirjaimia: 0");
        Label sanojaLabel = new Label("Sanoja: 0");
        Label pisinLabel = new Label("Pisin sana on:");

        tekstikentta.textProperty().addListener((muutos, vanhaArvo, uusiArvo) -> {
            int merkkeja = uusiArvo.length();
            String[] palat = uusiArvo.split(" ");
            int sanoja = palat.length;
            String pisin = Arrays.stream(palat)
                    .sorted((s1, s2) -> s2.length() - s1.length())
                    .findFirst()
                    .get();

            kirjaimiaLabel.setText("Kirjaimia: " + merkkeja);
            sanojaLabel.setText("Sanoja: " + sanoja);
            pisinLabel.setText("Pisin sana on: " + pisin);
        });

        HBox tekstit = new HBox();
        tekstit.setSpacing(10);
        tekstit.getChildren().add(kirjaimiaLabel);
        tekstit.getChildren().add(sanojaLabel);
        tekstit.getChildren().add(pisinLabel);

        asettelu.setCenter(tekstikentta);
        asettelu.setBottom(tekstit);

        Scene nakyma = new Scene(asettelu);

        ikkuna.setScene(nakyma);
        ikkuna.show();

    }

}

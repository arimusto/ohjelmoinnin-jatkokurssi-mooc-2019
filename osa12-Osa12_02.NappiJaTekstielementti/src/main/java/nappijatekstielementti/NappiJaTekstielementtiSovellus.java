package nappijatekstielementti;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class NappiJaTekstielementtiSovellus extends Application {

    public static void main(String[] args) {
        launch(NappiJaTekstielementtiSovellus.class);
    }

    @Override
    public void start(Stage ikkuna) {
        Button nappi = new Button("nappi");
        Label teksti = new Label("tekstielementti");

        FlowPane komponenttiryhma = new FlowPane();
        komponenttiryhma.getChildren().add(nappi);
        komponenttiryhma.getChildren().add(teksti);

        Scene nakyma = new Scene(komponenttiryhma);

        ikkuna.setScene(nakyma);
        ikkuna.show();
    }

}

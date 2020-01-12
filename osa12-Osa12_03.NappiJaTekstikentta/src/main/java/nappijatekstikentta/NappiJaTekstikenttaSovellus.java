package nappijatekstikentta;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class NappiJaTekstikenttaSovellus extends Application {

    public static void main(String[] args) {
        launch(NappiJaTekstikenttaSovellus.class);
    }

    @Override
    public void start(Stage ikkuna) {
        Button nappi = new Button("nappi");
        TextField teksti = new TextField("tekstikenttä");

        FlowPane komponenttiryhma = new FlowPane();
        komponenttiryhma.getChildren().add(nappi);
        komponenttiryhma.getChildren().add(teksti);

        Scene nakyma = new Scene(komponenttiryhma);

        ikkuna.setScene(nakyma);
        ikkuna.show();
    }

}

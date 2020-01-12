package ilmoitin;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class IlmoitinSovellus extends Application {

    public static void main(String[] args) {
        launch(IlmoitinSovellus.class);
    }

    @Override
    public void start(Stage ikkuna) {

        TextField tekstikentta = new TextField();
        Button nappi = new Button("Päivitä");
        Label teksti = new Label();

        nappi.setOnAction((event) -> {
            teksti.setText(tekstikentta.getText());
        });

        VBox asettelu = new VBox();
        asettelu.setSpacing(10);
        asettelu.getChildren().addAll(tekstikentta, nappi, teksti);

        Scene nakyma = new Scene(asettelu);

        ikkuna.setScene(nakyma);
        ikkuna.show();

    }

}

package sovellus;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class SanaharjoitteluSovellus extends Application {

    private Sanakirja sanakirja;

    public static void main(String[] args) {
        launch(SanaharjoitteluSovellus.class);
    }

    @Override
    public void init() throws Exception {
        this.sanakirja = new Sanakirja();
    }

    @Override
    public void start(Stage ikkuna) throws Exception {
        Harjoittelunakyma harjoittelunakyma = new Harjoittelunakyma(this.sanakirja);
        Syottonakyma syottonakyma = new Syottonakyma(this.sanakirja);

        BorderPane asettelu = new BorderPane();

        HBox valikko = new HBox();
        valikko.setPadding(new Insets(20, 20, 20, 20));
        valikko.setSpacing(10);

        Button lisaanappi = new Button("Lisää sanoja");
        Button harjoittelenappi = new Button("Harjoittele");

        valikko.getChildren().addAll(lisaanappi, harjoittelenappi);
        asettelu.setTop(valikko);

        lisaanappi.setOnAction((event) -> asettelu.setCenter(syottonakyma.getNakyma()));
        harjoittelenappi.setOnAction((event) -> asettelu.setCenter(harjoittelunakyma.getNakyma()));

        asettelu.setCenter(syottonakyma.getNakyma());

        Scene nakyma = new Scene(asettelu, 400, 300);

        ikkuna.setScene(nakyma);
        ikkuna.show();
    }
}

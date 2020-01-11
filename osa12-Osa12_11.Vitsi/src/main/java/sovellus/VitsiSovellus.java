package sovellus;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class VitsiSovellus extends Application {

    public static void main(String[] args) {
        launch(VitsiSovellus.class);
    }

    @Override
    public void start(Stage ikkuna) {
        Button vitsiNappi = new Button("Vitsi");
        Button vastausNappi = new Button("Vastaus");
        Button selitysNappi = new Button("Selitys");

        BorderPane asettelu = new BorderPane();

        HBox valikko = new HBox();
        valikko.setPadding(new Insets(20, 20, 20, 20));
        valikko.setSpacing(10);
        valikko.getChildren().addAll(vitsiNappi, vastausNappi, selitysNappi);

        asettelu.setTop(valikko);

        StackPane vitsiAsettelu = luoNakyma("What do you call a bear with no teeth?");
        StackPane vastausAsettelu = luoNakyma("A gummy bear.");
        StackPane selitysAsettelu = luoNakyma("Gummy bear is a sweetie.");

        vitsiNappi.setOnAction((event) -> asettelu.setCenter(vitsiAsettelu));
        vastausNappi.setOnAction((event) -> asettelu.setCenter(vastausAsettelu));
        selitysNappi.setOnAction((event) -> asettelu.setCenter(selitysAsettelu));

        asettelu.setCenter(vitsiAsettelu);

        Scene nakyma = new Scene(asettelu);

        ikkuna.setScene(nakyma);
        ikkuna.show();
    }

    private StackPane luoNakyma(String teksti) {

        StackPane asettelu = new StackPane();
        asettelu.setPrefSize(300, 80);
        asettelu.getChildren().add(new Label(teksti));
        asettelu.setAlignment(Pos.CENTER);

        return asettelu;
    }
}

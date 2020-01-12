package sovellus;

import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UseampiNakyma extends Application {

    public static void main(String[] args) {
        launch(UseampiNakyma.class);
    }

    @Override
    public void start(Stage ikkuna) {
        Label ekaLabel = new Label("Eka näkymä!");
        Button ekaNappi = new Button("Tokaan näkymään!");
        Label tokaLabel = new Label("Toka näkymä!");
        Button tokaNappi = new Button("Kolmanteen näkymään!");
        Label kolmasLabel = new Label("Kolmas näkymä!");
        Button kolmasNappi = new Button("Ekaan näkymään!");

        BorderPane ekaNakyma = new BorderPane();
        ekaNakyma.setTop(ekaLabel);
        ekaNakyma.setCenter(ekaNappi);

        VBox tokaNakyma = new VBox(tokaNappi, tokaLabel);

        GridPane kolmasNakyma = new GridPane();
        kolmasNakyma.add(kolmasLabel, 0, 0);
        kolmasNakyma.add(kolmasNappi, 1, 1);

        Scene eka = new Scene(ekaNakyma);
        Scene toka = new Scene(tokaNakyma);
        Scene kolmas = new Scene(kolmasNakyma);

        ekaNappi.setOnAction((event) -> {
            ikkuna.setScene(toka);
        });

        tokaNappi.setOnAction((event) -> {
            ikkuna.setScene(kolmas);
        });

        kolmasNappi.setOnAction((event) -> {
            ikkuna.setScene(eka);
        });

        ikkuna.setScene(eka);
        ikkuna.show();

    }

}

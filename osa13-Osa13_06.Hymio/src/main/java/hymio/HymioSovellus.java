package hymio;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class HymioSovellus extends Application {

    public static void main(String[] args) {
        launch(HymioSovellus.class);
    }

    @Override
    public void start(Stage ikkuna) {
        Canvas piirtoalusta = new Canvas(640, 640);
        GraphicsContext piirturi = piirtoalusta.getGraphicsContext2D();

        BorderPane asettelu = new BorderPane();
        asettelu.setCenter(piirtoalusta);
        
        piirturi.setFill(Color.BLACK);
        piirturi.fillRect(160, 80, 80, 80);
        piirturi.fillRect(400, 80, 80, 80);
        piirturi.fillRect(80, 320, 80, 80);
        piirturi.fillRect(480, 320, 80, 80);
        piirturi.fillRect(160, 400, 320, 80);

        Scene nakyma = new Scene(asettelu);

        ikkuna.setScene(nakyma);
        ikkuna.show();

    }

}

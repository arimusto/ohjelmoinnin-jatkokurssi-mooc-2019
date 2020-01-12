package piirturi;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PiirtoOhjelma extends Application {

    public void start(Stage stage) {
        final int leveys = 640;
        final int korkeus = 480;

        stage.setTitle("Piirto-ohjelma");

        Group root = new Group();
        Scene scene = new Scene(root);
        stage.setScene(scene);

        Canvas piirtoalusta = new Canvas(leveys, korkeus);
        root.getChildren().add(piirtoalusta);

        GraphicsContext piirturi = piirtoalusta.getGraphicsContext2D();

        int[][] piirrettavaAlue = new int[leveys][korkeus];

        scene.setOnMouseClicked((MouseEvent e) -> {
            // tehdään jotain kun hiirtä klikataan
            int x = (int) e.getX();
            int y = (int) e.getY();

            if (x >= 0 && x < leveys && y >= 0 && y < korkeus) {
                piirrettavaAlue[x][y] = 1;
            }
        });

        scene.setOnMouseDragged((MouseEvent e) -> {
            // tehdään jotain kun nappi pohjassa olevaa hiirtä siirretään
            int x = (int) e.getX();
            int y = (int) e.getY();

            if (x >= 0 && x < leveys && y >= 0 && y < korkeus) {
                piirrettavaAlue[x][y] = 1;
            }
        });

        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                piirturi.setFill(Color.WHITE);
                piirturi.clearRect(0, 0, leveys, korkeus);

                piirturi.setFill(Color.BLACK);

                for (int xaks = 0; xaks < leveys; xaks++) {
                    for (int yaks = 0; yaks < korkeus; yaks++) {
                        if (piirrettavaAlue[xaks][yaks] > 0) {
                            piirturi.fillRect(xaks, yaks, 2, 2);
                        }
                    }
                }

            }
        }.start();

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

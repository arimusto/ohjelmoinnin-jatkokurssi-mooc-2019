package kollaasi;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class KollaasiSovellus extends Application {

    @Override
    public void start(Stage stage) {

        Image lahdeKuva = new Image("file:monalisa.png");

        PixelReader kuvanLukija = lahdeKuva.getPixelReader();

        int leveys = (int) lahdeKuva.getWidth();
        int korkeus = (int) lahdeKuva.getHeight();
        int kollaasiLeveys = leveys / 2;
        int kollaasiKorkeus = korkeus / 2;

        WritableImage kohdeKuva = new WritableImage(leveys, korkeus);
        PixelWriter kuvanKirjoittaja = kohdeKuva.getPixelWriter();

        int yKoordinaatti = 0;
        while (yKoordinaatti < kollaasiKorkeus) {
            int xKoordinaatti = 0;
            while (xKoordinaatti < kollaasiLeveys) {

                Color vari = kuvanLukija.getColor(xKoordinaatti * 2, yKoordinaatti * 2);
                double punainen = 1 - vari.getRed();
                double vihrea = 1 - vari.getGreen();
                double sininen = 1 - vari.getBlue();
                double lapinakyvyys = vari.getOpacity();

                Color uusiVari = new Color(punainen, vihrea, sininen, lapinakyvyys);

                kuvanKirjoittaja.setColor(xKoordinaatti, yKoordinaatti, uusiVari);
                kuvanKirjoittaja.setColor(xKoordinaatti + kollaasiLeveys, yKoordinaatti, uusiVari);
                kuvanKirjoittaja.setColor(xKoordinaatti, yKoordinaatti + kollaasiKorkeus, uusiVari);
                kuvanKirjoittaja.setColor(xKoordinaatti + kollaasiLeveys, yKoordinaatti + kollaasiKorkeus, uusiVari);

                xKoordinaatti++;
            }

            yKoordinaatti++;
        }

        ImageView kuva = new ImageView(kohdeKuva);

        Pane pane = new Pane();
        pane.getChildren().add(kuva);

        stage.setScene(new Scene(pane));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

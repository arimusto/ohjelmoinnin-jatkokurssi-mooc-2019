package ristinolla;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class RistinollaSovellus extends Application {

    private String vuoro;
    private Label teksti;
    private String[][] peli;
    private boolean kaynnissa;

    public void alusta() {
        this.vuoro = "X";
        this.peli = new String[][]{{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};
        this.kaynnissa = true;
        this.teksti = new Label("Vuoro: X");
        teksti.setFont(Font.font("Monospaced", 32));

    }

    public static void main(String[] args) {
        launch(RistinollaSovellus.class);
    }

    @Override
    public void start(Stage ikkuna) {

        alusta();

        BorderPane asettelu = new BorderPane();

        asettelu.setTop(this.teksti);

        GridPane ruudukko = new GridPane();

        Button nappi00 = luoNappi();
        Button nappi01 = luoNappi();
        Button nappi02 = luoNappi();
        Button nappi10 = luoNappi();
        Button nappi11 = luoNappi();
        Button nappi12 = luoNappi();
        Button nappi20 = luoNappi();
        Button nappi21 = luoNappi();
        Button nappi22 = luoNappi();

        ruudukko.add(nappi00, 0, 0);
        ruudukko.add(nappi01, 0, 1);
        ruudukko.add(nappi02, 0, 2);
        ruudukko.add(nappi10, 1, 0);
        ruudukko.add(nappi11, 1, 1);
        ruudukko.add(nappi12, 1, 2);
        ruudukko.add(nappi20, 2, 0);
        ruudukko.add(nappi21, 2, 1);
        ruudukko.add(nappi22, 2, 2);

        asettelu.setCenter(ruudukko);

        nappi00.setOnMouseClicked((event) -> {
            if (this.peli[0][0].equals(" ") && this.kaynnissa) {
                this.peli[0][0] = this.vuoro;
                nappi00.setText(this.vuoro);
                vaihdaVuoro();
            }
        });

        nappi01.setOnMouseClicked((event) -> {
            if (this.peli[0][1].equals(" ") && this.kaynnissa) {
                this.peli[0][1] = this.vuoro;
                nappi01.setText(this.vuoro);
                vaihdaVuoro();
            }
        });

        nappi02.setOnMouseClicked((event) -> {
            if (this.peli[0][2].equals(" ") && this.kaynnissa) {
                this.peli[0][2] = this.vuoro;
                nappi02.setText(this.vuoro);
                vaihdaVuoro();
            }
        });

        nappi10.setOnMouseClicked((event) -> {
            if (this.peli[1][0].equals(" ") && this.kaynnissa) {
                this.peli[1][0] = this.vuoro;
                nappi10.setText(this.vuoro);
                vaihdaVuoro();
            }
        });

        nappi11.setOnMouseClicked((event) -> {
            if (this.peli[1][1].equals(" ") && this.kaynnissa) {
                this.peli[1][1] = this.vuoro;
                nappi11.setText(this.vuoro);
                vaihdaVuoro();
            }
        });

        nappi12.setOnMouseClicked((event) -> {
            if (this.peli[1][2].equals(" ") && this.kaynnissa) {
                this.peli[1][2] = this.vuoro;
                nappi12.setText(this.vuoro);
                vaihdaVuoro();
            }
        });

        nappi20.setOnMouseClicked((event) -> {
            if (this.peli[2][0].equals(" ") && this.kaynnissa) {
                this.peli[2][0] = this.vuoro;
                nappi20.setText(this.vuoro);
                vaihdaVuoro();
            }
        });

        nappi21.setOnMouseClicked((event) -> {
            if (this.peli[2][1].equals(" ") && this.kaynnissa) {
                this.peli[2][1] = this.vuoro;
                nappi21.setText(this.vuoro);
                vaihdaVuoro();
            }
        });

        nappi22.setOnMouseClicked((event) -> {
            if (this.peli[2][2].equals(" ") && this.kaynnissa) {
                this.peli[2][2] = this.vuoro;
                nappi22.setText(this.vuoro);
                vaihdaVuoro();
            }
        });

        Scene nakyma = new Scene(asettelu);

        ikkuna.setScene(nakyma);
        ikkuna.show();
    }

    private Button luoNappi() {
        Button nappi = new Button(" ");
        nappi.setFont(Font.font("Monospaced", 40));
        return nappi;
    }

    private void vaihdaVuoro() {
        tarkasta();
        if (this.kaynnissa) {
            if (this.vuoro.equals("X")) {
                this.vuoro = "O";
            } else {
                this.vuoro = "X";
            }
            this.teksti.setText("Vuoro: " + this.vuoro);
        } else {
            this.teksti.setText("Loppu!");
        }
    }

    private void tarkasta() {
        if (this.peli[0][0].equals(this.vuoro) && this.peli[0][1].equals(this.vuoro) && this.peli[0][2].equals(this.vuoro)) {
            this.kaynnissa = false;
        } else if (this.peli[1][0].equals(this.vuoro) && this.peli[1][1].equals(this.vuoro) && this.peli[1][2].equals(this.vuoro)) {
            this.kaynnissa = false;
        } else if (this.peli[2][0].equals(this.vuoro) && this.peli[2][1].equals(this.vuoro) && this.peli[2][2].equals(this.vuoro)) {
            this.kaynnissa = false;
        } else if (this.peli[0][0].equals(this.vuoro) && this.peli[1][0].equals(this.vuoro) && this.peli[2][0].equals(this.vuoro)) {
            this.kaynnissa = false;
        } else if (this.peli[0][1].equals(this.vuoro) && this.peli[1][1].equals(this.vuoro) && this.peli[2][1].equals(this.vuoro)) {
            this.kaynnissa = false;
        } else if (this.peli[0][2].equals(this.vuoro) && this.peli[1][2].equals(this.vuoro) && this.peli[2][2].equals(this.vuoro)) {
            this.kaynnissa = false;
        } else if (this.peli[0][0].equals(this.vuoro) && this.peli[1][1].equals(this.vuoro) && this.peli[2][2].equals(this.vuoro)) {
            this.kaynnissa = false;
        } else if (this.peli[0][2].equals(this.vuoro) && this.peli[1][1].equals(this.vuoro) && this.peli[2][0].equals(this.vuoro)) {
            this.kaynnissa = false;
        } else {
            this.kaynnissa = true;
        }
    }

}

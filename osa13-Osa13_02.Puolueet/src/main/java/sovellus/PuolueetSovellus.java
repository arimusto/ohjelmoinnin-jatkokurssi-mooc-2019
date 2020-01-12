package sovellus;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class PuolueetSovellus extends Application {

    public static void main(String[] args) {
        launch(PuolueetSovellus.class);
    }

    @Override
    public void start(Stage ikkuna) {

        HashMap<String, HashMap<Integer, Double>> data = new HashMap<>();
        int[] vuodet = new int[20];

        try (Scanner tiedostonLukija = new Scanner(new File("puoluedata.tsv"))) {

            while (tiedostonLukija.hasNextLine()) {
                HashMap<Integer, Double> kannatukset = new HashMap<>();
                String puolue = "";

                String rivi[] = tiedostonLukija.nextLine().split("\t");
                if (rivi[0].equals("Puolue")) {
                    for (int i = 1; i < rivi.length; i++) {
                        vuodet[i] = Integer.valueOf(rivi[i]);
                    }
                } else {
                    puolue = rivi[0];
                    for (int i = 1; i < rivi.length; i++) {
                        if (!rivi[i].equals("-")) {
                            kannatukset.put(vuodet[i], Double.valueOf(rivi[i]));
                        }
                    }
                    data.put(puolue, kannatukset);
                }
            }

        } catch (Exception e) {
            System.out.println("Virhe: " + e.getMessage());
        }

        final NumberAxis xAkseli = new NumberAxis(1968, 2008, 4);
        xAkseli.setLabel("Vuosi");
        final NumberAxis yAkseli = new NumberAxis();
        yAkseli.setLabel("Suhteellinen kannatus (%)");

        final LineChart<Number, Number> viivakaavio = new LineChart<>(xAkseli, yAkseli);
        viivakaavio.setTitle("Puolueiden suhteellinen kannatus");

        data.keySet().stream().forEach(puolue -> {
            XYChart.Series pdata = new XYChart.Series();
            pdata.setName(puolue);

            data.get(puolue).entrySet().stream().forEach(pari -> {
                pdata.getData().add(new XYChart.Data(pari.getKey(), pari.getValue()));
            });

            viivakaavio.getData().add(pdata);
        });

        Scene nakyma = new Scene(viivakaavio, 640, 480);
        ikkuna.setScene(nakyma);
        ikkuna.show();
    }
}

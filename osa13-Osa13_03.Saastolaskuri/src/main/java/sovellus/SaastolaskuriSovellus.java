package sovellus;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SaastolaskuriSovellus extends Application {

    Slider kkTallSlider = new Slider(25, 250, 5);
    Slider vvKorkoSlider = new Slider(0, 10, 0.1);

    Label kkTallSliderArvo = new Label(Double.toString(kkTallSlider.getValue()));
    Label vvKorkoSliderArvo = new Label(Double.toString(vvKorkoSlider.getValue()));

    public static void main(String[] args) {
        launch(SaastolaskuriSovellus.class);
    }

    @Override
    public void start(Stage ikkuna) {

        XYChart.Series tallData = new XYChart.Series();
        tallData.setName("talletukset");
        XYChart.Series korkoData = new XYChart.Series();
        korkoData.setName("säästöt");

        kkTallSlider.setShowTickLabels(true);
        kkTallSlider.setShowTickMarks(true);
        kkTallSlider.setMajorTickUnit(25);
        kkTallSlider.setMinorTickCount(4);
        kkTallSlider.setSnapToTicks(true);

        kkTallSlider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                    Number old_val, Number new_val) {
                kkTallSliderArvo.setText(String.format("%.0f", new_val));
                korkoData.getData().clear();
                tallData.getData().clear();

                korkoData.getData().add(new XYChart.Data(0, 0.0));
                tallData.getData().add(new XYChart.Data(0, 0.0));

                double saastot = 0.0;
                double talletukset = 0.0;
                double korko = 1 + vvKorkoSlider.getValue() / 100;

                for (int i = 1; i <= 30; i++) {
                    saastot = (saastot + kkTallSlider.getValue() * 12) * korko;
                    talletukset += kkTallSlider.getValue() * 12;

                    korkoData.getData().add(new XYChart.Data(i, saastot));
                    tallData.getData().add(new XYChart.Data(i, talletukset));
                }
            }
        });

        vvKorkoSlider.setShowTickLabels(true);
        vvKorkoSlider.setValue(0.0);

        vvKorkoSlider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                    Number old_val, Number new_val) {
                vvKorkoSliderArvo.setText(String.format("%.2f", new_val));
                korkoData.getData().clear();
                tallData.getData().clear();

                korkoData.getData().add(new XYChart.Data(0, 0.0));
                tallData.getData().add(new XYChart.Data(0, 0.0));

                double saastot = 0.0;
                double talletukset = 0.0;
                double korko = 1 + vvKorkoSlider.getValue() / 100;

                for (int i = 1; i <= 30; i++) {
                    saastot = (saastot + kkTallSlider.getValue() * 12) * korko;
                    talletukset += kkTallSlider.getValue() * 12;

                    korkoData.getData().add(new XYChart.Data(i, saastot));
                    tallData.getData().add(new XYChart.Data(i, talletukset));
                }
            }
        });

        BorderPane kkTall = new BorderPane();
        kkTall.setLeft(new Label("Kuukausittainen tallennus"));
        kkTall.setCenter(kkTallSlider);
        kkTall.setRight(kkTallSliderArvo);

        BorderPane vvKorko = new BorderPane();
        vvKorko.setLeft(new Label("Vuosittainen korko"));
        vvKorko.setCenter(vvKorkoSlider);
        vvKorko.setRight(vvKorkoSliderArvo);

        VBox asetteluYla = new VBox();
        asetteluYla.setSpacing(10);
        asetteluYla.getChildren().add(kkTall);
        asetteluYla.getChildren().add(vvKorko);

        NumberAxis xAkseli = new NumberAxis(0, 30, 1);
        NumberAxis yAkseli = new NumberAxis();

        LineChart<Number, Number> viivakaavio = new LineChart<>(xAkseli, yAkseli);

        viivakaavio.getData().add(tallData);
        viivakaavio.getData().add(korkoData);

        BorderPane asettelu = new BorderPane();
        asettelu.setPadding(new Insets(10, 10, 10, 10));
        asettelu.setTop(asetteluYla);
        asettelu.setCenter(viivakaavio);

        korkoData.getData().clear();
        tallData.getData().clear();

        korkoData.getData().add(new XYChart.Data(0, 0.0));
        tallData.getData().add(new XYChart.Data(0, 0.0));

        double saastot = 0.0;
        double talletukset = 0.0;
        double korko = 1 + vvKorkoSlider.getValue() / 100;

        for (int i = 1; i <= 30; i++) {
            saastot = (saastot + kkTallSlider.getValue() * 12) * korko;
            talletukset += kkTallSlider.getValue() * 12;

            korkoData.getData().add(new XYChart.Data(i, saastot));
            tallData.getData().add(new XYChart.Data(i, talletukset));
        }

        Scene nakyma = new Scene(asettelu);

        ikkuna.setScene(nakyma);
        ikkuna.show();
    }
}

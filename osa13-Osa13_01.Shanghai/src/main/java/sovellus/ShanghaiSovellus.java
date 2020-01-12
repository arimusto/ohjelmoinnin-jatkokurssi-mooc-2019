package sovellus;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class ShanghaiSovellus extends Application {

    public static void main(String[] args) {
        launch(ShanghaiSovellus.class);
    }

    @Override
    public void start(Stage ikkuna) {
        NumberAxis xAkseli = new NumberAxis(2006, 2018, 1);
        NumberAxis yAkseli = new NumberAxis();

        xAkseli.setLabel("Vuosi");
        yAkseli.setLabel("Sijoitus");

        LineChart<Number, Number> viivakaavio = new LineChart<>(xAkseli, yAkseli);
        viivakaavio.setTitle("Helsingin yliopisto, Shanghai-ranking");

        XYChart.Series hkiData = new XYChart.Series();
        hkiData.setName("sijoitus");

        hkiData.getData().add(new XYChart.Data(2007, 73));
        hkiData.getData().add(new XYChart.Data(2008, 68));
        hkiData.getData().add(new XYChart.Data(2009, 72));
        hkiData.getData().add(new XYChart.Data(2010, 72));
        hkiData.getData().add(new XYChart.Data(2011, 74));
        hkiData.getData().add(new XYChart.Data(2012, 73));
        hkiData.getData().add(new XYChart.Data(2013, 76));
        hkiData.getData().add(new XYChart.Data(2014, 73));
        hkiData.getData().add(new XYChart.Data(2015, 67));
        hkiData.getData().add(new XYChart.Data(2016, 56));
        hkiData.getData().add(new XYChart.Data(2017, 56));

        viivakaavio.getData().add(hkiData);

        Scene nakyma = new Scene(viivakaavio, 640, 480);
        ikkuna.setScene(nakyma);
        ikkuna.show();
    }
}

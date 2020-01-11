
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class KonekoeTehtava1 extends Application {

    public static void main(String[] args) {
        launch(KonekoeTehtava1.class);
    }

    @Override
    public void start(Stage ikkuna) {
        Button nappi = new Button("vaihda");

        TextField teksti1 = new TextField("teksti1");
        TextField teksti2 = new TextField("teksti2");

        nappi.setOnAction((event) -> {
            String varasto = teksti1.getText();
            teksti1.setText(teksti2.getText());
            teksti2.setText(varasto);
        });

        HBox asettelu = new HBox();
        asettelu.setSpacing(10);
        asettelu.getChildren().addAll(teksti1, nappi, teksti2);

        Scene nakyma = new Scene(asettelu);

        ikkuna.setScene(nakyma);
        ikkuna.show();
    }
}

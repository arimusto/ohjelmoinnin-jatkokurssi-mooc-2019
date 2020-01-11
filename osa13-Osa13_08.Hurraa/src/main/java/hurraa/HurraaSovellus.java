package hurraa;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

public class HurraaSovellus extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        AudioClip leike = new AudioClip("file:Alarm05.wav");

        BorderPane pane = new BorderPane();

        Button nappi = new Button("Hurraa!");
        nappi.setOnAction((event) -> {
            leike.stop();
            leike.play();
        });
        
        pane.setCenter(nappi);

        Scene scene = new Scene(pane, 600, 400);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

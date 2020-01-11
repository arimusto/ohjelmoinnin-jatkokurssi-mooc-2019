package asteroids;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AsteroidsSovellus extends Application {

    public static int leveys = 600;
    public static int korkeus = 400;
    public static int asteroidejaLuotu = 1;
    public static boolean tuliVapaa = true;

    public static void main(String[] args) {
        launch(AsteroidsSovellus.class);
    }

    public static int osiaToteutettu() {
        return 4;
    }

    @Override
    public void start(Stage ikkuna) {
        Pane ruutu = new Pane();
        ruutu.setPrefSize(leveys, korkeus);

        Text text = new Text(10, 20, "Pisteet: 0");
        ruutu.getChildren().add(text);
        AtomicInteger pisteet = new AtomicInteger();

        Text tuhottuja = new Text(10, 40, "Tuhottuja: 0");
        ruutu.getChildren().add(tuhottuja);
        AtomicInteger tuhotut = new AtomicInteger();

        Text asteroideja = new Text(10, 60, "Asteroideja:");
        ruutu.getChildren().add(asteroideja);

        Alus alus = new Alus(leveys / 2, korkeus / 2);
        ruutu.getChildren().add(alus.getHahmo());

        List<Asteroidi> asteroidit = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Random rnd = new Random();
            Asteroidi asteroidi = new Asteroidi(asteroidejaLuotu, rnd.nextInt(leveys / 3), rnd.nextInt(korkeus));
            asteroidit.add(asteroidi);
        }
        asteroidit.forEach(asteroidi -> ruutu.getChildren().add(asteroidi.getHahmo()));

        List<Ammus> ammukset = new ArrayList<>();

        Scene scene = new Scene(ruutu);
        ikkuna.setTitle("Asteroids!");
        ikkuna.setScene(scene);
        ikkuna.show();

        Map<KeyCode, Boolean> painetutNapit = new HashMap<>();

        scene.setOnKeyPressed(event -> {
            painetutNapit.put(event.getCode(), Boolean.TRUE);
        });

        scene.setOnKeyReleased(event -> {
            painetutNapit.put(event.getCode(), Boolean.FALSE);
            if (event.getCode() == KeyCode.SPACE) {
                tuliVapaa = true;
            }
        });

        new AnimationTimer() {

            @Override
            public void handle(long nykyhetki) {
                
                asteroideja.setText("Asteroideja: " + asteroidit.size());

                if (painetutNapit.getOrDefault(KeyCode.LEFT, false) || painetutNapit.getOrDefault(KeyCode.A, false)) {
                    alus.kaannaVasemmalle();
                }

                if (painetutNapit.getOrDefault(KeyCode.RIGHT, false) || painetutNapit.getOrDefault(KeyCode.D, false)) {
                    alus.kaannaOikealle();
                }

                if (painetutNapit.getOrDefault(KeyCode.UP, false) || painetutNapit.getOrDefault(KeyCode.W, false)) {
                    alus.kiihdyta();
                }

                if (painetutNapit.getOrDefault(KeyCode.DOWN, false) || painetutNapit.getOrDefault(KeyCode.S, false)) {
                    alus.jarruta();
                }

                if (painetutNapit.getOrDefault(KeyCode.SPACE, false) && ammukset.size() < 3 && tuliVapaa) {
                    Ammus ammus = new Ammus((int) alus.getHahmo().getTranslateX(), (int) alus.getHahmo().getTranslateY());
                    ammus.getHahmo().setRotate(alus.getHahmo().getRotate());
                    ammukset.add(ammus);
                    ammus.kiihdyta();
                    ammus.setLiike(ammus.getLiike().normalize().multiply(3));
                    ruutu.getChildren().add(ammus.getHahmo());
                    tuliVapaa = false;
                }
                alus.liiku();
                asteroidit.forEach(asteroidi -> asteroidi.liiku());
                ammukset.forEach(ammus -> {
                    ammus.kasvataLentoaika();
                    if (ammus.getLentoaika() > korkeus) {
                        ammus.setElossa(false);
                    }
                    ammus.liiku();
                });

                asteroidit.forEach(asteroidi -> {
                    if (alus.tormaa(asteroidi)) {
                        stop();
                    }
                });

                ammukset.forEach(ammus -> {
                    asteroidit.forEach(asteroidi -> {
                        if (ammus.tormaa(asteroidi)) {
                            ammus.setElossa(false);
                            asteroidi.setElossa(false);
                        }
                        if (!asteroidi.isElossa()) {
                            text.setText("Pisteet: " + pisteet.addAndGet(asteroidi.getPisteet()));
                            tuhottuja.setText("Tuhottuja: " + tuhotut.addAndGet(1));
                        }
                    });
                    if (ammus.tormaa(alus) && ammus.getLentoaika() > 10) {
                        stop();
                    }
                });

                ammukset.stream()
                        .filter(ammus -> !ammus.isElossa())
                        .forEach(ammus -> ruutu.getChildren().remove(ammus.getHahmo()));
                ammukset.removeAll(ammukset.stream()
                        .filter(ammus -> !ammus.isElossa())
                        .collect(Collectors.toList()));

                asteroidit.stream()
                        .filter(asteroidi -> !asteroidi.isElossa())
                        .forEach(asteroidi -> ruutu.getChildren().remove(asteroidi.getHahmo()));
                asteroidit.removeAll(asteroidit.stream()
                        .filter(asteroidi -> !asteroidi.isElossa())
                        .collect(Collectors.toList()));

                if (Math.random() < ((5.0 + asteroidejaLuotu) / 2000) && asteroidit.size() < 10) {
                    Asteroidi asteroidi = new Asteroidi(asteroidejaLuotu, leveys, korkeus);
                    if (!asteroidi.tormaa(alus)) {
                        asteroidit.add(asteroidi);
                        ruutu.getChildren().add(asteroidi.getHahmo());
                        asteroidejaLuotu++;
                    }
                }

            }
        }
                .start();
    }

}

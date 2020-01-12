
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Lukutaitovertailu {

    public static void main(String[] args) {

        ArrayList<String> rivit = new ArrayList<>();

        try {
            Files.lines(Paths.get("lukutaito.csv"))
                    .forEach(rivi -> rivit.add(rivi));
        } catch (Exception e) {
            System.out.println("Virhe: " + e.getMessage());
        }

        rivit.stream()
                .map(rivi -> rivi.replace(" male (%)", "male"))
                .map(rivi -> rivi.replace(" female (%)", "female"))
                .map(rivi -> rivi.split(","))
                .sorted((r1, r2) -> {
                    return r1[5].compareTo(r2[5]);
                })
                .forEach(rivi -> System.out.println(rivi[3] + " (" + rivi[4] + "), " + rivi[2] + ", " + rivi[5]));

    }
}


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LukujenKeskiarvo {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        // toteuta ohjelmasi tänne

        List<String> luvut = new ArrayList<>();

        while (true) {
            String luku = lukija.nextLine();

            if (luku.equals("loppu")) {
                break;
            }

            luvut.add(luku);
        }

        double keskiarvo = luvut.stream()
                .mapToInt(s -> Integer.valueOf(s))
                .average()
                .getAsDouble();

        System.out.println("Lukujen keskiarvo: " + keskiarvo);

    }
}


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TiettyjenLukujenKeskiarvo {

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

        System.out.println("Tulostetaanko negatiivisten vai positiivisten lukujen keskiarvo? (n/p)");

        String valinta = lukija.nextLine();

        if (valinta.equals("n")) {
            double keskiarvo = luvut.stream()
                    .mapToInt(s -> Integer.valueOf(s))
                    .filter(luku -> luku < 0)
                    .average()
                    .getAsDouble();
            
            System.out.println("Negatiivisten lukujen keskiarvo: " + keskiarvo);

        } else {
            double keskiarvo = luvut.stream()
                    .mapToInt(s -> Integer.valueOf(s))
                    .filter(luku -> luku >= 0)
                    .average()
                    .getAsDouble();
            
            System.out.println("Positiivisten lukujen keskiarvo: " + keskiarvo);

        }
    }
}

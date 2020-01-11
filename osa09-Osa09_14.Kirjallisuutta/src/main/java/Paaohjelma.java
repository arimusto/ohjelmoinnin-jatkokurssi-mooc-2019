
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Paaohjelma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        ArrayList<Kirja> kirjat = new ArrayList<>();

        while (true) {

            System.out.println("");
            System.out.print("Syötä kirjan nimi, tyhjä lopettaa: ");
            String nimi = lukija.nextLine();

            if (nimi.equals("")) {
                break;
            }

            System.out.print("Syötä kirjan pienin kohdeikä: ");
            int kohdeika = Integer.valueOf(lukija.nextLine());

            kirjat.add(new Kirja(nimi, kohdeika));
        }

        System.out.println("");
        System.out.println("Yhteensä " + kirjat.size() + " kirjaa.");

        System.out.println("");
        System.out.println("Kirjat:");

        Comparator<Kirja> vertailija = Comparator
                .comparing(Kirja::getKohdeika)
                .thenComparing(Kirja::getNimi);

        Collections.sort(kirjat, vertailija);

        kirjat.stream()
                .forEach(kirja -> System.out.println(kirja));
    }
}

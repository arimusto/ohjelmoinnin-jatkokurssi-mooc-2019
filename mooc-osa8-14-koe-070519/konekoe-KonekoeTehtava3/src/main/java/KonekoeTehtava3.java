
import java.util.Scanner;

public class KonekoeTehtava3 {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        Kasvihuone kasvihuone = new Kasvihuone();

        System.out.println("Kasvihuone!");

        while (true) {
            System.out.println("");
            System.out.println("x = lopeta");
            System.out.println("1 = lisää");
            System.out.println("2 = tulosta nimen perusteella järjestettynä");
            System.out.println("3 = kasvata tietyn nimistä");
            System.out.println("4 = tulosta pituuden perusteella järjestettynä");
            System.out.println("5 = kasvata kaikkia");
            System.out.println("");
            System.out.print("> ");

            String valinta = lukija.nextLine();

            if (valinta.equals("1")) {
                System.out.println("Minkä niminen kasvi lisätään?");
                String nimi = lukija.nextLine();
                System.out.println("Minkä pituinen kasvi on nyt?");
                int pituus = Integer.valueOf(lukija.nextLine());
                System.out.println("Mikä on kasvin maksimipituus?");
                int maksimipituus = Integer.valueOf(lukija.nextLine());

                kasvihuone.lisaaKasvi(new Kasvi(nimi, pituus, maksimipituus));

            } else if (valinta.equals("2")) {
                kasvihuone.tulostaNimenPerusteella();

            } else if (valinta.equals("3")) {
                System.out.println("Minkä nimistä kasvia kasvatetaan?");
                String nimi = lukija.nextLine();
                kasvihuone.kasvataNimenPerusteella(nimi);

            } else if (valinta.equals("4")) {
                kasvihuone.tulostaPituudenPerusteella();

            } else if (valinta.equals("5")) {
                kasvihuone.kasvataKaikkia();

            } else {
                break;
            }

        }
    }
}

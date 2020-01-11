
import java.util.Random;
import java.util.Scanner;

public class Ohjelma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        Random arpoja = new Random();

        System.out.println("Montako satunnaislukua tulostetaan?");
        int lukuja = Integer.valueOf(lukija.nextLine());

        for (int i = 0; i < lukuja; i++) {
            System.out.println(arpoja.nextInt(11));
        }
    }
}

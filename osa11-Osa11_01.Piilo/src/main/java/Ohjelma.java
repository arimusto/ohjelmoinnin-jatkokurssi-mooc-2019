
import java.util.Scanner;

public class Ohjelma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        // voit testata luokkaasi täällä
        Piilo<Integer> jemma = new Piilo<>();
        System.out.println(jemma.onkoPiilossa());
        jemma.laitaPiiloon(1);
        System.out.println(jemma.onkoPiilossa());
        System.out.println(jemma.onkoPiilossa());
        System.out.println(jemma.otaPiilosta());
        System.out.println(jemma.onkoPiilossa());
    }
}

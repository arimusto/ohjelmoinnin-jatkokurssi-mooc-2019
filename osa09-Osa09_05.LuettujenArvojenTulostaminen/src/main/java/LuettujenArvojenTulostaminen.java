
import java.util.ArrayList;
import java.util.Scanner;

public class LuettujenArvojenTulostaminen {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        ArrayList<String> merkkijonot = new ArrayList<>();

        while (true) {
            String luettu = lukija.nextLine();

            if (luettu.equals("")) {
                break;
            }

            merkkijonot.add(luettu);
        }

        merkkijonot.stream()
                .forEach(mjono -> System.out.println(mjono));

    }
}

package testausta;

import java.util.Scanner;

public class Ohjelma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        suorita(lukija);
    }

    public static String suorita(Scanner lukija) {
        int pulloja = 0;
        int keraajia = 0;
        while (true) {
            int syote = Integer.valueOf(lukija.nextLine());
            if (syote == -1){
                break;
            } else if (syote >= 0) {
                pulloja += syote;
                keraajia++;
            } else {
                continue;
            }
        }
        
        String palautettava = "";
        palautettava += "Pulloja: " + pulloja + "\n";
        palautettava += "Oppilaita: " + keraajia + "\n";
        
        if (keraajia > 0 && pulloja > 0){
            double keskiarvo = 1.0 * pulloja / keraajia;
            palautettava += "Keskiarvo: " + keskiarvo + "\n";
        } else {
            palautettava += "Keskiarvoa ei voida laskea\n";
        }
        
        
        System.out.println(palautettava);
        return palautettava;
    }
}

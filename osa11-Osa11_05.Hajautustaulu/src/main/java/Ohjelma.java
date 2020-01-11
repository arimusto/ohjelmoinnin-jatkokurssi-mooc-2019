
import java.util.Scanner;

public class Ohjelma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        // voit testata luokkaasi täällä
        
        Hajautustaulu<Integer, String> testi = new Hajautustaulu<>();
        
        for(int i = 0; i < 100; i++){
            testi.lisaa(i, "XYZ");
        }
        
        System.out.println(testi.hae(66));
    }

}

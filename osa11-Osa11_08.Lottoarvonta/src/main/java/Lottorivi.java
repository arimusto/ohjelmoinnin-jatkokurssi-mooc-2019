
import java.util.ArrayList;
import java.util.Random;

public class Lottorivi {

    private ArrayList<Integer> numerot;

    public Lottorivi() {
        // Arvo numerot heti LottoRivin luomisen yhteydessä
        this.arvoNumerot();
    }

    public ArrayList<Integer> numerot() {
        return this.numerot;
    }

    public void arvoNumerot() {
        Random arpoja = new Random();
        this.numerot = new ArrayList<>();
        while(this.numerot.size() < 7){
            int arvottu = arpoja.nextInt(40) + 1;
            if(!(sisaltaaNumeron(arvottu))){
                this.numerot.add(arvottu);
            }
        }
    }

    public boolean sisaltaaNumeron(int numero) {
        return this.numerot.contains(numero);
    }
}

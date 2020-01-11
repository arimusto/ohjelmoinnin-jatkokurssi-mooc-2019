package hiekkaranta;

import java.util.ArrayList;
import java.util.Random;

public class Simulaatio {

    private int leveys;
    private int korkeus;
    private Random random;
    private Tyyppi[][] simulaatio;

    public Simulaatio(int leveys, int korkeus) {
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.random = new Random();
        
        this.simulaatio = new Tyyppi[leveys][korkeus];
        for (int x = 0; x < leveys; x++) {
            for (int y = 0; y < korkeus; y++) {
                this.simulaatio[x][y] = Tyyppi.TYHJA;
            }
        }
    }

    public void lisaa(int x, int y, Tyyppi tyyppi) {
        if (x < 0 || x >= this.leveys || y < 0 || y >= this.korkeus){
            return;
        }
        this.simulaatio[x][y] = tyyppi;
    }

    public Tyyppi sisalto(int x, int y) {
        if (y < this.korkeus && y >= 0 && x < this.leveys && x >= 0) {
            if (this.simulaatio[x][y] == null) {
                return Tyyppi.TYHJA;
            } else {
                return this.simulaatio[x][y];
            }
        } else {
            return Tyyppi.METALLI;
        }
    }

    public void paivita() {
        for (int x = 0; x < this.leveys; x++){
            for (int y = this.korkeus - 1; y >= 0; y--){
                
            }
        }
    }
    
    public ArrayList<Piste> vapaatPaikat(int x, int y, Tyyppi tyyppi){
        ArrayList<Piste> vapaat = new ArrayList<>();
        
        return vapaat;
    }
}

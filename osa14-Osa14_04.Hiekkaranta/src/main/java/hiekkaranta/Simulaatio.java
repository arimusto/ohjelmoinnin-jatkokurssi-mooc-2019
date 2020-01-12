package hiekkaranta;

import java.util.ArrayList;
import java.util.Collections;
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
        if (x < 0 || x >= this.leveys || y < 0 || y >= this.korkeus) {
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
        for (int x = 0; x < this.leveys; x++) {
            for (int y = this.korkeus; y >= 0; y--) {
                if (sisalto(x, y) == Tyyppi.HIEKKA) {
                    siirraHiekkaaVetta(x, y);
                }
                if (sisalto(x, y) == Tyyppi.VESI) {
                    siirraHiekkaaVetta(x, y);
                }
            }
        }
    }

    public ArrayList<Piste> vapaatPaikat(int x, int y) {
        ArrayList<Piste> vapaat = new ArrayList<>();

        if (sisalto(x, y) == Tyyppi.HIEKKA) {
            if (sisalto(x - 1, y + 1) == Tyyppi.TYHJA || sisalto(x - 1, y + 1) == Tyyppi.VESI) {
                vapaat.add(new Piste(x - 1, y + 1));
            }
            if (sisalto(x, y + 1) == Tyyppi.TYHJA || sisalto(x, y + 1) == Tyyppi.VESI) {
                vapaat.add(new Piste(x, y + 1));
            }
            if (sisalto(x + 1, y + 1) == Tyyppi.TYHJA || sisalto(x + 1, y + 1) == Tyyppi.VESI) {
                vapaat.add(new Piste(x + 1, y + 1));
            }

            Collections.shuffle(vapaat);
        }

        if (sisalto(x, y) == Tyyppi.VESI) {
            if (sisalto(x - 1, y + 1) == Tyyppi.TYHJA) {
                vapaat.add(new Piste(x - 1, y + 1));
            }
            if (sisalto(x, y + 1) == Tyyppi.TYHJA) {
                vapaat.add(new Piste(x, y + 1));
            }
            if (sisalto(x + 1, y + 1) == Tyyppi.TYHJA) {
                vapaat.add(new Piste(x + 1, y + 1));
            }

            if (!vapaat.isEmpty()) {
                Collections.shuffle(vapaat);
            }

            if (vapaat.isEmpty()) {
                if (sisalto(x + 1, y) == Tyyppi.TYHJA) {
                    vapaat.add(new Piste(x + 1, y));
                }
                if (sisalto(x - 1, y) == Tyyppi.TYHJA) {
                    vapaat.add(new Piste(x - 1, y));
                }
            }
        }

        return vapaat;
    }

    public void siirraHiekkaaVetta(int x, int y) {
        ArrayList<Piste> vapaat = new ArrayList<>();
        vapaat = vapaatPaikat(x, y);

        if (vapaat.isEmpty()) {
            return;
        }

        Piste mihin = vapaat.get(0);
        Tyyppi temp = this.simulaatio[mihin.getX()][mihin.getY()];

        this.simulaatio[mihin.getX()][mihin.getY()] = this.simulaatio[x][y];
        this.simulaatio[x][y] = temp;
    }

}

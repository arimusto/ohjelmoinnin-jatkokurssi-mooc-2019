package schelling;

import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class Eriytymismalli {

    private Taulukko taulukko;

    private double prosAlueestaKaytossa;
    private int tyytyvaisyysraja;
    private int ryhmienLukumaara;

    private boolean kaynnissa;

    public Eriytymismalli(int leveys, int korkeus, int tyytyvaisyysraja, int ryhmienLukumaara, double prosAlueestaKaytossa) {
        this.taulukko = new Taulukko(leveys, korkeus);

        this.tyytyvaisyysraja = tyytyvaisyysraja;
        this.ryhmienLukumaara = ryhmienLukumaara;
        this.prosAlueestaKaytossa = prosAlueestaKaytossa;

        this.kaynnissa = false;
    }

    public void tyhjenna() {
        for (int x = 0; x < this.taulukko.getLeveys(); x++) {
            for (int y = 0; y < this.taulukko.getKorkeus(); y++) {
                this.taulukko.aseta(x, y, 0);
            }
        }
    }

    public void kaynnista() {
        this.kaynnissa = true;
    }

    public void sammuta() {
        this.kaynnissa = false;
    }

    public boolean onKaynnissa() {
        return this.kaynnissa;
    }

    public void asetaRyhmienLukumaara(int ryhmia) {
        this.ryhmienLukumaara = ryhmia;
    }

    public void asetaProsAlueestaKaytossa(double prosAlueestaKaytossa) {
        this.prosAlueestaKaytossa = prosAlueestaKaytossa;
    }

    public void asetaTyytyvaisyysRaja(int tyytyvaisyysraja) {
        this.tyytyvaisyysraja = tyytyvaisyysraja;

    }

    public void alusta() {
        arvoAlkuarvot();
    }

    public void arvoAlkuarvot() {
        Random arpoja = new Random();

        for (int x = 0; x < taulukko.getLeveys(); x++) {

            for (int y = 0; y < taulukko.getKorkeus(); y++) {

                // Random-luokan metodi nextDouble palauttaa satunnaisen luvun
                // nollan ja yhden välillä
                double satunnainenLukuNollanJaYhdenValilla = arpoja.nextDouble();

                // jos 100*arvo on pienempi kuin prosAlueestaKaytossa, paikkaan
                // asetetaan arvo
                if (100 * satunnainenLukuNollanJaYhdenValilla < prosAlueestaKaytossa) {
                    int ryhma = 1 + arpoja.nextInt(ryhmienLukumaara);

                    this.taulukko.aseta(x, y, ryhma);

                }
            }
        }
    }

    public Taulukko getData() {
        return this.taulukko;
    }

    public void setData(Taulukko taulukko) {
        this.taulukko = taulukko;
    }

    public ArrayList<Piste> tyhjatPaikat() {
        ArrayList<Piste> tyhjat = new ArrayList<>();
        for (int x = 0; x < this.taulukko.getLeveys(); x++) {
            for (int y = 0; y < this.taulukko.getKorkeus(); y++) {
                if (this.taulukko.hae(x, y) == 0) {
                    tyhjat.add(new Piste(x, y));
                }
            }
        }
        return tyhjat;
    }

    public void paivita() {
        ArrayList<Piste> tyytymattomat = haeTyytymattomat();

        if (tyytymattomat.isEmpty()) {
            return;
        }

        Collections.shuffle(tyytymattomat);

        while (!tyytymattomat.isEmpty()) {
            Piste tyytymaton = tyytymattomat.remove(0);

            ArrayList<Piste> tyhjat = tyhjatPaikat();
            Collections.shuffle(tyhjat);

            Piste tyhja = tyhjat.get(0);

            int tyytymattomanRyhma = this.taulukko.hae(tyytymaton.getX(), tyytymaton.getY());

            this.taulukko.aseta(tyhja.getX(), tyhja.getY(), tyytymattomanRyhma);
            this.taulukko.aseta(tyytymaton.getX(), tyytymaton.getY(), 0);
        }
    }

    public ArrayList<Piste> haeTyytymattomat() {
        ArrayList<Piste> tyytymattomat = new ArrayList<>();
        // Etsi täällä tyytymättömät
        for (int x = 0; x < this.taulukko.getLeveys(); x++) {
            for (int y = 0; y < this.taulukko.getKorkeus(); y++) {
                if (laskeTyytymattomat(x, y) < this.tyytyvaisyysraja) {
                    tyytymattomat.add(new Piste(x, y));
                }
            }
        }

        return tyytymattomat;
    }

    public int laskeTyytymattomat(int x, int y) {
        int tyytymattomat = 0;
        int tyyppi = this.taulukko.hae(x, y);

        for (int xmuutos = -1; xmuutos <= 1; xmuutos++) {
            for (int ymuutos = -1; ymuutos <= 1; ymuutos++) {
                int xkoord = x + xmuutos;
                int ykoord = y + ymuutos;
                if (xkoord >= 0 && xkoord < this.taulukko.getLeveys() && ykoord >= 0 && ykoord < this.taulukko.getKorkeus()) {
                    if (!(xkoord == x && ykoord == y) && this.taulukko.hae(xkoord, ykoord) == tyyppi) {
                        tyytymattomat++;
                    }
                }
            }
        }
        return tyytymattomat;
    }

}

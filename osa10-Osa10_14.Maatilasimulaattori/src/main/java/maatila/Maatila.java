/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maatila;

import java.util.ArrayList;

/**
 *
 * @author Ari Mustonen
 */
public class Maatila {

    private String omistaja;
    private Navetta navetta;
    private ArrayList<Lehma> lehmat;

    public Maatila(String omistaja, Navetta navetta) {
        this.omistaja = omistaja;
        this.navetta = navetta;
        this.lehmat = new ArrayList<>();
    }

    public void asennaNavettaanLypsyrobotti(Lypsyrobotti lypsyrobotti) {
        this.navetta.asennaLypsyrobotti(lypsyrobotti);
    }

    public void eleleTunti() {
        for (Lehma lehma : this.lehmat) {
            lehma.eleleTunti();
        }
    }

    public void hoidaLehmat() {
        this.navetta.hoida(this.lehmat);
    }

    public void lisaaLehma(Lehma lehma) {
        this.lehmat.add(lehma);
    }

    public String getOmistaja() {
        return this.omistaja;
    }

    public String getLehmat() {
        String palautettava;

        if (this.lehmat.size() == 0) {
            palautettava = "Ei lehmiä.";
        } else {
            palautettava = "Lehmät:";
            for (Lehma lehma : this.lehmat) {
                palautettava += "\n    " + lehma;
            }
        }
        return palautettava;
    }

    @Override
    public String toString() {
        String palautettava
                = "Maatilan omistaja: "
                + this.omistaja
                + "\nNavetan maitosäiliö: "
                + this.navetta.toString()
                + "\n"
                + this.getLehmat();
        return palautettava;
    }

}

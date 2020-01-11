/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ari Mustonen
 */
public class Kasvi {

    private String nimi;
    private int pituus;
    private int maksimipituus;

    public Kasvi(String nimi, int pituus, int maksimipituus) {
        this.nimi = nimi;
        this.pituus = pituus;
        this.maksimipituus = maksimipituus;

        if (this.pituus > this.maksimipituus) {
            this.pituus = this.maksimipituus;
        }
    }

    public void kasvata() {
        this.pituus++;
        if (this.pituus > this.maksimipituus) {
            this.pituus = this.maksimipituus;
        }
    }

    public String getNimi() {
        return this.nimi;
    }

    public int getPituus() {
        return this.pituus;
    }

    public String toString() {
        return this.nimi + ", " + this.pituus;
    }

}

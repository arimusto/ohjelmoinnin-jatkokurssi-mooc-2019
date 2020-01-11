/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maatila;

import java.util.Random;

/**
 *
 * @author Ari Mustonen
 */
public class Lehma implements Lypsava, Eleleva {

    private String nimi;
    private double utareet;
    private double maara;

    private static final String[] nimia = new String[]{
        "Anu", "Arpa", "Essi", "Heluna", "Hely",
        "Hento", "Hilke", "Hilsu", "Hymy", "Matti", "Ilme", "Ilo",
        "Jaana", "Jami", "Jatta", "Laku", "Liekki",
        "Mainikki", "Mella", "Mimmi", "Naatti",
        "Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
        "Rima", "Soma", "Sylkki", "Valpu", "Virpi"};

    public Lehma() {
        int rand = new Random().nextInt(Lehma.nimia.length);
        this.nimi = Lehma.nimia[rand];
        this.utareet = 15 + new Random().nextInt(26);
    }

    public Lehma(String nimi) {
        this.nimi = nimi;
        this.utareet = 15 + new Random().nextInt(26);
    }

    public String getNimi() {
        return this.nimi;
    }

    public double getTilavuus() {
        return this.utareet;
    }

    public double getMaara() {
        return this.maara;
    }

    @Override
    public double lypsa() {
        double lypsetty = this.maara;
        this.maara = 0;
        return lypsetty;
    }

    @Override
    public void eleleTunti() {
        double tuotanto = new Random().nextInt(14) / 10.0 + 0.7;
        this.maara += tuotanto;

        if (this.maara > this.utareet) {
            this.maara = this.utareet;
        }
    }

    @Override
    public String toString() {
        return this.nimi + " " + Math.ceil(this.maara) + "/" + Math.ceil(this.utareet);
    }
}

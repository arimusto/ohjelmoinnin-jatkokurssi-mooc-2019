/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ari
 */
public class Ostos {

    private String tuote;
    private int kappaletta;
    private int yksikkohinta;

    public Ostos(String tuote, int kpl, int yksikkohinta) {
        this.tuote = tuote;
        this.kappaletta = kpl;
        this.yksikkohinta = yksikkohinta;
    }

    public int hinta() {
        return this.kappaletta * this.yksikkohinta;
    }

    public String tuote() {
        return this.tuote;
    }

    public void kasvataMaaraa() {
        this.kappaletta++;
    }

    @Override
    public String toString() {
        return this.tuote + ": " + this.kappaletta;
    }

}

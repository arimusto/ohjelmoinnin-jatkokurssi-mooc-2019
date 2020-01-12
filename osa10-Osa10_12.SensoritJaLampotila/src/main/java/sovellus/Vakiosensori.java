/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sovellus;

/**
 *
 * @author ari
 */
public class Vakiosensori implements Sensori {

    private int lukema;

    public Vakiosensori(int lukema) {
        this.lukema = lukema;
    }

    @Override
    public boolean onPaalla() {
        return true;
    }

    @Override
    public void paalle() {
        // ei tee mitään
    }

    @Override
    public void poisPaalta() {
        // ei tee mitään
    }

    @Override
    public int mittaa() {
        return this.lukema;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sovellus;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ari
 */
public class Keskiarvosensori implements Sensori {

    private List<Sensori> sensorit;
    private List<Integer> mittaukset;

    public Keskiarvosensori() {
        this.sensorit = new ArrayList<>();
        this.mittaukset = new ArrayList<>();
    }

    public void lisaaSensori(Sensori lisattava) {
        this.sensorit.add(lisattava);
    }

    public List<Integer> mittaukset() {
        return this.mittaukset;
    }

    @Override
    public boolean onPaalla() {
        boolean paalla = true;

        for (Sensori sensori : this.sensorit) {
            paalla = (paalla && sensori.onPaalla());
        }

        return paalla;
    }

    @Override
    public void paalle() {
        for (Sensori sensori : this.sensorit) {
            sensori.paalle();
        }
    }

    @Override
    public void poisPaalta() {
        for (Sensori sensori : this.sensorit) {
            sensori.poisPaalta();
        }
    }

    @Override
    public int mittaa() {
        boolean paalla = true;

        for (Sensori sensori : this.sensorit) {
            paalla = (paalla && sensori.onPaalla());
        }

        if (!paalla) {
            throw new IllegalStateException("Keskiarvosensori ei ole päällä.");

        } else if (this.sensorit.isEmpty()) {
            throw new IllegalStateException("Keskiarvosensorille ei ole määritetty sensoreita.");

        } else {
            int sensoreita = 0;
            int lukemienSumma = 0;

            for (Sensori sensori : this.sensorit) {
                lukemienSumma += sensori.mittaa();
                sensoreita++;
            }

            int keskiarvo = lukemienSumma / sensoreita;
            this.mittaukset.add(keskiarvo);
            return keskiarvo;
        }
    }
}

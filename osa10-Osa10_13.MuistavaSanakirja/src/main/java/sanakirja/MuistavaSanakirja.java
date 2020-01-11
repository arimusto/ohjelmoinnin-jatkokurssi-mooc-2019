/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanakirja;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Ari Mustonen
 */
public class MuistavaSanakirja {

    private ArrayList<String> kotimainen;
    private ArrayList<String> vieras;
    private String tiedosto;

    public MuistavaSanakirja() {
        this.kotimainen = new ArrayList<>();
        this.vieras = new ArrayList<>();
    }

    public MuistavaSanakirja(String tiedosto) {
        this();
        this.tiedosto = tiedosto;
    }

    public boolean lataa() {
        try (Scanner tiedostonLukija = new Scanner(new File(this.tiedosto))) {
            while (tiedostonLukija.hasNextLine()) {
                String[] rivi = tiedostonLukija.nextLine().split(":");
                this.kotimainen.add(rivi[0]);
                this.vieras.add(rivi[1]);
            }
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean tallenna() {
        try (PrintWriter kirjoittaja = new PrintWriter(this.tiedosto)) {
            for (int i = 0; i < this.kotimainen.size(); i++) {
                kirjoittaja.println(this.kotimainen.get(i) + ":" + this.vieras.get(i));
            }
            kirjoittaja.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public void lisaa(String sana, String kaannos) {
        if (!(this.kotimainen.contains(sana) || this.vieras.contains(sana))) {
            this.kotimainen.add(sana);
            this.vieras.add(kaannos);
        }
    }

    public String kaanna(String sana) {
        if (this.kotimainen.indexOf(sana) != -1) {
            return this.vieras.get(this.kotimainen.indexOf(sana));
        }

        if (this.vieras.indexOf(sana) != -1) {
            return this.kotimainen.get(this.vieras.indexOf(sana));
        }

        return null;
    }

    public void poista(String sana) {
        int poistettava;

        if (this.kotimainen.indexOf(sana) != -1) {
            poistettava = this.kotimainen.indexOf(sana);
        } else if (this.vieras.indexOf(sana) != -1) {
            poistettava = this.vieras.indexOf(sana);
        } else {
            poistettava = -1;
        }

        if (poistettava >= 0) {
            this.kotimainen.remove(poistettava);
            this.vieras.remove(poistettava);
        }

    }
}

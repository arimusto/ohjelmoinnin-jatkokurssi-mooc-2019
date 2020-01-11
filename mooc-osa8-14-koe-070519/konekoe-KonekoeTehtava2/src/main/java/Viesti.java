/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ari Mustonen
 */
public class Viesti {

    private String osoite;
    private String sisalto;

    public Viesti(String osoite, String sisalto) {
        this.osoite = osoite;
        this.sisalto = sisalto;
    }

    public String getOsoite() {
        return this.osoite;
    }

    public String getSisalto() {
        return this.sisalto;
    }
}

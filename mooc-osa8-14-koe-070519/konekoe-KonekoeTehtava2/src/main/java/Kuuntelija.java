/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ari Mustonen
 */
public class Kuuntelija implements Reititin {
    
    private String nimi;
    
    public Kuuntelija(String nimi){
        this.nimi = nimi;
    }

    @Override
    public void reitita(Viesti viesti) {
        System.out.println(this.nimi + ": " + viesti.getSisalto());
    }
    
}

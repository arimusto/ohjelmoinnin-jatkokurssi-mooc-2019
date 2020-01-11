/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ari Mustonen
 */
public class Toistin implements Reititin {
    
    private Reititin reititin;
    
    public Toistin(Reititin reititin) {
        this.reititin = reititin;
    }
    
    @Override
    public void reitita(Viesti viesti) {
        this.reititin.reitita(viesti);
    }
    
}

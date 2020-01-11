/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ari Mustonen
 */
public class Palomuuri implements Reititin {
    
    private String saanto;
    private Reititin reitti;
    
    public Palomuuri(String saanto, Reititin reititin){
        this.saanto = saanto;
        this.reitti = reititin;
    }

    @Override
    public void reitita(Viesti viesti) {
        if(viesti.getOsoite().contains(this.saanto)){
            this.reitti.reitita(viesti);
        }
    }
    
}

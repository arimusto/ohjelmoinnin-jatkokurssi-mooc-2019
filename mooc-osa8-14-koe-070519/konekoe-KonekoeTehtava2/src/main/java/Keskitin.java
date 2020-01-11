
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ari Mustonen
 */
public class Keskitin implements Reititin {
    
    private ArrayList<Reititin> reitittimet;
    
    public Keskitin(){
        this.reitittimet = new ArrayList<>();
    }
    
    public void lisaaReititin(Reititin reititin){
        this.reitittimet.add(reititin);
    }

    @Override
    public void reitita(Viesti viesti) {
        for (Reititin reititin : this.reitittimet){
            reititin.reitita(viesti);
        }
    }
    
}

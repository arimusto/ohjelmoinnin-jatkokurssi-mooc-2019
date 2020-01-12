
import java.util.ArrayList;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ari
 */
public class Muutoshistoria {
    
    private ArrayList<Double> muutoshistoria;
    
    public Muutoshistoria(){
        this.muutoshistoria = new ArrayList<>();
    }
    
    public void lisaa(double tilanne){
        this.muutoshistoria.add(tilanne);
    }
    
    public void nollaa(){
        this.muutoshistoria.clear();
    }
    
    public double maxArvo(){
        if (this.muutoshistoria.size() > 0){
            return Collections.max(this.muutoshistoria);
        }
        return 0;
    }
    
    public double minArvo(){
        if(this.muutoshistoria.size() > 0){
            return Collections.min(this.muutoshistoria);
        }
        return 0;
    }
    
    public double keskiarvo(){
        if(this.muutoshistoria.size() == 0){
            return 0;
        }

        double summa = 0;
        for (double muutos: this.muutoshistoria){
            summa += muutos;
        }

        return summa / this.muutoshistoria.size();
    }
    
    @Override
    public String toString(){
        return this.muutoshistoria.toString();
    }
}

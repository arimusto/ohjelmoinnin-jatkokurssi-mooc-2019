
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ari
 */
public class Laatikko implements Talletettava {
    
    private double maksimipaino;
    private ArrayList<Talletettava> tavarat;
    
    public Laatikko(double maksimipaino){
        
        this.maksimipaino = maksimipaino;
        this.tavarat = new ArrayList<>();
    }
    
    public void lisaa(Talletettava tavara){
        
        if (this.paino() + tavara.paino() <= this.maksimipaino){
            this.tavarat.add(tavara);
        }
    }
    
    public double paino(){
        double paino = 0;
        
        for (Talletettava tavara: this.tavarat){
            paino += tavara.paino();
        }
        
        return paino;
    }
    
    @Override
    public String toString(){
        return "Laatikko: " + this.tavarat.size() + " esinettä, paino yhteensä " + this.paino() + " kiloa";
    }
    
}

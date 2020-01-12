/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ari
 */
public class CDLevy implements Talletettava {
    
    private String artisti;
    private String levynNimi;
    private int julkaisuvuosi;
    private double paino;
    
    public CDLevy(String artisti, String levynNimi, int julkaisuvuosi){
        
        this.artisti = artisti;
        this.levynNimi = levynNimi;
        this.julkaisuvuosi = julkaisuvuosi;
        this.paino = 0.1;
    }

    @Override
    public double paino() {
        
        return this.paino;
    }
    
    @Override
    public String toString(){
        
        return this.artisti + ": " + this.levynNimi + " (" + this.julkaisuvuosi + ")";
    }
    
}

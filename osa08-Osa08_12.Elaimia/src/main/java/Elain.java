/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ari Mustonen
 */
public abstract class Elain {
    
    protected String nimi;
    
    public Elain(String nimi){
        this.nimi = nimi;
    }
    
    public void syo(){
        System.out.println(this.nimi + " syo");
    }
    
    public void nuku(){
        System.out.println(this.nimi + " nukkuu");
    }
    
    public String getNimi(){
        return this.nimi;
    }
    
}

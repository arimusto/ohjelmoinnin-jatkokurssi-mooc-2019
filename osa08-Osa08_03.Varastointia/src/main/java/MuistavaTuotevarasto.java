
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
public class MuistavaTuotevarasto extends Tuotevarasto {
    
    private Muutoshistoria muutoshistoria;
    
    public MuistavaTuotevarasto(String tuotenimi, double tilavuus, double alkuSaldo){
        
        super(tuotenimi, tilavuus);
        this.saldo = alkuSaldo;
        this.muutoshistoria = new Muutoshistoria();
        this.muutoshistoria.lisaa(alkuSaldo);
    }
    
    @Override
    public void lisaaVarastoon(double maara){
        super.lisaaVarastoon(maara);
        this.muutoshistoria.lisaa(this.saldo);
    }
    
    @Override
    public double otaVarastosta(double maara){
        double palautettava = super.otaVarastosta(maara);
        this.muutoshistoria.lisaa(this.saldo);
        return palautettava;
    }
    
    public void tulostaAnalyysi(){
        System.out.println("Tuote: " + this.getNimi());
        System.out.println("Historia: " + this.historia());
        System.out.println("Suurin tuotemäärä: " + this.muutoshistoria.maxArvo());
        System.out.println("Pienin tuotemäärä: " + this.muutoshistoria.minArvo());
        System.out.println("Keskiarvo: " + this.muutoshistoria.keskiarvo());
    }
    
    public String historia(){
        return this.muutoshistoria.toString();
    }
}

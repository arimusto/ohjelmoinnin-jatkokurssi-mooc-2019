
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ari
 */
public class Lauma implements Siirrettava {
    
    private List<Siirrettava> jasenet;
    
    public Lauma(){
        this.jasenet = new ArrayList<>();
    }

    @Override
    public void siirra(int dx, int dy) {
        for(Siirrettava jasen : this.jasenet){
            jasen.siirra(dx, dy);
        }
    }
    
    public void lisaaLaumaan(Siirrettava siirrettava){
        this.jasenet.add(siirrettava);
    }
    
    @Override
    public String toString(){
        String palautettava = "";
        for(Siirrettava jasen : this.jasenet){
            palautettava += "\n" + jasen;
        }
        return palautettava;
    }
}

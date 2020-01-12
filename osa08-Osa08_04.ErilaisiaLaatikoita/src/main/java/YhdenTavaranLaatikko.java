
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
public class YhdenTavaranLaatikko extends Laatikko {
    
    private ArrayList<Tavara> tavarat;
    
    public YhdenTavaranLaatikko(){
        
        this.tavarat = new ArrayList<>();
    }

    @Override
    public void lisaa(Tavara tavara) {
        
        if (this.tavarat.size() == 0){
            this.tavarat.add(tavara);
        }
    }

    @Override
    public boolean onkoLaatikossa(Tavara tavara) {
        
        return this.tavarat.contains(tavara);
    }
}
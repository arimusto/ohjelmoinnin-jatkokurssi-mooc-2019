/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asteroids;

import java.util.Random;

/**
 *
 * @author Ari Mustonen
 */
public class Asteroidi extends Hahmo {
    
    private double pyorimisliike;
    private int pisteet;
    
    public Asteroidi(int numero, int x, int y) {
        super(new AsteroidiTehdas().luoAsteroidi(), x, y);
        
        Random rnd = new Random();

        super.getHahmo().setRotate(rnd.nextInt(360));

        int kiihdytystenMaara = numero / 2 + rnd.nextInt(1 + numero / 2);
        pisteet = 1 + kiihdytystenMaara;
        for (int i = 0; i < kiihdytystenMaara; i++) {
            super.kiihdyta();
        }

        this.pyorimisliike = 0.5 - rnd.nextDouble();
    }
    
    public int getPisteet(){
        return this.pisteet;
    }
    
    @Override
    public void liiku() {
        super.liiku();
        super.getHahmo().setRotate(super.getHahmo().getRotate() + pyorimisliike);
    }
}

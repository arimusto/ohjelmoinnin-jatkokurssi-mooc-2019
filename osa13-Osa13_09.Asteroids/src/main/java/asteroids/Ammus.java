/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asteroids;

import javafx.scene.shape.Polygon;

/**
 *
 * @author Ari Mustonen
 */
public class Ammus extends Hahmo {

    private int lentoaika;

    public Ammus(int x, int y) {
        super(new Polygon(2, -2, 2, 2, -2, 2, -2, -2), x, y);
        this.lentoaika = 0;
    }

    public void kasvataLentoaika() {
        this.lentoaika++;
    }

    public int getLentoaika() {
        return this.lentoaika;
    }
}

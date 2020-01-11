/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asteroids;

import javafx.geometry.Point2D;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

/**
 *
 * @author Ari Mustonen
 */
public abstract class Hahmo {

    private Polygon hahmo;
    private Point2D liike;
    private boolean elossa;

    public Hahmo(Polygon monikulmio, int x, int y) {
        this.hahmo = monikulmio;
        this.hahmo.setTranslateX(x);
        this.hahmo.setTranslateY(y);
        this.liike = new Point2D(0, 0);
        this.elossa = true;
    }

    public Polygon getHahmo() {
        return hahmo;
    }

    public Point2D getLiike() {
        return this.liike;
    }

    public void setLiike(Point2D liike) {
        this.liike = liike;
    }

    public void setElossa(boolean elossa) {
        this.elossa = elossa;
    }

    public boolean isElossa() {
        return this.elossa;
    }

    public void kaannaVasemmalle() {
        this.hahmo.setRotate(this.hahmo.getRotate() - 5);
    }

    public void kaannaOikealle() {
        this.hahmo.setRotate(this.hahmo.getRotate() + 5);
    }

    public void liiku() {
        this.hahmo.setTranslateX(this.hahmo.getTranslateX() + this.liike.getX());
        this.hahmo.setTranslateY(this.hahmo.getTranslateY() + this.liike.getY());

        if (this.hahmo.getTranslateX() < 0) {
            this.hahmo.setTranslateX(this.hahmo.getTranslateX() + AsteroidsSovellus.leveys);
        }

        if (this.hahmo.getTranslateX() > AsteroidsSovellus.leveys) {
            this.hahmo.setTranslateX(this.hahmo.getTranslateX() % AsteroidsSovellus.leveys);
        }

        if (this.hahmo.getTranslateY() < 0) {
            this.hahmo.setTranslateY(this.hahmo.getTranslateY() + AsteroidsSovellus.korkeus);
        }

        if (this.hahmo.getTranslateY() > AsteroidsSovellus.korkeus) {
            this.hahmo.setTranslateY(this.hahmo.getTranslateY() % AsteroidsSovellus.korkeus);
        }
    }

    public void kiihdyta() {
        double muutosX = Math.cos(Math.toRadians(this.hahmo.getRotate()));
        double muutosY = Math.sin(Math.toRadians(this.hahmo.getRotate()));

        muutosX *= 0.05;
        muutosY *= 0.05;

        this.liike = this.liike.add(muutosX, muutosY);
    }

    public void jarruta() {
        double muutosX = Math.cos(Math.toRadians(this.hahmo.getRotate())) * -1;
        double muutosY = Math.sin(Math.toRadians(this.hahmo.getRotate())) * -1;

        muutosX *= 0.05;
        muutosY *= 0.05;

        this.liike = this.liike.add(muutosX, muutosY);
    }

    public boolean tormaa(Hahmo toinen) {
        Shape tormaysalue = Shape.intersect(this.hahmo, toinen.getHahmo());
        return tormaysalue.getBoundsInLocal().getWidth() != -1;
    }

}

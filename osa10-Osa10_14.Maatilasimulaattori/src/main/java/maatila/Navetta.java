/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maatila;

import java.util.List;

/**
 *
 * @author Ari Mustonen
 */
public class Navetta {

    private Maitosailio maitosailio;
    private Lypsyrobotti lypsyrobotti;

    public Navetta(Maitosailio maitosailio) {
        this.maitosailio = maitosailio;
        this.lypsyrobotti = null;
    }

    public Maitosailio getMaitosailio() {
        return this.maitosailio;
    }

    public void asennaLypsyrobotti(Lypsyrobotti lypsyrobotti) {
        this.lypsyrobotti = lypsyrobotti;
        this.lypsyrobotti.setMaitosailio(this.maitosailio);
    }

    public void hoida(Lehma lehma) {
        if (this.lypsyrobotti != null) {
            this.lypsyrobotti.lypsa(lehma);
        } else {
            throw new IllegalStateException("Lypsyrobottia ei ole asennettu");
        }
    }

    public void hoida(List<Lehma> lehmat) {
        if (this.lypsyrobotti != null) {
            lehmat.forEach((lehma) -> {
                this.lypsyrobotti.lypsa(lehma);
            });
        } else {
            throw new IllegalStateException("Lypsyrobottia ei ole asennettu");
        }
    }

    @Override
    public String toString() {
        return this.maitosailio.toString();
    }
}

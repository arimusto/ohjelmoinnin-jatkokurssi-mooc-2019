/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maatila;

/**
 *
 * @author Ari Mustonen
 */
public class Lypsyrobotti {

    private Maitosailio maitosailio;

    public Lypsyrobotti() {
        this.maitosailio = null;
    }

    public Maitosailio getMaitosailio() {
        return this.maitosailio;
    }

    public void setMaitosailio(Maitosailio maitosailio) {
        this.maitosailio = maitosailio;
    }

    public void lypsa(Lypsava lypsava) {
        double lypsetty = lypsava.lypsa();

        if (this.getMaitosailio() != null) {
            this.maitosailio.lisaaSailioon(lypsetty);
        } else {
            System.out.println("Maidot menevät hukkaan!");
        }
    }
}

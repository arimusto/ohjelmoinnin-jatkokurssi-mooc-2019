
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ari Mustonen
 */
public class Putki<T> {

    private ArrayList<T> putkessa;

    public Putki() {
        this.putkessa = new ArrayList<>();
    }

    public void lisaaPutkeen(T arvo) {
        this.putkessa.add(arvo);
    }

    public T otaPutkesta() {
        if (this.putkessa.size() == 0) {
            return null;
        }

        T palautettava = this.putkessa.get(0);
        this.putkessa.remove(0);
        return palautettava;
    }

    public boolean onkoPutkessa() {
        return this.putkessa.size() > 0;
    }
}


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
public class Ostoskori {

    private List<Ostos> ostokset;

    public Ostoskori() {
        this.ostokset = new ArrayList<>();
    }

    public void lisaa(String tuote, int hinta) {
        boolean uusiTuote = true;
        for (Ostos ostos : this.ostokset) {
            if (ostos.tuote().equals(tuote)) {
                ostos.kasvataMaaraa();
                uusiTuote = false;
            }
        }

        if (uusiTuote) {
            this.ostokset.add(new Ostos(tuote, 1, hinta));
        }
    }

    public int hinta() {
        int yhteishinta = 0;

        for (Ostos ostos : this.ostokset) {
            yhteishinta += ostos.hinta();
        }

        return yhteishinta;
    }

    public void tulosta() {
        for (Ostos ostos : this.ostokset) {
            System.out.println(ostos);
        }
    }

}

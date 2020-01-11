
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ari Mustonen
 */
public class Tyontekijat {

    private ArrayList<Henkilo> henkilot;

    public Tyontekijat() {
        this.henkilot = new ArrayList<>();
    }

    public void lisaa(Henkilo lisattava) {
        this.henkilot.add(lisattava);
    }

    public void lisaa(List<Henkilo> lisattavat) {
        lisattavat.stream()
                .forEach(lisattava -> this.henkilot.add(lisattava));
    }

    public void tulosta() {
        Iterator<Henkilo> iteraattori = this.henkilot.iterator();

        while (iteraattori.hasNext()) {
            System.out.println(iteraattori.next());
        }
    }

    public void tulosta(Koulutus koulutus) {
        Iterator<Henkilo> iteraattori = this.henkilot.iterator();

        while (iteraattori.hasNext()) {
            Henkilo tulostettava = iteraattori.next();
            if (tulostettava.getKoulutus() == koulutus) {
                System.out.println(tulostettava);
            }
        }
    }

    public void irtisano(Koulutus koulutus) {
        Iterator<Henkilo> iteraattori = this.henkilot.iterator();

        while (iteraattori.hasNext()) {
            if (iteraattori.next().getKoulutus() == koulutus) {
                iteraattori.remove();
            }
        }
    }
}

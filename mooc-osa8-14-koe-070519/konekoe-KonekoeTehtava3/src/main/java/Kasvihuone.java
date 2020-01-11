
import java.util.ArrayList;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ari Mustonen
 */
public class Kasvihuone {

    private HashMap<String, Kasvi> kasvit;

    public Kasvihuone() {
        this.kasvit = new HashMap<>();
    }

    public void lisaaKasvi(Kasvi kasvi) {
        this.kasvit.put(kasvi.getNimi(), kasvi);
    }

    public void tulostaNimenPerusteella() {
        System.out.println("Tulostetaan kasvit nimen perusteella järjestettynä");
        this.kasvit.values().stream().sorted((k1, k2) -> {
            return k1.getNimi().compareTo(k2.getNimi());
        }).forEach(kasvi -> System.out.println(kasvi));
    }

    public void tulostaPituudenPerusteella() {
        System.out.println("Tulostetaan kasvit pituuden perusteella järjestettynä");
        this.kasvit.values().stream().sorted((k1, k2) -> {
            return k1.getPituus() - k2.getPituus();
        }).forEach(kasvi -> System.out.println(kasvi));
    }

    public void kasvataNimenPerusteella(String nimi) {
        if (this.kasvit.get(nimi) != null) {
            this.kasvit.get(nimi).kasvata();
        }
    }

    public void kasvataKaikkia() {
        System.out.println("Kasvatetaan kaikkia kasveja.");
        for (String nimi : this.kasvit.keySet()) {
            this.kasvit.get(nimi).kasvata();
        }
    }

}

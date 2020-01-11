
import java.util.ArrayList;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ari Mustonen
 */
public class Kasi implements Comparable<Kasi> {

    private ArrayList<Kortti> kortit;

    public Kasi() {
        this.kortit = new ArrayList<>();
    }

    public void lisaa(Kortti kortti) {
        this.kortit.add(kortti);
    }

    public void tulosta() {
        this.kortit.stream()
                .forEach(kortti -> System.out.println(kortti));
    }

    public void jarjesta() {
        Collections.sort(this.kortit);
    }

    public void jarjestaMaittain() {
        Collections.sort(this.kortit, new SamatMaatVierekkainArvojarjestykseen());
    }

    public int getSumma() {
        int summa = this.kortit.stream()
                .map(kortti -> kortti.getArvo())
                .reduce(0, (edellinenSumma, arvo) -> edellinenSumma + arvo);
        return summa;
    }

    @Override
    public int compareTo(Kasi o) {
        return this.getSumma() - o.getSumma();
    }
}

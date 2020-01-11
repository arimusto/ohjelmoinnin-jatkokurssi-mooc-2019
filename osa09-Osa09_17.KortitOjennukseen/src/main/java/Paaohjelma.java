
public class Paaohjelma {

    public static void main(String[] args) {
        // tee tänne testikoodia

        Kasi kasi = new Kasi();

        kasi.lisaa(new Kortti(12, Maa.HERTTA));
        kasi.lisaa(new Kortti(4, Maa.PATA));
        kasi.lisaa(new Kortti(2, Maa.RUUTU));
        kasi.lisaa(new Kortti(14, Maa.PATA));
        kasi.lisaa(new Kortti(2, Maa.RISTI));
        kasi.lisaa(new Kortti(7, Maa.HERTTA));
        kasi.lisaa(new Kortti(14, Maa.RISTI));
        kasi.lisaa(new Kortti(2, Maa.PATA));

        kasi.jarjestaMaittain();

        kasi.tulosta();
    }
}


public class Main {

    public static void main(String[] args) {
        // testaa täällä luokkiesi toimintaa
        Laatikko levyt = new Laatikko(2);

        levyt.lisaa(new CDLevy("Pink Floyd", "Dark Side of the Moon", 1973));
        levyt.lisaa(new CDLevy("Wigwam", "Nuclear Nightclub", 1975));
        levyt.lisaa(new CDLevy("Rendezvous Park", "Closer to Being Here", 2012));

        Laatikko kirjat = new Laatikko(5);

        kirjat.lisaa(new Kirja("Fedor Dostojevski", "Rikos ja Rangaistus", 2));
        kirjat.lisaa(new Kirja("Robert Martin", "Clean Code", 1));
        kirjat.lisaa(new Kirja("Kent Beck", "Test Driven Development", 0.7));

        Laatikko laatikko = new Laatikko(10);

        laatikko.lisaa(levyt);
        laatikko.lisaa(kirjat);
//        laatikko.lisaa(laatikko);
        
        System.out.println(laatikko);
        
    }

}


public class KonekoeTehtava2 {

    public static void main(String[] args) {
        Viesti exactum = new Viesti("Exactum", "Tämä viesti on menossa Exactumiin!");
        Viesti onnittelu = new Viesti("Onnittelu", "Hyvää kesää kaikille!");

        Kuuntelija ku1 = new Kuuntelija("K1");
        Kuuntelija ku2 = new Kuuntelija("K2");

        Palomuuri pa1 = new Palomuuri("Exa", ku1);
        Palomuuri pa2 = new Palomuuri("Onni", ku2);

        Keskitin k = new Keskitin();
        k.lisaaReititin(pa1);
        k.lisaaReititin(pa2);

        Toistin t = new Toistin(k);

        System.out.println("--");
        t.reitita(exactum);
        System.out.println("--");
        t.reitita(onnittelu);
    }

}

package sanakirja;

public class Main {

    public static void main(String[] args) {
        // Testaa sanakirjaa täällä
        MuistavaSanakirja sanakirja = new MuistavaSanakirja("sanat.txt");
        boolean onnistui = sanakirja.lataa();

        if (onnistui) {
            System.out.println("sanakirjan lataaminen onnistui");
        }

        sanakirja.lisaa("polkupyörä", "bike");
        sanakirja.lisaa("moottoripyörä", "motorcycle");
        sanakirja.lisaa("kissa", "cat");
        sanakirja.lisaa("bike", "polkupyörä");

        System.out.println(sanakirja.kaanna("apina"));
        System.out.println(sanakirja.kaanna("cat"));
        System.out.println(sanakirja.kaanna("polkupyörä"));

        onnistui = sanakirja.tallenna();

        if (onnistui) {
            System.out.println("sanakirjan tallentaminen onnistui");
        }

    }
}

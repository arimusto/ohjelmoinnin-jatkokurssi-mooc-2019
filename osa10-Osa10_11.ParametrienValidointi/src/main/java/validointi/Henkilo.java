package validointi;

public class Henkilo {

    private String nimi;
    private int ika;

    public Henkilo(String nimi, int ika) {
        
        if (nimi == null || nimi.length() > 40 || nimi.equals("")) {
            throw new IllegalArgumentException("Virheellinen nimi.");
        }

        if (ika < 0 || ika > 120) {
            throw new IllegalArgumentException("Virheellinen ikä.");
        }

        this.nimi = nimi;
        this.ika = ika;
    }

    public String getNimi() {
        return nimi;
    }

    public int getIka() {
        return ika;
    }
}


public class Taikaneliotehdas {

    public Taikanelio luoTaikanelio(int koko) {

        Taikanelio nelio = new Taikanelio(koko);

        int rivi = 0;
        int sarake = koko / 2;
        int luku = 1;
        int lukuja = koko * koko;

        while (luku <= lukuja) {
            nelio.asetaArvo(sarake, rivi, luku);

            int uusiRivi = rivi - 1;
            if (uusiRivi < 0) {
                uusiRivi = koko - 1;
            }

            int uusiSarake = sarake + 1;
            if (uusiSarake >= koko) {
                uusiSarake = 0;
            }

            if (nelio.annaArvo(uusiSarake, uusiRivi) == 0) {
                rivi = uusiRivi;
                sarake = uusiSarake;
            } else {
                rivi = rivi + 1;
                if (rivi >= koko) {
                    rivi = 0;
                }
            }
            luku++;
        }

        return nelio;
    }

}

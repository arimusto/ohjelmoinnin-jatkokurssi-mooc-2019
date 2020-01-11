
public class Ohjelma {

    public static void main(String[] args) {
        // Testaa metodiasi täällä
        int[][] matriisi = {
            {3, 2, 7, 6},
            {2, 4, 1, 0},
            {3, 2, 1, 0}
        };

        System.out.println(taulukkoMerkkijonona(matriisi));

    }

    public static String taulukkoMerkkijonona(int[][] taulukko) {
        StringBuilder palautettava = new StringBuilder();
        for (int rivi = 0; rivi < taulukko.length; rivi++) {
            if (rivi != 0) {
                palautettava.append("\n");
            }
            for (int sarake = 0; sarake < taulukko[rivi].length; sarake++) {
                palautettava.append(taulukko[rivi][sarake]);
            }
        }
        return palautettava.toString();
    }

}

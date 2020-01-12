package lentokentta;

import java.util.Scanner;
import lentokentta.logic.*;
import lentokentta.ui.Tekstikayttoliittyma;

public class Main {

    public static void main(String[] args) {
        // Kirjoita pääohjelma tänne. Omien luokkien tekeminen on hyödyllistä.
        Scanner lukija = new Scanner(System.in);

        Lentohallinta lentokentta = new Lentohallinta();
        Tekstikayttoliittyma kayttoliittyma = new Tekstikayttoliittyma(lentokentta, lukija);

        kayttoliittyma.kaynnista();

    }
}

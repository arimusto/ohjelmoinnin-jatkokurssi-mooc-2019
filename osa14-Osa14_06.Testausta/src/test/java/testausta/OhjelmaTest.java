package testausta;

import java.util.Scanner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;

public class OhjelmaTest {

    // toteuta tänne testit luokkaa Ohjelma-varten
    @Test
    public void testaaKolme() {
        assertEquals("Pulloja: 12\n" + "Oppilaita: 3\n" + "Keskiarvo: 4.0\n", Ohjelma.suorita(new Scanner("3\n4\n5\n-1\n")));
    }

    @Test
    public void testaaNegatiivinen() {
        assertEquals("Pulloja: 12\n" + "Oppilaita: 3\n" + "Keskiarvo: 4.0\n", Ohjelma.suorita(new Scanner("3\n-2\n4\n-3\n5\n-1\n")));
    }

    @Test
    public void testaaNolla() {
        assertEquals("Pulloja: 0\n" + "Oppilaita: 1\n" + "Keskiarvoa ei voida laskea\n", Ohjelma.suorita(new Scanner("0\n-1\n")));
    }

    @Test
    public void testaaLaiskuri() {
        assertEquals("Pulloja: 9\n" + "Oppilaita: 3\n" + "Keskiarvo: 3.0\n", Ohjelma.suorita(new Scanner("0\n4\n5\n-1\n")));
    }

}

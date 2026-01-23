import Practicum_4b.Auto;
import Practicum_4b.AutoHuur;
import Practicum_4b.Klant;

import org.junit.Test;
import static org.junit.Assert.*;

public class AutoHuurTest {

    @Test
    public void testGeenHuurderGeenAuto_prijsIs0() {
        AutoHuur ah = new AutoHuur();
        ah.setAantalDagen(0);
        assertEquals(0.0, ah.totaalPrijs(), 0.0001);
    }

    @Test
    public void testGeenHuurderGeenAuto_metDagen_prijsIs0() {
        AutoHuur ah = new AutoHuur();
        ah.setAantalDagen(5);
        assertEquals(0.0, ah.totaalPrijs(), 0.0001);
    }

    @Test
    public void testWelAutoGeenHuurder_prijsIs0() {
        AutoHuur ah = new AutoHuur();
        ah.setGehuurdeAuto(new Auto("Peugeot 207", 50));
        ah.setAantalDagen(3);
        assertEquals(0.0, ah.totaalPrijs(), 0.0001);
    }

    @Test
    public void testWelHuurderGeenAuto_prijsIs0() {
        AutoHuur ah = new AutoHuur();
        Klant k = new Klant("Mijnheer de Vries");
        k.setKorting(10.0);
        ah.setHuurder(k);
        ah.setAantalDagen(3);
        assertEquals(0.0, ah.totaalPrijs(), 0.0001);
    }

    @Test
    public void testHuurderZonderKortingMetAuto_prijsKlopt() {
        AutoHuur ah = new AutoHuur();
        Klant k = new Klant("Mevrouw Jansen"); // korting 0
        Auto a = new Auto("Toyota Aygo", 40);

        ah.setHuurder(k);
        ah.setGehuurdeAuto(a);
        ah.setAantalDagen(2);

        assertEquals(80.0, ah.totaalPrijs(), 0.0001);
    }

    @Test
    public void testHuurderMetKortingMetAuto_prijsKlopt() {
        AutoHuur ah = new AutoHuur();
        Klant k = new Klant("Mijnheer de Vries");
        k.setKorting(10.0);
        Auto a = new Auto("Ferrari", 3500);

        ah.setHuurder(k);
        ah.setGehuurdeAuto(a);
        ah.setAantalDagen(1);

        assertEquals(3150.0, ah.totaalPrijs(), 0.0001);
    }

    @Test
    public void testAantalDagenNegatiefWordt0() {
        AutoHuur ah = new AutoHuur();
        ah.setAantalDagen(-3);
        assertEquals(0, ah.getAantalDagen());
    }

    @Test
    public void testToString_bevatKerninfo() {
        AutoHuur ah = new AutoHuur();
        Klant k = new Klant("Mijnheer de Vries");
        k.setKorting(10.0);
        Auto a = new Auto("Peugeot 207", 50);

        ah.setHuurder(k);
        ah.setGehuurdeAuto(a);
        ah.setAantalDagen(4);

        String s = ah.toString();
        assertTrue(s.contains("Peugeot 207"));
        assertTrue(s.contains("Mijnheer de Vries"));
        assertTrue(s.contains("aantal dagen: 4"));
        assertTrue(s.contains("180.0"));
    }
}
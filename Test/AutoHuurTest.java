import Practicum_4b.Auto;
import Practicum_4b.AutoHuur;
import Practicum_4b.Klant;

import org.junit.Test;
import static org.junit.Assert.*;

public class AutoHuurTest {

    // geen huurder, geen auto = prijs 0
    @Test
    public void testGeenHuurderGeenAuto() {
        AutoHuur ah = new AutoHuur();
        ah.setAantalDagen(5);
        assertEquals(0.0, ah.totaalPrijs(), 0.0001);
    }

    // wel auto, geen huurder =  prijs 0
    @Test
    public void testWelAutoGeenHuurder() {
        AutoHuur ah = new AutoHuur();
        Auto a = new Auto("Peugeot 207", 50);
        ah.setGehuurdeAuto(a);
        ah.setAantalDagen(3);
        assertEquals(0.0, ah.totaalPrijs(), 0.0001);
    }

    // wel huurder (met korting), geen auto = prijs 0
    @Test
    public void testWelHuurderGeenAuto() {
        AutoHuur ah = new AutoHuur();
        Klant k = new Klant("Mijnheer de Vries");
        k.setKorting(10.0);
        ah.setHuurder(k);
        ah.setAantalDagen(3);
        assertEquals(0.0, ah.totaalPrijs(), 0.0001);
    }

    // huurder zónder korting + auto
    @Test
    public void testHuurderZonderKortingMetAuto() {
        AutoHuur ah = new AutoHuur();
        Klant k = new Klant("Mevrouw Jansen");    // standaard korting 0.0
        Auto a = new Auto("Toyota Aygo", 40);      // 40 per dag
        ah.setHuurder(k);
        ah.setGehuurdeAuto(a);
        ah.setAantalDagen(2);                      // 2 * 40 = 80
        assertEquals(80.0, ah.totaalPrijs(), 0.0001);
    }

    // huurder mét korting + auto (voorbeeld uit de opdracht: Ferrari)
    @Test
    public void testHuurderMetKortingMetAuto() {
        AutoHuur ah = new AutoHuur();
        Klant k = new Klant("Mijnheer de Vries");
        k.setKorting(10.0);                        // 10% korting
        Auto a = new Auto("Ferrari", 3500);        // 3500 per dag
        ah.setHuurder(k);
        ah.setGehuurdeAuto(a);
        ah.setAantalDagen(1);                      // 3500 - 10% = 3150
        assertEquals(3150.0, ah.totaalPrijs(), 0.0001);
    }

    // eerst geen auto, daarna later een auto koppelen
    @Test
    public void testAutoLaterGekoppeld() {
        AutoHuur ah = new AutoHuur();
        Klant k = new Klant("Klant Dynamisch");
        ah.setHuurder(k);
        ah.setAantalDagen(4);

        // nog geen auto = prijs 0
        assertEquals(0.0, ah.totaalPrijs(), 0.0001);

        Auto a = new Auto("Volkswagen Golf", 70);  // 70 per dag
        ah.setGehuurdeAuto(a);                     // nu wel auto
        assertEquals(280.0, ah.totaalPrijs(), 0.0001); // 4 * 70
    }

    // extra: toString met alles ingevuld bevat de belangrijkste stukken tekst
    @Test
    public void testToString() {
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
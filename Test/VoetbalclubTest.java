import Practicum_3a.Voetbalclub;
import static org.junit.Assert.*;
import org.junit.Test;

public class VoetbalclubTest {

    @Test
    public void testLegeNaamWordtFC() {
        Voetbalclub club = new Voetbalclub("");
        assertEquals("FC", club.toString().substring(0, 2));
    }

    @Test
    public void testNullNaamWordtFC() {
        Voetbalclub club = new Voetbalclub(null);
        assertEquals("FC", club.toString().substring(0, 2));
    }

    @Test
    public void testWinstGeeft3Punten() {
        Voetbalclub club = new Voetbalclub("Ajax");
        club.verwerkResultaat('w');
        assertEquals(3, club.aantalPunten());
        assertEquals(1, club.aantalGespeeld());
    }

    @Test
    public void testGelijkGeeft1Punt() {
        Voetbalclub club = new Voetbalclub("Ajax");
        club.verwerkResultaat('g');
        assertEquals(1, club.aantalPunten());
        assertEquals(1, club.aantalGespeeld());
    }

    @Test
    public void testVerliesGeeft0Punten() {
        Voetbalclub club = new Voetbalclub("Ajax");
        club.verwerkResultaat('v');
        assertEquals(0, club.aantalPunten());
        assertEquals(1, club.aantalGespeeld());
    }

    @Test
    public void testFouteInvoerGeeftGeenEffect() {
        Voetbalclub club = new Voetbalclub("Ajax");
        club.verwerkResultaat('x');
        assertEquals(0, club.aantalPunten());
        assertEquals(0, club.aantalGespeeld());
    }

    @Test
    public void testHerhaaldVerwerkenGeeftCorrectTotaal() {
        Voetbalclub club = new Voetbalclub("Feijenoord");
        club.verwerkResultaat('w'); // 3
        club.verwerkResultaat('w'); // 6
        club.verwerkResultaat('g'); // 7
        club.verwerkResultaat('v'); // 7
        assertEquals(4, club.aantalGespeeld());
        assertEquals(7, club.aantalPunten());
    }
}
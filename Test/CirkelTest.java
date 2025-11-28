import Practicum_3b.Cirkel;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class CirkelTest {

    @Test
    public void testValidCircleToString() {
        Cirkel c = new Cirkel(10, 0, 0);
        assertEquals("cirkel (0, 0) met radius: 10", c.toString());
    }

    @Test
    public void testRadiusWithNegativeRadius() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Cirkel(-1, 10, 2);
        });
        assertEquals("Radius moet groter dan 0 zijn!", exception.getMessage());
    }

    @Test
    public void testRadiusWithZeroRadius() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Cirkel(0, 10, 2);
        });
        assertEquals("Radius moet groter dan 0 zijn!", exception.getMessage());
    }

    @Test
    public void testToStringFormatIsCorrect() {
        Cirkel c = new Cirkel(5, 3, 8);
        assertEquals("cirkel (3, 8) met radius: 5", c.toString());
    }
}
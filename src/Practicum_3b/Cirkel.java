package Practicum_3b;

public class Cirkel {

    private int radius;
    private int xPositie;
    private int yPositie;

    // Zonder try-catch stopt de klasse tijdens de uitvoering.
    // De constructor van Cirkel gooit een IllegalArgumentException wanneer
    // de radius 0 of kleiner is. Omdat deze exception dan niet wordt opgevangen,
    // waardoor het niet werkt en de rest van de code niet meer wordt uitgevoerd.

    public Cirkel(int rad, int x, int y) {
        if (rad <= 0) {
            throw new IllegalArgumentException("Radius moet groter dan 0 zijn!");
        }
        this.radius = rad;
        this.xPositie = x;
        this.yPositie = y;
    }

    @Override
    public String toString() {
        return "cirkel (" + xPositie + ", " + yPositie + ") met radius: " + radius;
    }
}
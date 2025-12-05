package Practicum_4a;

public class Persoon {
    // attributen
    private String naam;
    private int leeftijd;

    // constructor
    public Persoon(String nm, int lft) {
        this.naam = nm;
        this.leeftijd = lft;
    }

    // toString
    @Override
    public String toString() {
        return naam + "; leeftijd " + leeftijd + " jaar";
    }
}
package Practicum_8;

public class Fiets extends Voertuig {

    private int framenummer;

    public Fiets(String tp, double pr, int jr, int fnr) {
        super(tp, pr, jr);
        this.framenummer = fnr;
    }

    @Override
    public double huidigeWaarde() {
        int huidigJaar = java.time.Year.now().getValue();
        int leeftijd = huidigJaar - bouwjaar;
        return nieuwprijs * Math.pow(0.9, leeftijd);
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        Fiets other = (Fiets) obj;
        return framenummer == other.framenummer;
    }
}

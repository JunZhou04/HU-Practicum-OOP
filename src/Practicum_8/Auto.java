package Practicum_8;

public class Auto extends Voertuig {

    private String kenteken;

    public Auto(String tp, double pr, int jr, String kt) {
        super(tp, pr, jr);
        this.kenteken = kt;
    }

    @Override
    public double huidigeWaarde() {
        int huidigJaar = java.time.Year.now().getValue();
        int leeftijd = huidigJaar - bouwjaar;
        return nieuwprijs * Math.pow(0.7, leeftijd);
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        Auto other = (Auto) obj;
        return kenteken.equals(other.kenteken);
    }
}

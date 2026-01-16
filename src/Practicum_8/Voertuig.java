package Practicum_8;

public abstract class Voertuig implements Goed {

    protected String type;
    protected double nieuwprijs;
    protected int bouwjaar;

    public Voertuig(String tp, double pr, int jr) {
        this.type = tp;
        this.nieuwprijs = pr;
        this.bouwjaar = jr;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Voertuig other = (Voertuig) obj;
        return bouwjaar == other.bouwjaar &&
                nieuwprijs == other.nieuwprijs &&
                type.equals(other.type);
    }

    @Override
    public String toString() {
        return "Voertuig: " + type +
                " met bouwjaar " + bouwjaar +
                " heeft een waarde van: €" +
                String.format("%.2f", huidigeWaarde());
    }
}

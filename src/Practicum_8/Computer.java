package Practicum_8;

public class Computer implements Goed {

    private String type;
    private String macAdres;
    private double aanschafPrijs;
    private int productieJaar;

    public Computer(String tp, String adr, double pr, int jr) {
        this.type = tp;
        this.macAdres = adr;
        this.aanschafPrijs = pr;
        this.productieJaar = jr;
    }

    @Override
    public double huidigeWaarde() {
        int huidigJaar = java.time.Year.now().getValue();
        int leeftijd = huidigJaar - productieJaar;
        return aanschafPrijs * Math.pow(0.6, leeftijd);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Computer other = (Computer) obj;
        return productieJaar == other.productieJaar &&
                aanschafPrijs == other.aanschafPrijs &&
                type.equals(other.type) &&
                macAdres.equals(other.macAdres);
    }

    @Override
    public String toString() {
        return "Computer: " + type +
                " (MAC: " + macAdres + ")" +
                " heeft een waarde van: €" +
                String.format("%.2f", huidigeWaarde());
    }
}

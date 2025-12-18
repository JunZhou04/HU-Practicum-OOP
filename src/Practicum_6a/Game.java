package Practicum_6a;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Objects;

public class Game {
    private String naam;
    private int releaseJaar;
    private double nieuwprijs;

    public Game(String nm, int rJ, double nwpr) {
        this.naam = nm;
        this.releaseJaar = rJ;
        this.nieuwprijs = nwpr;
    }

    public String getNaam() {
        return naam;
    }

    public double huidigeWaarde() {
        int ditJaar = LocalDate.now().getYear();
        int jarenOud = ditJaar - releaseJaar;
        if (jarenOud < 0) jarenOud = 0;

        return nieuwprijs * Math.pow(0.7, jarenOud);
    }

    @Override
    public boolean equals(Object andereObject) {
        if (this == andereObject) return true;
        if (!(andereObject instanceof Game)) return false;
        Game other = (Game) andereObject;
        return releaseJaar == other.releaseJaar && Objects.equals(naam, other.naam);
    }

    @Override
    public String toString() {
        return String.format(
                "%s, uitgegeven in %d; nieuwprijs: €%.2f nu voor: €%.2f",
                this.getNaam(),
                this.releaseJaar,
                this.nieuwprijs,
                huidigeWaarde()
        );
    }
}

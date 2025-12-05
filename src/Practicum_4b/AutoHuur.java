package Practicum_4b;

public class AutoHuur {
    private int aantalDagen;
    private Auto gehuurdeAuto;
    private Klant huurder;

    public AutoHuur() {
        this.aantalDagen = 0;
        this.gehuurdeAuto = null;
        this.huurder = null;
    }

    public void setAantalDagen(int aD) {
        this.aantalDagen = aD;
    }

    public int getAantalDagen() {
        return aantalDagen;
    }

    public void setGehuurdeAuto(Auto gA) {
        this.gehuurdeAuto = gA;
    }

    public Auto getGehuurdeAuto() {
        return gehuurdeAuto;
    }

    public void setHuurder(Klant k) {
        this.huurder = k;
    }

    public Klant getHuurder() {
        return huurder;
    }

    public double totaalPrijs() {

        if (gehuurdeAuto == null || huurder == null) {
            return 0.0;
        }

        double prijsZonderKorting = aantalDagen * gehuurdeAuto.getPrijsPerDag();
        double korting = prijsZonderKorting * (huurder.getKorting() / 100.0);
        return prijsZonderKorting - korting;
    }

    @Override
    public String toString() {
        String s = "";

        if (gehuurdeAuto == null) {
            s += "\ter is geen auto bekend\n";
        } else {
            s += "\tautotype: " + gehuurdeAuto.toString() + "\n";
        }

        if (huurder == null) {
            s += "\ter is geen huurder bekend\n";
        } else {
            s += "\top naam van: " + huurder.toString() + "\n";
        }

        s += "\taantal dagen: " + aantalDagen + " en dat kost " + totaalPrijs();
        return s;
    }
}
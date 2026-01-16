package Practicum_8;

import java.util.ArrayList;

public class BedrijfsInventaris {

    private ArrayList<Goed> alleGoederen;
    private String bedrijfsNaam;
    private double budget;

    public BedrijfsInventaris(String nm, double bud) {
        this.alleGoederen = new ArrayList<>();
        this.bedrijfsNaam = nm;
        this.budget = bud;
    }

    public void schafAan(Goed g) {
        if (g != null && !alleGoederen.contains(g) && budget >= g.huidigeWaarde()) {
            budget -= g.huidigeWaarde();
            alleGoederen.add(g);
        }
    }

    public ArrayList<Goed> getAlleGoederen() {
        return alleGoederen;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Goed g : alleGoederen) {
            sb.append("\n");
            sb.append(g);
        }

        return String.format(
                "%s, budget: \u20ac%.2f.\nMet het volgende in de inventaris:%s",
                bedrijfsNaam,
                budget,
                sb
        );
    }
}

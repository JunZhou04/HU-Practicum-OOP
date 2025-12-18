package Practicum_5;

import java.util.ArrayList;

public class Klas {
    private String klasCode;
    private ArrayList<Leerling> deLeerlingen;

    public Klas(String kC) {
        this.klasCode = kC;
        this.deLeerlingen = new ArrayList<>();
    }

    public void voegLeerlingToe(Leerling l) {
        deLeerlingen.add(l);
    }

    public void wijzigCijfer(String nm, double nweCijfer) {
        for (Leerling l : deLeerlingen) {
            if (l.getNaam().equals(nm)) {
                l.setCijfer(nweCijfer);
                return;
            }
        }
    }

    public ArrayList<Leerling> getLeerlingen() {
        return deLeerlingen;
    }

    public int aantalLeerlingen() {
        return deLeerlingen.size();
    }

    @Override
    public String toString() {
        String resultaat = "In klas " + klasCode + " zitten de volgende leerlingen:\n";

        for (Leerling l : deLeerlingen) {
            resultaat += l.toString() + "\n";
        }

        resultaat += "\n";
        return resultaat;
    }
}
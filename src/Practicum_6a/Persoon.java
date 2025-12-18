package Practicum_6a;

import java.util.ArrayList;

public class Persoon {
    private String naam;
    private double budget;
    private ArrayList<Game> mijnGames = new ArrayList<>();

    public Persoon(String nm, double bud) {
        this.naam = nm;
        this.budget = bud;
    }

    public double getBudget() {
        return this.budget;
    }

    public boolean koop(Game g) {
        if (g == null) return false;

        if (mijnGames.contains(g)) {
            return false;
        }

        double prijs = g.huidigeWaarde();
        if (this.budget < prijs) {
            return false;
        }

        this.budget -= prijs;
        this.mijnGames.add(g);
        return true;
    }

    public boolean verkoop(Game g, Persoon koper) {
        if (g == null || koper == null) return false;

        // verkoper moet game hebben
        if (!mijnGames.contains(g)) return false;

        // koper mag game nog niet hebben
        if (koper.mijnGames.contains(g)) return false;

        double prijs = g.huidigeWaarde();

        // koper moet voldoende budget hebben
        if (koper.budget < prijs) return false;

        // transactie uitvoeren
        koper.budget -= prijs;
        this.budget += prijs;

        this.mijnGames.remove(g);
        koper.mijnGames.add(g);

        return true;
    }

    // Practicum_6_B
    public Game zoekGameOpNaam(String gNm) {
        if (gNm == null) return null;

        for (Game g : mijnGames) {
            if (gNm.equals(g.getNaam())) {
                return g;
            }
        }
        return null;
    }

    // Practicum_6_B
    public ArrayList<Game> bepaalGamesNietInBezit(ArrayList<Game> gameList) {
        ArrayList<Game> gamesNietInBezit = new ArrayList<>();
        if (gameList == null) return gamesNietInBezit;

        for (Game gL : gameList) {
            if (gL != null && !mijnGames.contains(gL)) {
                gamesNietInBezit.add(gL);
            }
        }
        return gamesNietInBezit;
    }

    @Override
    public String toString() {
        StringBuilder mijnGamesList = new StringBuilder();

        for (Game g : mijnGames) {
            mijnGamesList.append('\n');
            mijnGamesList.append(g.toString());
        }

        // result
        return String.format(
                "%s heeft een budget van €%.2f en bezit de volgende games:%s",
                this.naam,
                getBudget(),
                mijnGamesList
        );
    }
}
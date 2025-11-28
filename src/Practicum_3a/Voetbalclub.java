package Practicum_3a;

public class Voetbalclub {

    private String naam;
    private int aantalGewonnen;
    private int aantalGelijk;
    private int aantalVerloren;

    public Voetbalclub(String naam) {
        if (naam == null || naam.isEmpty()) {
            this.naam = "FC";
        } else {
            this.naam = naam;
        }
    }

    public void verwerkResultaat(char ch) {
        switch (ch) {
            case 'w':
                aantalGewonnen++;
                break;
            case 'g':
                aantalGelijk++;
                break;
            case 'v':
                aantalVerloren++;
                break;
            default:
        }
    }

    public int aantalGespeeld() {
        return aantalGewonnen + aantalGelijk + aantalVerloren;
    }

    public int aantalPunten() {
        return aantalGewonnen * 3 + aantalGelijk;
    }

    @Override
    public String toString() {
        return naam + "      " +
                aantalGespeeld() + " " +
                aantalGewonnen + " " +
                aantalGelijk + " " +
                aantalVerloren + " " +
                aantalPunten();
    }
}

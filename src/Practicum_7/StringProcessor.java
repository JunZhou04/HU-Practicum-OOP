package Practicum_7;

import java.util.ArrayList;
import java.util.List;

public class StringProcessor {

    private List<OpmaakProces> processen;

    public StringProcessor() {
        this.processen = new ArrayList<>();
    }

    public String verwerk(String input) {
        String resultaat = input;

        for (OpmaakProces proces : processen) {
            resultaat = proces.maakOp(resultaat);
        }

        return resultaat;
    }

    public void voegProcesToe(OpmaakProces proces) {
        processen.add(proces);
    }
}

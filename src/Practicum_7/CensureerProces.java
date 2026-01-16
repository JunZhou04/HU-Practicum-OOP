package Practicum_7;

public class CensureerProces implements OpmaakProces {

    private String woord;

    public CensureerProces(String woord) {
        this.woord = woord;
    }

    @Override
    public String maakOp(String input) {
        return input.replaceAll(woord, "****");
    }
}

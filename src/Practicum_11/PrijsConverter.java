package Practicum_11;

import java.io.*;
import java.util.Scanner;

public class PrijsConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Geef de naam van het bronbestand: ");
        String bronBestand = scanner.nextLine();

        System.out.print("Geef de naam van het bestemmingsbestand: ");
        String doelBestand = scanner.nextLine();

        System.out.print("Geef de waarde van 1 USD in eurocenten: ");
        double koers;

        try {
            koers = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Ongeldige koers. Gebruik een getal.");
            return;
        }

        try (
                BufferedReader reader = new BufferedReader(new FileReader(bronBestand));
                PrintWriter writer = new PrintWriter(new FileWriter(doelBestand))
        ) {
            String regel;

            while ((regel = reader.readLine()) != null) {

                int scheiding = regel.lastIndexOf(" : ");

                if (scheiding == -1) {
                    System.out.println("Ongeldig formaat, regel overgeslagen: " + regel);
                    continue;
                }

                String artikel = regel.substring(0, scheiding);
                String prijsString = regel.substring(scheiding + 3);

                try {
                    double prijsUSD = Double.parseDouble(prijsString);
                    double prijsEUR = (prijsUSD * koers) / 100.0;

                    writer.printf("%s : %.2f%n", artikel, prijsEUR);

                } catch (NumberFormatException e) {
                    System.out.println("Ongeldige prijs, regel overgeslagen: " + regel);
                }
            }

            System.out.println("Conversie voltooid. Bestand aangemaakt: " + doelBestand);

        } catch (FileNotFoundException e) {
            System.out.println("Bronbestand niet gevonden.");

        } catch (IOException e) {
            System.out.println("Fout bij lezen of schrijven van bestanden.");
        }
    }
}

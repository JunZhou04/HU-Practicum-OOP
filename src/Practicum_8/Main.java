package Practicum_8;

public class Main {

    public static void main(String[] args) {

        BedrijfsInventaris inventaris =
                new BedrijfsInventaris("HU", 100000);

        Computer c1 = new Computer("Laptop", "AA:BB:CC", 2000, 2022);
        Computer c2 = new Computer("Laptop", "AA:BB:CC", 2000, 2022);
        Computer c3 = new Computer("Desktop", "DD:EE:FF", 3000, 2021);

        Auto a1 = new Auto("Mercedes-Benz A-klasse A 180", 29995, 2019, "4-ZTV-94");
        Auto a2 = new Auto("Mercedes-Benz A-klasse A 180", 29995, 2019, "4-ZTV-94");
        Auto a3 = new Auto("Tesla Model 3", 45000, 2022, "9-XYZ-88");

        Fiets f1 = new Fiets("Gazelle", 1200, 2020, 123);
        Fiets f2 = new Fiets("Gazelle", 1200, 2020, 123);
        Fiets f3 = new Fiets("Batavus", 900, 2023, 456);

        inventaris.schafAan(c1);
        inventaris.schafAan(c2);
        inventaris.schafAan(c3);

        inventaris.schafAan(a1);
        inventaris.schafAan(a2);
        inventaris.schafAan(a3);

        inventaris.schafAan(f1);
        inventaris.schafAan(f2);
        inventaris.schafAan(f3);

        System.out.println();
        System.out.println(inventaris);
    }
}

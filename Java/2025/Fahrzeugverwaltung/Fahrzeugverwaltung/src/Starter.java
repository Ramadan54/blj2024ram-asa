import java.time.LocalDate;

public class Starter {
    public static void main(String[] args) {
        VehicleRentalManager manager = new VehicleRentalManager();

        Person tom = new Person("Tom", LocalDate.of(2009, 5, 12));
        Person anna = new Person("Anna", LocalDate.of(1990, 3, 15));

        Vehicle z4 = new Luxuswagen("BMW Z4", "ZH 123");
        Vehicle fiat = new Kleinwagen("Fiat 500", "ZH 456");

        manager.addPerson(tom);
        manager.addPerson(anna);
        manager.addVehicle(z4);
        manager.addVehicle(fiat);

        try {
            manager.createContract(anna, z4, LocalDate.of(2025, 4, 15), LocalDate.of(2025, 4, 20), "Privatfahrt");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            manager.createContract(tom, z4, LocalDate.of(2025, 4, 18), LocalDate.of(2025, 4, 22), "Ferien");
        } catch (Exception e) {
            System.out.println("Fehler: " + e.getMessage());
        }

        manager.addPersonToDenylist(tom);
        try {
            manager.createContract(tom, fiat, LocalDate.of(2025, 4, 25), LocalDate.of(2025, 4, 28), "Kurzstrecke");
        } catch (Exception e) {
            System.out.println("Fehler: " + e.getMessage());
        }
    }
}

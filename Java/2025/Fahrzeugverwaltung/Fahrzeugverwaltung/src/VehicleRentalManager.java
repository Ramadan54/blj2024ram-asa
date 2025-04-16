import java.util.*;
import java.time.LocalDate;

public class VehicleRentalManager {
    private final List<Person> customers = new ArrayList<>();
    private final List<Person> denylist = new ArrayList<>();
    private final List<Vehicle> vehicles = new ArrayList<>();
    private final List<Contract> contracts = new ArrayList<>();

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }
    public void addPerson(Person person) {
        customers.add(person);
    }
    public void addPersonToDenylist(Person denyPerson) {
        denylist.add(denyPerson);
    }
    public void createContract(Person person, Vehicle vehicle, LocalDate start, LocalDate end, String terms)
            throws MinorAgeException, DenylistedPersonException, LeaseLengthCollisionException {

        if (denylist.contains(person)) {
            throw new DenylistedPersonException("Diese Person ist auf der Deny-Liste.");
        }
        if (person.getAge() < vehicle.getMinDriverAge()) {
            throw new MinorAgeException("Person ist zu jung für dieses Fahrzeug.");
        }
        Contract newContract = new Contract(person, vehicle, start, end, terms);
        for (Contract c : contracts) {
            if (newContract.overlaps(c)) {
                throw new LeaseLengthCollisionException("Das Fahrzeug ist in diesem Zeitraum bereits vermietet.");
            }
        }
        contracts.add(newContract);
        System.out.println("Vertrag erfolgreich erstellt: " + newContract);
    }
    public List<Contract> getContracts() {
        return contracts;
    }
}

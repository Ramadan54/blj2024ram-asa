import java.util.*;

public class VehicleRentalManager {
    private List<Person> customers = new ArrayList<>();
    private List<Person> denylist = new ArrayList<>();
    private List<Vehicle> vehicles = new ArrayList<>();
    private List<Object> contracts = new ArrayList<>();

    public void addVehicle(Vehicle v) {
        vehicles.add(v);
    }
    public void addPerson(Person p) {
        customers.add(p);
    }
}

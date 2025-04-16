import java.time.LocalDate;

public class Contract {
    private final Person person;
    private final Vehicle vehicle;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final String terms;

    public Contract(Person person, Vehicle vehicle, LocalDate startDate, LocalDate endDate, String terms) {
        this.person = person;
        this.vehicle = vehicle;
        this.startDate = startDate;
        this.endDate = endDate;
        this.terms = terms;
    }
    public Person getPerson() {
        return person;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
    public LocalDate getStartDate() {
        return startDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    public String getTerms() {
        return terms;
    }
    public boolean overlaps(Contract other) {
        return this.vehicle.getPlateNumber().equals(other.vehicle.getPlateNumber()) &&
                !(this.endDate.isBefore(other.startDate) || this.startDate.isAfter(other.endDate));
    }
    @Override
    public String toString() {
        return "Vertrag: " + person.getName() + " mietet " + vehicle.getModelName() +
                " (" + vehicle.getPlateNumber() + ") vom " + startDate + " bis " + endDate;
    }
}

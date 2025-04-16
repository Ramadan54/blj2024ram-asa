public class Motorcycle extends Vehicle {

    public Motorcycle(String modelName, String plateNumber, int minDriverAge) {
        super(modelName, plateNumber, minDriverAge);
    }
    @Override
    public String getVehicleType() {
        return "Motorrad";
    }
}

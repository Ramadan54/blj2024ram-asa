public class Anhaenger extends Vehicle {
    public Anhaenger(String modelName, String plateNumber) {
        super(modelName, plateNumber, 18);
    }
    @Override
    public String getVehicleType() {
        return "Anhänger";
    }
}

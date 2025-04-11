public class Lastwagen extends Vehicle {
    public Lastwagen(String modelName, String plateNumber) {
        super(modelName, plateNumber, 23);
    }
    @Override
    public String getVehicleType() {
        return "Lastwagen";
    }
}

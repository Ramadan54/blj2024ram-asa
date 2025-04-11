public class Kleinwagen extends Vehicle {
    public Kleinwagen(String modelName, String plateNumber) {
        super(modelName, plateNumber, 18);
    }
    @Override
    public String getVehicleType() {
        return "Kleinwagen";
    }
}

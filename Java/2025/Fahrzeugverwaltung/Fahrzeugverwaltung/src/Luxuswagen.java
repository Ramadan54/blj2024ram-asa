public class Luxuswagen extends Vehicle {
    public Luxuswagen(String modelName, String plateNumber) {
        super(modelName, plateNumber, 18);
    }
    @Override
    public String getVehicleType() {
        return "Luxuswagen";
    }

}

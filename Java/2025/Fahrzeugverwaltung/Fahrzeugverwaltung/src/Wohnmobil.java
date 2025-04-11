public class Wohnmobil extends Vehicle {
    public Wohnmobil(String modelName, String plateNumber) {
        super(modelName, plateNumber, 21);
    }
    @Override
    public String getVehicleType() {
        return "Wohnmobil";
    }

}

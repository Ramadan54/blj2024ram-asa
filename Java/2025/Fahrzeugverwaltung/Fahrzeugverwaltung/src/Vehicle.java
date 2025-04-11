public abstract class Vehicle {
    private String modelName;
    private String plateNumber;
    private int minDriverAge;

    public Vehicle(String modelName, String plateNumber, int minDriverAge) {
        this.modelName = modelName;
        this.plateNumber = plateNumber;
        this.minDriverAge = minDriverAge;
    }
    public String getModelName() {
        return modelName;
    }
    public String getPlateNumber() {
        return plateNumber;
    }
    public int getMinDriverAge() {
        return minDriverAge;
    }

    public abstract String getVehicleType();
}

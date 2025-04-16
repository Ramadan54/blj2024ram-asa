public abstract class Vehicle {
    private final String modelName;
    private final String plateNumber;
    private final int minDriverAge;

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

    @Override
    public String toString() {
        return getVehicleType() + ": " + modelName + " (Plate: " + plateNumber + ")";
    }
}

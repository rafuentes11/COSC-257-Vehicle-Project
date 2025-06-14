public class RentalDetails {
    private int vehicleType, estimatedNumberMiles;
    private TimeSpan estimatedRentalPeriod;
    private boolean insurSelected, primeCustomer;

    public RentalDetails(int vehicleType, int estimatedNumberMiles, TimeSpan estimatedRentalPeriod,
            boolean insurSelected, boolean primeCustomer) {

        this.vehicleType = vehicleType;
        this.estimatedNumberMiles = estimatedNumberMiles;
        this.estimatedRentalPeriod = estimatedRentalPeriod;
        this.insurSelected = insurSelected;
        this.primeCustomer = primeCustomer;
    }

    public int getVehicleType() {
        return vehicleType;
    }

    public int GetEstimatedNumMiles() {
        return estimatedNumberMiles;
    }

    public TimeSpan getRentalPeriod() {
        return estimatedRentalPeriod;
    }

    public boolean getInsuranceSelected() {
        return insurSelected;
    }

    public boolean getPrimeCustomer() {
        return primeCustomer;
    }

}

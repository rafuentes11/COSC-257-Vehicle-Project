public class ReservationDetails {
    private String name, creditCard, VIN;
    private TimeSpan rentalPeriod;
    private boolean insuranceSelected;

    public ReservationDetails(String name, String creditCard, String VIN, TimeSpan rentalPeriod,
            boolean insuranceSelected) {
        this.name = name;
        this.creditCard = creditCard;
        this.VIN = VIN;
        this.rentalPeriod = rentalPeriod;
        this.insuranceSelected = insuranceSelected;
    }

    public String getName() {
        return name;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public String getVIN() {
        return VIN;
    }

    public TimeSpan getRentalPeriod() {
        return rentalPeriod;
    }

    public boolean getInsurance() {
        return insuranceSelected;
    }

}

public class Transaction {
    private String creditCardNum;
    private String companyName;
    private String vehicleType; // Car, Suv, Truck
    private String rentalPeriod; // Day, Week, Month
    private String milesDriven;
    private String rentalCost;

    public Transaction(String creditCardNum, String companyName, String vehicleType,
            String rentalPeriod, String milesDriven, String rentalCost) {
        this.creditCardNum = creditCardNum;
        this.companyName = companyName;
        this.vehicleType = vehicleType;
        this.rentalPeriod = rentalPeriod;
        this.milesDriven = milesDriven;
        this.rentalCost = rentalCost;
    }

    public String toString() {
        return "Credit Card: " + creditCardNum + "Company Name: " + companyName + "Vehicle Type: " + vehicleType +
                "Rental Period: " + rentalPeriod + "Miles Driven: " + milesDriven + "Rental Cost: " + rentalCost;
    }
}
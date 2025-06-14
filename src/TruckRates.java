public class TruckRates extends VehicleRates {

    public TruckRates(double dailyRate, double weeklyRate, double monthlyRate, double mileageCharge,
            double insuranceRate) {
        super(dailyRate, weeklyRate, monthlyRate, mileageCharge, insuranceRate);

    }

    public String toString() {
        return "Daily Rate: " + super.getDailyRate() + " Weekly Rate: " + super.getWeeklyRate() + " Monthly Rate: " +
                super.getMonthlyRate() + " Mileage Charge: " + super.getMileageCharge() + " Insurance Rate: "
                + super.getInsuranceRate();
    }
}
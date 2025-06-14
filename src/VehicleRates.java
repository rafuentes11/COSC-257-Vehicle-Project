public abstract class VehicleRates {
    private double dailyRate;
    private double weeklyRate;
    private double monthlyRate;
    private double mileageCharge;
    private double insuranceRate;

    public VehicleRates(double dailyRate, double weeklyRate, double monthlyRate, double mileageCharge,
            double insuranceRate) {
        this.dailyRate = dailyRate;
        this.weeklyRate = weeklyRate;
        this.monthlyRate = monthlyRate;
        this.mileageCharge = mileageCharge;
        this.insuranceRate = insuranceRate;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public double getWeeklyRate() {
        return weeklyRate;
    }

    public double getMonthlyRate() {
        return monthlyRate;
    }

    public double getMileageCharge() {
        return mileageCharge;
    }

    public double getInsuranceRate() {
        return insuranceRate;
    }

    public abstract String toString();

}

/*
 * 0 = car rate
 * 1 = SUV rate
 * 2 = truck rate
 */
public class CurrentRates {
    private VehicleRates[] rates = new VehicleRates[3];

    public CurrentRates(CarRates c, SUVRates s, TruckRates t) {
        rates[0] = c;
        rates[1] = s;
        rates[2] = t;
    }

    public VehicleRates getCarRates() {
        return rates[0];
    }

    public VehicleRates getSUVRates() {
        return rates[1];
    }

    public VehicleRates getTruckRates() {
        return rates[2];
    }

    public void setCarRates(VehicleRates car) {
        rates[0] = car;
    }

    public void setSUVRates(VehicleRates SUV) {
        rates[1] = SUV;
    }

    public void setTruckRates(VehicleRates Truck) {
        rates[2] = Truck;
    }

    public double calcEstimatedCost(int vehicleType, TimeSpan estimatedRentalPeriod, int estimatedNumMiles,
            boolean dailyInsur, boolean primeCustomer) {

        double totalCost = 0.0;
        int tempMiles = estimatedNumMiles;
        switch (vehicleType) {
            // Car
            case 1:
                if (estimatedRentalPeriod.getNumUnits() > 30)
                    totalCost = estimatedRentalPeriod.getNumUnits() * (1 / 30) * 514.95;
                else if (estimatedRentalPeriod.getNumUnits() > 7)
                    totalCost = estimatedRentalPeriod.getNumUnits() * (1 / 7) * 169.95;
                else
                    totalCost = estimatedRentalPeriod.getNumUnits() * 24.95;

                if (dailyInsur == true)
                    totalCost = (14.95 * estimatedRentalPeriod.getNumUnits()) + totalCost;
                if (primeCustomer == true) {
                    tempMiles = tempMiles - 100;
                    if (tempMiles < 0)
                        tempMiles = 0;
                    totalCost = (tempMiles * .16) + totalCost;
                }
                break;
            // SUV
            case 2:
                if (estimatedRentalPeriod.getNumUnits() > 30)
                    totalCost = estimatedRentalPeriod.getNumUnits() * (1 / 30) * 679.95;
                else if (estimatedRentalPeriod.getNumUnits() > 7)
                    totalCost = estimatedRentalPeriod.getNumUnits() * (1 / 7) * 189.95;
                else
                    totalCost = estimatedRentalPeriod.getNumUnits() * 29.95;

                if (dailyInsur == true)
                    totalCost = (14.95 * estimatedRentalPeriod.getNumUnits()) + totalCost;
                if (primeCustomer == true) {
                    tempMiles = tempMiles - 100;
                    if (tempMiles < 0)
                        tempMiles = 0;
                    totalCost = (tempMiles * .16) + totalCost;
                }
                break;
            // Truck
            case 3:
                if (estimatedRentalPeriod.getNumUnits() > 30)
                    totalCost = estimatedRentalPeriod.getNumUnits() * (1 / 30) * 687.95;
                else if (estimatedRentalPeriod.getNumUnits() > 7)
                    totalCost = estimatedRentalPeriod.getNumUnits() * (1 / 7) * 224.95;
                else
                    totalCost = estimatedRentalPeriod.getNumUnits() * 36.95;

                if (dailyInsur == true)
                    totalCost = (21.95 * estimatedRentalPeriod.getNumUnits()) + totalCost;
                if (primeCustomer == true) {
                    tempMiles = tempMiles - 100;
                    if (tempMiles < 0)
                        tempMiles = 0;
                    totalCost = (tempMiles * .26) + totalCost;
                }
                break;
        }
        return totalCost;
    }

    public double calcActualCost(VehicleRates rates, int numDaysUsed, int NumMilesDriven,
            boolean dailyInsur, boolean primeCustomer) {
        double temp = calcEstimatedCost(numDaysUsed, null, NumMilesDriven, dailyInsur, primeCustomer);
        return temp;
    }
}

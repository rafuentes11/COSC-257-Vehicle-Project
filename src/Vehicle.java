/*
Rodrigo Fuentes
COSC 237 004
Fall 2022
*/
public abstract class Vehicle {
    /*
     * description - make/model and length
     * mpg - miles per gallon
     * vin - vechicle identification number
     * reserve - reservation number
     */
    private String description;
    private int mpg;
    private String vin;
    private Reservation reserve;
    private VehicleRates rates;

    public Vehicle(String d, int m, String v) {
        description = d;
        mpg = m;
        vin = v;
        reserve = null;
        rates = null;
    }

    public String getDescription() {
        return description;
    }

    public int getMPG() {
        return mpg;
    }

    public String getVIN() {
        return vin;
    }

    public abstract String toString();

    public Reservation getReservation() {
        return reserve;
    }

    public boolean isReserved() {
        if (reserve == null)
            return false;
        return true;
    }

    public void reserve(Reservation r) throws ReservedVehicleException {
        if (reserve == r)
            throw new ReservedVehicleException();
        reserve = r;
    }

    public void cancelReservation() throws UnreservedVehicleException {
        if (reserve == null)
            throw new UnreservedVehicleException();
        reserve = null;
    }

    public VehicleRates getQuotedRates() {
        return rates;
    }

    public void setQuotedRates(VehicleRates cost) {
        rates = cost;
    }
}

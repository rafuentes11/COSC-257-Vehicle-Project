/*
Rodrigo Fuentes
Brandon Dubbs
COSC 237 004
Fall 2022
*/
public class SUV extends Vehicle {
    private int year;
    private int seats;
    private double storageFT;

    public SUV(int year, int seats, int storageFT, String description, int mpg, String vin) {
        super(description, mpg, vin);
        this.year = year;
        this.seats = seats;
        this.storageFT = storageFT;
    }

    public int getYear() {
        return year;
    }

    public int getSeats() {
        return seats;
    }

    public double getStorageFT() {
        return storageFT;
    }

    public String toString() {
        return getDescription() + " - " + getYear() + "(SUV) MPG: " + getMPG() + " Seating:" + getSeats() +
                " Storage: " + getStorageFT() + "cu. ft VIN: " + getVIN();
    }
}

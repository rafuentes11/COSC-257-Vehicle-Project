/*
Rodrigo Fuentes
Brandon Dubbs
COSC 237 004
Fall 2022
*/
public class Car extends Vehicle {
    private int year;
    private int seats;

    public Car(int year, int seats, String description, int mpg, String vin) {
        super(description, mpg, vin);
        this.year = year;
        this.seats = seats;
    }

    public int getSeats() {
        return seats;
    }

    public int getYear() {
        return year;
    }

    public String toString() {
        return getDescription() + " - " + getYear() + "(Car) MPG: " + getMPG() + " Seating:" + getSeats() + " VIN: "
                + getVIN();
    }
}

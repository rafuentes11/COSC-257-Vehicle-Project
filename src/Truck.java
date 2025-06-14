/*
Rodrigo Fuentes
Brandon Dubbs
COSC 237 004
Fall 2022
*/
public class Truck extends Vehicle {
    private int capacity;

    public Truck(int capacity, String description, int mpg, String vin) {
        super(description, mpg, vin);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public String toString() {
        return getDescription() + " - " + "(Truck) MPG: " + getMPG() + " Load Capacity:" + getCapacity() + " lbs. VIN: "
                + getVIN();
    }

}

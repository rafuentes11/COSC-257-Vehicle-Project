/*
Rodrigo Fuentes
Brandon Dubbs
COSC 237 004
Fall 2022
*/
public class Vehicles {
    /*
     * agency_vehicles - array of vehicle objects
     * current - iterator
     */
    private Vehicle[] agency_vehicles;
    private int current;

    // make random size
    public Vehicles() {
        agency_vehicles = new Vehicle[25];
        current = 0;
    }

    public void add(Vehicle v) {
        agency_vehicles[current] = v;
        current++;
    }

    public Vehicle getVehicle(String vin) throws VINNotFoundException {
        int length = agency_vehicles.length;
        for (int i = 0; i < length; i++) {
            if (agency_vehicles[i].getVIN().equals(vin))
                return agency_vehicles[i];
        }
        throw new VINNotFoundException();
    }

    public void reset() {
        current = 0;
    }

    public boolean hasNext() {
        if (agency_vehicles.length - (current + 1) != 0 && agency_vehicles[current] != null)
            return true;
        return false;
    }

    public Vehicle getNext() {
        Vehicle v = agency_vehicles[current];
        current++;
        return v;
    }

}

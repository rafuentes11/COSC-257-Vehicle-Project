import java.util.Scanner;

public class SystemInterface {
    private static CurrentRates agencyRates;
    private static Vehicles agencyVehicles;
    private static Accounts accounts;
    private static Transactions transactionsHistory;

    // used to init static variables (in place of a constructor)
    public static void initSystem(CurrentRates r, Vehicles v, Accounts a, Transactions t) {
        agencyRates = r;
        agencyVehicles = v;
        accounts = a;
        transactionsHistory = t;
    }

    // Note that all methods returns some result, either requested information
    // (e.g., getAvailCars) or an
    // acknowledgement of the success of a requested action (e.g., makeReservation
    // returning “Vehicle
    // QK3FL4273ME successfully reserved”, and method processReturnedVehicle returns
    // the final cost
    // for the returned vehicle (e.g., “Total charge for VIN QK3FL4273ME for 3 days,
    // 233 miles @ 0.15/mile
    // and daily insurance @ 14.95/day (with 100 miles credit as Prime customer) =
    // $xxx.xx.”)

    // Current Rates Related Methods
    public static String[] getCarRates() {
        String[] str = new String[1];
        str[0] = agencyRates.getCarRates().toString();
        return str;
    }

    public static String[] getSUVRates() {
        String[] str = new String[1];
        str[0] = agencyRates.getSUVRates().toString();
        return str;
    }

    public static String[] getTruckRates() {
        String[] str = new String[1];
        str[0] = agencyRates.getTruckRates().toString();
        return str;
    }

    public static String[] updateCarRates(VehicleRates r) {
        agencyRates.setCarRates(r);
        String[] str = new String[1];
        str[0] = agencyRates.getCarRates().toString();
        return str;
    }

    public static String[] updateSUVRates(VehicleRates r) {
        agencyRates.setSUVRates(r);
        String[] str = new String[1];
        str[0] = agencyRates.getSUVRates().toString();
        return str;
    }

    public static String[] updateTruckRates(VehicleRates r) {
        agencyRates.setTruckRates(r);
        String[] str = new String[1];
        str[0] = agencyRates.getTruckRates().toString();
        return str;
    }

    public static String[] estimatedRentalCost(RentalDetails details) {
        // transactionsHistory.
        String[] str = new String[1];
        String temp = String.valueOf(agencyRates.calcEstimatedCost(details.getVehicleType(), details.getRentalPeriod(),
                details.GetEstimatedNumMiles(),
                details.getInsuranceSelected(), details.getPrimeCustomer()));
        str[0] = temp;
        return str;
    }

    public static String[] processReturnedVehicle(String vin, int num_days_used, int num_miles_driven) {
        Account obj = accounts.getAccount(vin);
        String[] str = new String[1];
        str[0] = obj.toString();
        return str;

    }
    // Note that the rates to be used are retrieved from the VehicleRates object
    // stored in the specific rented
    // vehicle object, the daily insurance option is retrieved from the Reservation
    // object of the rented
    // vehicle, and whether they are a Prime customer is retrived from the Customer
    // Account object vehicle
    // associated with the Reservation object associated with the specific rented
    // vehicle.

    // Vehicle Related Methods
    public static String[] getAvailCars() {
        Vehicle v;
        int numberOfVehicles = 0;

        agencyVehicles.reset();
        while (agencyVehicles.hasNext()) {
            v = agencyVehicles.getNext();
            if (v instanceof Car && !v.isReserved())
                numberOfVehicles++;
        }
        String[] str = new String[numberOfVehicles];
        int i = 0;
        agencyVehicles.reset();
        while (agencyVehicles.hasNext()) {
            v = agencyVehicles.getNext();
            if (v instanceof Car && !v.isReserved()) {
                str[i] = v.toString();
                i++;
            }
        }
        return str;
    }

    public static String[] getAvailSUVs() {
        Vehicle v;
        int numberOfVehicles = 0;

        agencyVehicles.reset();
        while (agencyVehicles.hasNext()) {
            v = agencyVehicles.getNext();
            if (v instanceof SUV && !v.isReserved())
                numberOfVehicles++;
        }
        String[] str = new String[numberOfVehicles];
        int i = 0;
        agencyVehicles.reset();
        while (agencyVehicles.hasNext()) {
            v = agencyVehicles.getNext();
            if (v instanceof SUV && !v.isReserved()) {
                str[i] = v.toString();
                i++;
            }
        }
        return str;
    }

    public static String[] getAvailTrucks() {
        Vehicle v;
        int numberOfVehicles = 0;

        agencyVehicles.reset();
        while (agencyVehicles.hasNext()) {
            v = agencyVehicles.getNext();
            if (v instanceof Truck && !v.isReserved())
                numberOfVehicles++;
        }
        String[] str = new String[numberOfVehicles];
        int i = 0;
        agencyVehicles.reset();
        while (agencyVehicles.hasNext()) {
            v = agencyVehicles.getNext();
            if (v instanceof Truck && !v.isReserved()) {
                str[i] = v.toString();
                i++;
            }
        }
        return str;
    }

    public static String[] getAllVehicles() {
        Vehicle v;
        int numberOfVehicles = 0;

        agencyVehicles.reset();
        while (agencyVehicles.hasNext()) {
            v = agencyVehicles.getNext();
            if (!v.isReserved())
                numberOfVehicles++;
        }
        String[] str = new String[numberOfVehicles];
        int i = 0;
        agencyVehicles.reset();
        while (agencyVehicles.hasNext()) {
            v = agencyVehicles.getNext();
            if (!v.isReserved()) {
                str[i] = v.toString();
                i++;
            }
        }
        return str;
    }

    public static String[] makeReservation(ReservationDetails details) throws VehicleNotFoundException,
            ReservedVehicleException {
        String[] str = new String[1];
        String vin = details.getVIN(), result = "Reservation successfully made";
        Vehicle veh = agencyVehicles.getVehicle(vin);

        if (veh.isReserved()) {
            throw new ReservedVehicleException();
        }

        Reservation reser = new Reservation(details.getVIN(), details.getCreditCard(), details.getRentalPeriod(),
                details.getInsurance());

        veh.reserve(reser);

        str[0] = result;
        return str;
    }

    public static String[] cancelReservation(String vin) {
        Scanner input = new Scanner(System.in);

        String[] str = new String[1];
        String VIN, result = "Reservation successfully deleted";
        System.out.println("VIN:");
        VIN = input.nextLine();
        input.close();
        agencyVehicles.getVehicle(VIN).cancelReservation();
        str[0] = result;
        return str;
    }

    public static String[] getReservation(String vin) throws VehicleNotFoundException {
        Scanner input = new Scanner(System.in);

        String[] str = new String[1];
        String VIN;
        System.out.println("VIN:");
        VIN = input.nextLine();
        input.close();
        str[0] = agencyVehicles.getVehicle(VIN).getReservation().toString();
        return str;
    }

    public static String[] getAllReservations() throws UnreservedVehicleException {
        Vehicle v;
        int numberOfVehicles = 0;

        agencyVehicles.reset();
        while (agencyVehicles.hasNext()) {
            v = agencyVehicles.getNext();
            if (v.isReserved())
                numberOfVehicles++;
        }
        String[] str = new String[numberOfVehicles];
        int i = 0;
        agencyVehicles.reset();
        while (agencyVehicles.hasNext()) {
            v = agencyVehicles.getNext();
            if (v.isReserved()) {
                str[i] = v.toString();
                i++;
            }
        }
        return str;

    }

    // Customer Accounts Related Methods
    public static String[] addAccount(String creditcard, String company_name, boolean prime_cust) {
        Account obj = new Account(creditcard, company_name, prime_cust);
        String[] str = new String[1];
        accounts.add(obj);
        str[0] = obj.toString();
        return str;
    }

    public static String[] getAccount(String creditCardNum) throws AccountNotFoundException {
        String[] str = new String[1];
        str[0] = accounts.getAccount(creditCardNum).getCreditCardNum();
        return str;

    }

    public static String[] getAllAccounts() throws NoAccountException {
        Account a;
        int numberOfAccounts = 0;

        accounts.reset();
        while (accounts.hasNext()) {
            a = accounts.getNext();
            numberOfAccounts++;
        }
        String[] str = new String[numberOfAccounts];
        int i = 0;
        accounts.reset();
        while (accounts.hasNext()) {
            a = accounts.getNext();
            str[i] = a.toString();
            i++;
        }
        return str;

    }

    // transactions-related methods
    public static String[] getAllTransactions() throws NoTransactionsException {
        Transaction t;
        int numberOfTransaction = 0;

        transactionsHistory.reset();
        while (transactionsHistory.hasNext()) {
            t = transactionsHistory.getNext();
            numberOfTransaction++;
        }
        String[] str = new String[numberOfTransaction];
        int i = 0;
        accounts.reset();
        while (transactionsHistory.hasNext()) {
            t = transactionsHistory.getNext();
            str[i] = t.toString();
            i++;
        }
        return str;
    }
}

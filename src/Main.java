
/*
Rodrigo Fuentes
COSC 237 004
Fall 2022
*/
import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// Declare and populate vehicles collection
		Vehicles vehs = new Vehicles();
		Accounts acct = new Accounts();
		Transactions tran = new Transactions();
		CarRates cRate = new CarRates(24.95, 169.95, 514.95, .16, 14.95);
		SUVRates sRate = new SUVRates(29.95, 189.95, 679.95, .16, 14.95);
		TruckRates tRates = new TruckRates(36.95, 224.95, 687 / 95, 14.95, 21.95);
		CurrentRates curr = new CurrentRates(cRate, sRate, tRates);

		SystemInterface.initSystem(curr, vehs, acct, tran);

		populateVehicle(vehs);
		populateAccount(acct);

		// Init
		boolean quit = false;
		int option;

		// Command loop
		while (!quit) {

			displayMenu();
			option = input.nextInt();
			if (option == 20)
				quit = true;
			else
				execute(option, input);
		}
		System.out.println("Exiting system ...");

	}

	public static void execute(int option, Scanner input) {
		String[] results;
		try {
			switch (option) {
				case 1:
					results = SystemInterface.getCarRates();
					displayResult(results);
					break;
				case 2:
					results = SystemInterface.getTruckRates();
					break;
				case 3:
					results = SystemInterface.getTruckRates();
					break;
				case 4:
					double dr, wr, mr, mc, ir;
					System.out.println("Enter daily rate: ");
					dr = input.nextDouble();
					System.out.println("Enter weekly rate: ");
					wr = input.nextDouble();
					System.out.println("Enter monthly rate: ");
					mr = input.nextDouble();
					System.out.println("Enter mileage charge: ");
					mc = input.nextDouble();
					System.out.println("Enter insurane rate: ");
					ir = input.nextDouble();

					CarRates tempCar = new CarRates(dr, wr, mr, mc, ir);
					results = SystemInterface.updateCarRates(tempCar);
					break;
				case 5:
					// dr, wr, mr, mc, ir;
					System.out.println("Enter daily rate: ");
					dr = input.nextDouble();
					System.out.println("Enter weekly rate: ");
					wr = input.nextDouble();
					System.out.println("Enter monthly rate: ");
					mr = input.nextDouble();
					System.out.println("Enter mileage charge: ");
					mc = input.nextDouble();
					System.out.println("Enter insurane rate: ");
					ir = input.nextDouble();

					TruckRates tempTruck = new TruckRates(dr, wr, mr, mc, ir);
					results = SystemInterface.updateTruckRates(tempTruck);
					break;
				case 6:
					System.out.println("Enter daily rate: ");
					dr = input.nextDouble();
					System.out.println("Enter weekly rate: ");
					wr = input.nextDouble();
					System.out.println("Enter monthly rate: ");
					mr = input.nextDouble();
					System.out.println("Enter mileage charge: ");
					mc = input.nextDouble();
					System.out.println("Enter insurane rate: ");
					ir = input.nextDouble();

					SUVRates tempSUV = new SUVRates(dr, wr, mr, mc, ir);
					results = SystemInterface.updateTruckRates(tempSUV);
					break;
				case 7:
					int vt, nm, nd;
					String pick;
					TimeSpan rp;
					boolean is = false, pc = false;
					System.out.println("Enter Vehicle Type: ");
					vt = input.nextInt();
					System.out.println("Enter Estimated Number of Miles: ");
					nm = input.nextInt();
					System.out.println("Enter number of days");
					nd = input.nextInt();
					System.out.println("Enter monthly rate: ");
					mr = input.nextDouble();
					System.out.println("Enter y if you have insursance: ");
					pick = input.nextLine();
					if (pick.equals("y"))
						is = true;
					System.out.println("Enter y if you are a prime mamber: ");
					pick = input.nextLine();
					if (pick.equals("y"))
						pc = true;

					rp = new TimeSpan('d', nd);
					RentalDetails temp = new RentalDetails(vt, nm, rp, is, pc);
					SystemInterface.estimatedRentalCost(temp);

					break;
				case 8:

					break;
				case 9:

					break;
				case 10:

					break;
				case 11:

					break;
				case 20:

			}
		} catch (ReservedVehicleException e) {
			System.out.println("* Vehicle Already Reserved *");
		} catch (UnreservedVehicleException e) {
			System.out.println("* No Reservation for Vehicle Found *");
		}
	}

	/*
	 * 
	 * } catch (ReservedVehicleException e) {
	 * System.out.println("* Vehicle Already Reserved *");
	 * } catch (UnreservedVehicleException e) {
	 * System.out.println("* No Reservation for Vehicle Found *");
	 * }
	 */

	// Populate Functions

	public static void populateVehicle(Vehicles v) {
		Vehicle car1 = new Car(2019, 5, "Nissan Sentra", 35, "VUDNU37349");
		v.add(car1);
		Vehicle truck1 = new Truck(3, "25 ft", 25, "D5H6HDK78");
		v.add(truck1);
	}

	public static void populateAccount(Accounts a) {
		Account acct1 = new Account("1234567890123456", "Rock's Company", false);
		a.add(acct1);
		Account acct2 = new Account("0987654321098765", "Paper's Company", true);
		a.add(acct2);
	}

	// Display Functions
	public void displayResult(String[] result) {
		System.out.println(result);
	}

	public static void displayMenu() {
		System.out.println("Type 1 to display Car rates.");
		System.out.println("Type 2 to display SUV rates.");
		System.out.println("Type 3 to display Truck Rates.");
		System.out.println("Type 4 to update Car rates.");
		System.out.println("Type 5 to update SUV Rates.");
		System.out.println("Type 6 to update Truck Rates.");
		System.out.println("Type 7 to recieve estimated rental cost.");
		System.out.println("Type 8 to return vehicle");
		System.out.println("Type 9 to display all available cars");
		System.out.println("Type 10 to display all available trucks");
		System.out.println("Type 11 to display all available SUVs");
		System.out.println("Type 12 to display all available vehicles");
		System.out.println("Type 13 to make reservation");
		System.out.println("Type 14 to cancel reservation");
		System.out.println("Type 15 to get a reservation");
		System.out.println("Type 16 to display all reservation");
		System.out.println("Type 17 to get a account");
		System.out.println("Type 18 to display all aaccounts");
		System.out.println("Type 19 to display all transaction");
		System.out.println("Type 20 to exit program");

	}

}

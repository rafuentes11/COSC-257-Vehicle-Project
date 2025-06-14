/*
Rodrigo Fuentes
Brandon Dubbs
COSC 237 004
Fall 2022
*/
public class Reservation {
   /*
    * name - customer name
    * creditCardNumber - credit card number
    * rentalPeriod - rental period
    * insuranceSelected - optional daily insurance wanted
    */

   private String name;
   private String creditCardNumber;
   private TimeSpan rentalPeriod;
   private boolean insuranceSelected;

   public Reservation(String n, String cn, TimeSpan rp, boolean is) {
      name = n;
      creditCardNumber = cn;
      rentalPeriod = rp;
      insuranceSelected = is;
   }

   public String getName() {
      return name;
   }

   public String getCreditCardNumber() {
      return creditCardNumber;
   }

   public boolean getInsuranceSelected() {
      return insuranceSelected;
   }

   public String getInsurance() {
      if (insuranceSelected == true)
         return "Daily Insurance wanted";
      return "Daily Insurance not wanted";
   }

   public String toString() {
      return "Name: " + name + " Credit Card Number: " + creditCardNumber + " Rental Period: "
            + rentalPeriod.getNumUnits() + rentalPeriod.getTimeUnits() + " " + getInsurance();
   }

}

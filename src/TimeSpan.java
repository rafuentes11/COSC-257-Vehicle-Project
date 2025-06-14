/*
Rodrigo Fuentes
Brandon Dubbs
COSC 237 004
Fall 2022
*/
public class TimeSpan {
   private char timeUnit;
   private int numUnits;

   public TimeSpan(char tu, int nu) {
      timeUnit = tu;
      numUnits = nu;
   }

   public char getTimeUnits() {
      return timeUnit;
   }

   public int getNumUnits() {
      return numUnits;
   }

}

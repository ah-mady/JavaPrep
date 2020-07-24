public class SecondsInADay {
  public static void main(String[] args) {
    int currentHours = 14;
    int currentMinutes = 34;
    int currentSeconds = 42;

    // Write a program that prints the remaining seconds (as an integer) from a
    // day if the current time is represented by the variables

    int hours = 24;
    int minutes = 60;
    int seconds = 60;
    int secondsInOneDay = seconds * minutes * hours;
    int secondsSpent = currentSeconds + (currentMinutes*60) + (currentHours*3600);
    int remainingSecondsInOneDay= secondsInOneDay - secondsSpent;

    System.out.println("2 - Remaining seconds for today: " + remainingSecondsInOneDay);
  }
}

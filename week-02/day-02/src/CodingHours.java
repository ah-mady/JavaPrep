import java.text.DecimalFormat;

public class CodingHours {
  public static void main(String[] args) {
    // An average Green Fox attendee codes 6 hours daily
    // The semester is 17 weeks long
    //
    // Print how many hours is spent with coding in a semester by an attendee,
    // if the attendee only codes on workdays.
    //
    // Print the percentage of the coding hours in the semester if the average
    // work hours weekly is 52

    int codingHoursPerDay = 6;
    int workingDaysPerWeek = 5;
    int weeksPerSemester = 17;
    int codingHoursPerWeek = codingHoursPerDay * workingDaysPerWeek;
    int codingHoursPerSemester = codingHoursPerWeek * weeksPerSemester;

    System.out.println("An average Green Fox attendee codes " + codingHoursPerSemester + " hours per semester.");

    int workHoursWeekly = 52;
    float hoursPerSemester = 24 * 7 * weeksPerSemester;
    int codeHoursPerSemester = workHoursWeekly * 17;
    double percentageOfCodingHoursInWorkDays = (codeHoursPerSemester / hoursPerSemester) *100 ;
    DecimalFormat formatter = new DecimalFormat("#0.00");

    System.out.println("Percentage of the coding hours is " + formatter.format(percentageOfCodingHoursInWorkDays) + " %");

  }
}

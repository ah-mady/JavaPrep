public class Example8 {
  public static void main(String[] args) {
    //Write a Stream Expression to concatenate a Character list to a string!

    String name = "Ahme";

    name.lines()
        .map(conc -> conc.concat("d"))
        .forEach(System.out::println);
  }
}

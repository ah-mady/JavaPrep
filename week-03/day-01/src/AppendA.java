public class AppendA {
  public static void main(String[] args) {
    // - Create an array variable named `animals`
//   with the following content: `["koal", "pand", "zebr"]`
// - Add all elements an `"a"` at the end

    String[] animals = {"koal", "pand", "zebr"};
    for (String animal : animals) {
      animal = animal.concat("a");
      System.out.print(animal + " ");
    }
  }
}

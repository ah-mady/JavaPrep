public class VariableMutation {
  public static void main(String[] args) {
    int a = 3;
    // make the "a" variable's value bigger by 10

    System.out.println("A bigger by 10: " + (a+10));

    int b = 100;
    // make b smaller by 7

    System.out.println("B smalled by 7: " + (b-7));

    int c = 44;
    // please double c's value

    System.out.println("C times 2: " + c*2);

    int d = 125;
    // please divide by 5 d's value

    System.out.println("D divided by 5: " + d/5);

    int e = 8;
    // please cube of e's value

    System.out.println("Cube of e's value: " + e*e*e);

    int f1 = 123;
    int f2 = 345;
    // tell if f1 is bigger than f2 (print as a boolean)
    boolean isF1Bigger = false;

    if (f1>f2){
      isF1Bigger = true;
    }
    System.out.println("Is f1 is bigger than f2? " + isF1Bigger);

    int g1 = 350;
    int g2 = 200;
    // tell if the double of g2 is bigger than g1 (print as a boolean)
    boolean isG2Bigger = false;
    if ((g2*2) >g1){
      isG2Bigger = true;
    }
    System.out.println("Is double of g2 is bigger than g1? " + isG2Bigger);

    int h = 135798745;
    // tell if it has 11 as a divisor (print as a boolean)
    boolean isDivisibleBy11 = false;
    if (h%11 == 0){
      isDivisibleBy11 = true;
    }
    System.out.println("Is h has 11 as a divisor? " + isDivisibleBy11);

    int i1 = 10;
    int i2 = 3;
    // tell if i1 is higher than i2 squared and smaller than i2 cubed (print as a boolean)
    boolean isI1higher = false;
    if (i1 > (i2*2) && i1 < (i2*i2*i2)){
      isI1higher = true;
    }
    System.out.println("Is i1 is higher than i2 squared and smaller than i2 cubed? " + isI1higher);

    int j = 1521;
    // tell if j is dividable by 3 or 5 (print as a boolean)
    boolean isDivisibleBy3Or5 = false;
    if (j% 3 == 0 || j % 5 ==0){
      isDivisibleBy3Or5 = true;
    } System.out.println("Is j is divisible by 3 or 5? " + isDivisibleBy3Or5 );
  }
}

package number_converter;

import java.util.HashMap;

public class NumberConverter {
  static HashMap<String, Integer> numbers = new HashMap<String, Integer>();

  static HashMap<String, Integer> onumbers = new HashMap<String, Integer>();
  static HashMap<String, Integer> tnumbers = new HashMap<String, Integer>();

  static {
    numbers.put("zero", 0);
    numbers.put("one", 1);
    numbers.put("two", 2);
    numbers.put("three", 3);
    numbers.put("four", 4);
    numbers.put("five", 5);
    numbers.put("six", 6);
    numbers.put("seven", 7);
    numbers.put("eight", 8);
    numbers.put("nine", 9);
    numbers.put("ten", 10);
    numbers.put("eleven", 11);
    numbers.put("twelve", 12);
    numbers.put("thirteen", 13);
    numbers.put("fourteen", 14);
    numbers.put("fifteen", 15);
    numbers.put("sixteen", 16);
    numbers.put("seventeen", 17);
    numbers.put("eighteen", 18);
    numbers.put("nineteen", 19);

    tnumbers.put("twenty", 20);
    tnumbers.put("thirty", 30);
    tnumbers.put("fourty", 40);
    tnumbers.put("fifty", 50);
    tnumbers.put("sixty", 60);
    tnumbers.put("seventy", 70);
    tnumbers.put("eighty", 80);
    tnumbers.put("ninety", 90);

    onumbers.put("hundred", 100);
    onumbers.put("thousand", 1000);
    onumbers.put("million", 1000000);
    onumbers.put("billion", 1000000000);
  }

  public static void main(String[] args) {
    NumberConverter numberConverter = new NumberConverter();
    System.out.println(numberConverter.convert(123456));
  }

  public String convert(int number) {

    System.out.println(number+" sout");
    if (number <= 0) {
      return "Invalid balance!";
    }

    String current = "";
    int place = 0;

    do {
      int n = number % 1000;
      if (n != 0) {
        String s = convertLessThanOneThousand(n);
        current = s + specialNames[place] + current;
      }
      place++;
      number /= 1000;
    } while (number > 0);

    wordToNumber(current);
    return (current).trim();
  }

  private String convertLessThanOneThousand(int number) {
    String current;

    if (number % 100 < 20) {
      current = numNames[number % 100];
      number /= 100;
    } else {
      current = numNames[number % 10];
      number /= 10;

      current = tensNames[number % 10] + current;
      number /= 10;
    }
    if (number == 0) {
      return current;
    }
    return numNames[number] + " hundred" + current;
  }

  private static void wordToNumber(String input) {
    long sum=0;
    Integer temp=null;
    Integer previous=0;
    String [] splitted= input.toLowerCase().split(" ");


    for(String split:splitted){

      if( numbers.get(split)!=null){
        temp= numbers.get(split);

        sum=sum+temp;

        previous=previous+temp;
      }
      else if(onumbers.get(split)!=null){
        if(sum!=0){
          sum=sum-previous;
        }
        sum=sum+(long)previous*(long)onumbers.get(split);
        temp=null;
        previous=0;


      }
      else if(tnumbers.get(split)!=null){
        temp=tnumbers.get(split);
        sum=sum+temp;

        previous=temp;
      }

    }

    System.out.println(sum);
  }

  private static final String[] specialNames = {
      "",
      " thousand",
      " million",
      " billion",
      " trillion",
      " quadrillion",
      " quintillion"
  };

  private static final String[] tensNames = {
      "",
      " ten",
      " twenty",
      " thirty",
      " forty",
      " fifty",
      " sixty",
      " seventy",
      " eighty",
      " ninety"
  };

  private static final String[] numNames = {
      "",
      " one",
      " two",
      " three",
      " four",
      " five",
      " six",
      " seven",
      " eight",
      " nine",
      " ten",
      " eleven",
      " twelve",
      " thirteen",
      " fourteen",
      " fifteen",
      " sixteen",
      " seventeen",
      " eighteen",
      " nineteen"
  };
}

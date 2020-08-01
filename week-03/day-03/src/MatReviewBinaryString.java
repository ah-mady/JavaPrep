import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MatReviewBinaryString {
  public static void main(String[] args) {
    /*String decodedString = decode("11010111010011011100111111010111");
    String decodedString2 = decode("11010110010011011100111111010111");
    System.out.println(decodedString);*/
    String secretString = "11010111010011011100111111010111";
    String[] chunks = separateToChunks(secretString); // Single Responsibility Principle
    ArrayList<String> letterBinaries = filterOnlyLetters(chunks);
    int[] letters = convertBinariesToLetters(letterBinaries);
    String decodedString = concatenateLetters(letters);
    System.out.println(decodedString);
    System.out.println(countOccurrences(decodedString));
  }

  private static HashMap<String, Integer> countOccurrences(String decodedString) {
    HashMap<String, Integer> letterOccurrences = new HashMap<>();
    for (int i = 0; i < decodedString.length(); i++) {
      String letter = decodedString.substring(i, i+1);
      if (letterOccurrences.containsKey(letter)){
        letterOccurrences.put(letter, letterOccurrences.get(letter) +1);
      } else {
        letterOccurrences.put(letter, 1);
      }
    }
    return letterOccurrences;
  }

  private static String decode(String secretString) {
    String[] chunks = separateToChunks(secretString); // Single Responsibility Principle
    ArrayList<String> letterBinaries = filterOnlyLetters(chunks);
    int[] letters = convertBinariesToLetters(letterBinaries);
    String decodedString = concatenateLetters(letters);
    return decodedString;
  }

  private static String concatenateLetters(int[] charCodes) {
    String decodedString = "";
    for (int charCode : charCodes) {
      decodedString += (char) charCode;
    }
    return decodedString;
  }

  private static int[] convertBinariesToLetters(ArrayList<String> letterBinaries) {
    int[] letterCodes = new int[letterBinaries.size()];

    for (int j = 0; j < letterBinaries.size(); j++) {
      String letterBinary = letterBinaries.get(j);
      int charCode = calculateCharCode(letterBinary);
      letterCodes[j] = charCode;
    }

    return letterCodes;
  }

  private static int calculateCharCode(String letterBinary) {
    int charCode = 0;

    for (int i = 1; i < letterBinary.length(); i++) {
      int bit = Integer.parseInt(letterBinary.substring(i, i + 1));
      int exponent = letterBinary.length() - i - 1;
      int multiplier = (int) Math.pow(2, exponent); // 2^exponent
      charCode += bit * multiplier;
    }

    return charCode;
  }

  private static ArrayList<String> filterOnlyLetters(String[] chunks) {
    ArrayList<String> letterBinaries = new ArrayList<>();

    for (int i = 0; i < chunks.length; i++) {
      if (chunks[i].charAt(0) == '1') {
        letterBinaries.add(chunks[i]);
      }
    }

    return letterBinaries;
  }

  private static String[] separateToChunks(String secretString) {
    int chunkSize = 8;
    int count = 0;
    String[] chunks = new String[secretString.length() / chunkSize];
    for (int i = 0; i < secretString.length(); i += chunkSize) {
      String chunk = secretString.substring(i, i + chunkSize);
      chunks[count] = chunk;
      count++;
    }
    return chunks;
  }
}

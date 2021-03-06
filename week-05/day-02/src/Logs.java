import java.awt.Stroke;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Logs {
  public static void main(String[] args) {

// Read all data from 'log.txt'.
// Each line represents a log message from a web server
// Write a function that returns an array with the unique IP adresses.
// Write a function that returns the GET / POST request ratio.

    System.out.println(uniqueIP());
    System.out.println(getPostRatio());
  }

  private static String getPostRatio() {
    List<String> lines = readFile("log.txt");
    String[] splitLines;
    int getCount = 0;
    int postCount = 0;
    for (String line : lines) {
      splitLines = line.split("   ");
      if (splitLines[2].contains("GET")) {
        ++getCount;
      } else if (splitLines[2].contains("POST")) {
        ++postCount;
      }
    }
    int finalGCF = 0;
    for (int greatestCommonFactor = 1; greatestCommonFactor <= getCount && greatestCommonFactor <= postCount; greatestCommonFactor++) {
      if (getCount % greatestCommonFactor == 0 && postCount % greatestCommonFactor == 0) {
        finalGCF = greatestCommonFactor;
      }
    }
    int getRatio = getCount / finalGCF;
    int postRatio = postCount / finalGCF;
    return "GET / POST request ratio is: \n" + "\t" + getCount + " : " + postCount + " = " + getRatio + " : " + postRatio;
  }

  private static String uniqueIP() {
    List<String> lines = readFile("log.txt");
    String iPAddresses = "";
    String[] splitLine;
    for (String line : lines) {
      splitLine = line.split("   ");
      iPAddresses += (splitLine[1]) + "\n";
    }
    return iPAddresses;
  }

  private static List<String> readFile(String fileName) {
    Path path = Paths.get(fileName);
    List<String> lines = new ArrayList<>();
    try {
      List<String> readLines = Files.readAllLines(path);
      lines.addAll(readLines);
    } catch (IOException e) {
      System.out.println("IOException in readFile function");
    }
    return lines;
  }
}

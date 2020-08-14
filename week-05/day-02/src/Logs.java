import java.awt.Stroke;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Logs {
  public static void main(String[] args) {

// Read all data from 'log.txt'.
// Each line represents a log message from a web server
// Write a function that returns an array with the unique IP adresses.
// Write a function that returns the GET / POST request ratio.

   // readFile("path");
    uniqueIP();
   // getPostRatio();
  }

  private static void uniqueIP() {
    List <String> lines = readFile("log.txt");
    for (String line:lines) {
      String[] stringArray = line.split("   ");
      System.out.println(Arrays.toString(stringArray));
    }
  }

  private static List<String> readFile(String fileName) {
    Path path = Paths.get(fileName);
    List <String> lines = new ArrayList<>();
    try{
      List<String> readLines = Files.readAllLines(path);
      lines.addAll(readLines);
    } catch (IOException e){
      System.out.println("IOException in readFile function");
    }
    return lines;
  }
}

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Doubled {
  public static void main(String[] args) {
    // Create a method that decrypts the duplicated-chars.txt
    decryptChars();
  }

  private static void decryptChars() {
    Path path = Paths.get("duplicated-chars.txt");
    List<String> decryptedLines = new ArrayList<>();
    try {
      List<String> oldLines = Files.readAllLines(path);
      for (String line : oldLines) {
        String newLine = "";
        for (int i = 0; i < line.length() - 1; i++) {
          newLine += line.charAt(i);
          if (line.charAt(i) == line.charAt(i + 1)) {
            i += 2;
          }
        }
        decryptedLines.add(newLine);
      }
      Files.write(Paths.get("decrypted-chars.txt"), decryptedLines);
    } catch (IOException e) {
      System.out.println("IOException");
    }
  }
}

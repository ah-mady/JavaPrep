import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReversedLines {
  public static void main(String[] args) {
    // Create a method that decrypts reversed-lines.txt
    reversedLines();
  }

  private static void reversedLines() {
    Path path = Paths.get("reversed-lines.txt");
    List<String> nonReversedLines = new ArrayList<>();
    try {
      List<String> oldLines = Files.readAllLines(path);
      for (String line : oldLines) {
        int endIndex = line.length() - 1;
        char[] oldChar = line.toCharArray();
        char[] newChar = new char[oldChar.length];
        for (int i = 0; i < line.length(); i++) {
          newChar[i] += oldChar[endIndex];
          endIndex--;
        }
        String newList = new String(newChar);
        nonReversedLines.add(newList);
        Files.write(Paths.get("non-reversed-lines.txt"), nonReversedLines);
      }
    } catch (IOException e) {
      System.out.println();
    }
  }
}

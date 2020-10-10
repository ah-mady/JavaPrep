import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Example11 {
  public static void main(String[] args) throws Exception {
    Map<String, Long> test = readFile("WikiPage.txt").stream()
            .flatMap(a -> Arrays.stream(a.split("\\s+"))) //lines with text are split to words and streamed as String
            .map(a -> a.replaceAll("[^a-zA-Z/]", ""))
            .map(a -> a.strip()) //deleting all empty spaces
            .filter(a -> !a.isEmpty()) //deletes empty items (null words)
            .collect(Collectors.groupingBy(a -> a, Collectors.counting()));

    System.out.println(test);

  }

  public static List<String> readFile(String fileName) throws Exception {
    List<String> lines;
    try {
      Path path = Paths.get(fileName);
      lines = Files.readAllLines(path);
    } catch (IOException e) {
      throw new Exception("File does not exists on the given path");
    }
    return lines;
  }
}

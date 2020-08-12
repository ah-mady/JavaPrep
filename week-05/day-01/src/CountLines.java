import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CountLines {
  public static void main(String[] args) {

// Write a function that takes a filename as string,
// then returns the number of lines the file contains.
// It should return zero if it can't open the file, and
// should not raise any error.
    System.out.println(countLines("filename"));
  }

  private static int countLines(String filename) {
    Path path = Paths.get(filename);
    int counter = 0;
    try{
      List<String> lines = Files.readAllLines(path);
      for (String line: lines) {
        counter++;
      }
    } catch (NoSuchFileException e){
      return 0;
    } catch (IOException e){
      return 1;
    }
    return counter;
  }
}

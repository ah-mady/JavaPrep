import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CopyFiles {
  public static void main(String[] args) {

// Write a function that copies the contents of a file into another
// It should take the filenames as parameters
// It should return a boolean that shows if the copy was successful
    System.out.println(copyFiles("my-file.txt"));

  }

  private static boolean copyFiles(String fileName) {
    Path path = Paths.get(fileName);
    Path path1 = Paths.get("new-file-from-copyFile-task.txt");
    boolean result = false;
    try{
      List<String> lines = readFiles(fileName);
      if (lines.isEmpty()){
        return result;
      }
      Files.write(path1, lines);
      result = true;
      return result;
    } catch (IOException e){
      return result;
    }
  }

  private static List<String> readFiles(String filename) {
    Path path = Paths.get(filename);
    List<String> newLines = new ArrayList<>();
    try {
      List<String> lines = Files.readAllLines(path);
      newLines.addAll(lines);
    } catch (IOException e){
      System.out.println("this line is reached");
    }
    return newLines;
  }
}

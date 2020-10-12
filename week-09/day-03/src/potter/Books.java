package potter;

import java.util.ArrayList;
import java.util.List;
z
public class Books {
  private List<String> books;
  private double costOfEachBook = 8.0;
  private int numberOfBooks;

  public Books() {
    this.books = new ArrayList<>();
    this.books = listOfBooks();
  }

  private List<String> listOfBooks(){
    books.add("Harry Potter series 1");
    books.add("Harry Potter series 2");
    books.add("Harry Potter series 3");
    books.add("Harry Potter series 4");
    books.add("Harry Potter series 5");
    return books;
  }

  private void optimizedPriceOfBooks(){
    if (isOptimizable()){
      for (String book: books) {

      }
    }
  }

  private boolean isOptimizable() {
    return this.numberOfBooks > 0;
  }

  public void purchase(){

  }

  @Override
  public String toString() {
    return "List of books: \n" + books;
  }
}

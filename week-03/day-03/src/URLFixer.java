import java.util.Arrays;

public class URLFixer {
  public static void main(String[] args) {
    String url = "https//www.reddit.com/r/nevertellmethebots";
    // Accidentally I got the wrong URL for a funny subreddit. It's probably "odds" and not "bots"
    // Also, the URL is missing a crucial component, find out what it is and insert it too!
    // Try to solve it more than once using different String functions!

    System.out.println(fixedUrl(url));
  }

  private static String fixedUrl(String url) {
    int toIndex = url.length() - 4;
    String toAdd = "odds";
    String urlString = url.substring(0, toIndex) + toAdd;
    String fixedUrl = urlString.replace("//", "//:");
    return fixedUrl;
  }
}

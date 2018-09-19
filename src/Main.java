import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;


public class Main {
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    public static int wordCount(String text) {
        int count = 0;
        for (char character: text.toCharArray()) {
            if (character == ' ') {
                count++;
            }
        }
        return count;
    }

    public static int specificWordCount(String text, String word) {
        int count = 0;
        for (String currentWord: text.split("[ ,.!?]+")) {
            if (word.equals(currentWord)) {
                count++;
            }
        }
        return count;
    }

    public static int uniqueWordCount(String text) {
        Map<String, Integer> uniqueWords = new HashMap<>();
        int count = 0;
        for (String currentWord: text.split("[ ,.!?]+")) {
            if (!uniqueWords.containsKey(currentWord)) {
                uniqueWords.put(currentWord,1);
                count++;
            }
        }
        return count;
    }




    public static void main(String[] args) {
	// write your code here
        System.out.println(wordCount(urlToString("http://erdani.com/tdpl/hamlet.txt")));
        System.out.println(uniqueWordCount(urlToString("http://erdani.com/tdpl/hamlet.txt")));
        System.out.println(specificWordCount(urlToString("http://erdani.com/tdpl/hamlet.txt"), "Hamlet"));
    }
}

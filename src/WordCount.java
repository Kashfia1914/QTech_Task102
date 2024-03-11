import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class WordCount {

    public static void main(String[] args) {

        String filePath = "P:\\WordCounter\\text.txt";


        Map<String, Integer> wordCountMap = countWords(filePath);


        displayWordCount(wordCountMap);
    }

    private static Map<String, Integer> countWords(String filePath) {
        Map<String, Integer> wordCountMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {

                String[] words = line.split("\\s+");


                for (String word : words) {

                    word = word.replaceAll("^[^a-zA-Z0-9]+|[^a-zA-Z0-9]+$", "");


                    wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return wordCountMap;
    }

    private static void displayWordCount(Map<String, Integer> wordCountMap) {

        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

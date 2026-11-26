import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class PositiveOrNegative {
    public void analyzeAllArticles() throws IOException {
        Set<String> positiveWords = loadWords("positive.txt");
        Set<String> negativeWords = loadWords("negative.txt");
        File[] articleFiles = new File("src/articles").listFiles(file ->
                file.isFile()
                        && file.getName().endsWith(".txt")
                        && !file.getName().equalsIgnoreCase("stopwords.txt"));

        if (articleFiles == null) {
            throw new IOException("Unable to read article files from src/articles.");
        }

        System.out.println("\nArticle classification (positive words - negative words):");
        TextToArray textToArray = new TextToArray();
        for (File articleFile : articleFiles) {
            String[] words = textToArray.convertTextToArray(articleFile.getName());
            int positiveCount = 0;
            int negativeCount = 0;

            for (String word : words) {
                String normalizedWord = word.toLowerCase(Locale.ROOT);
                if (positiveWords.contains(normalizedWord)) {
                    positiveCount++;
                }
                if (negativeWords.contains(normalizedWord)) {
                    negativeCount++;
                }
            }

            int score = positiveCount - negativeCount;
            String result = score > 0 ? "POSITIVE" : score < 0 ? "NEGATIVE" : "NEUTRAL";
            System.out.println(articleFile.getName() + ": " + result
                    + " (positive: " + positiveCount
                    + ", negative: " + negativeCount
                    + ", score: " + score + ")");
        }
    }

    private Set<String> loadWords(String fileName) throws IOException {
        Set<String> words = new HashSet<>();
        for (String word : Files.readAllLines(Path.of("src", "positiveornegative", fileName))) {
            String normalizedWord = word.trim().toLowerCase(Locale.ROOT);
            if (!normalizedWord.isEmpty()) {
                words.add(normalizedWord);
            }
        }
        return words;
    }
}

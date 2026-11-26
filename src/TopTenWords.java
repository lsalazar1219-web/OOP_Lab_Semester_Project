import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class TopTenWords {
    public void printTopTenWordsForAllArticles() throws IOException {
        File[] articleFiles = new File("src/articles").listFiles(file ->
                file.isFile()
                        && file.getName().endsWith(".txt")
                        && !file.getName().equalsIgnoreCase("stopwords.txt"));

        if (articleFiles == null) {
            throw new IOException("Unable to read article files from src/articles.");
        }

        TextToArray textToArray = new TextToArray();
        for (File articleFile : articleFiles) {
            String[] articleWords = textToArray.convertTextToArray(articleFile.getName());
            ArrayList<String> cleanedWords = new ArticleCleanUp(articleWords).clean_article();
            new ArticleAnalysis(cleanedWords).printTopTenWords(articleFile.getName());
        }
    }
}

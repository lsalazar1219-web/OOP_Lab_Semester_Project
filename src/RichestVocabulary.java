import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class RichestVocabulary {
    public void printRichestVocabulary() throws IOException {
        File articlesDirectory = new File("src/articles");
        File[] articleFiles = articlesDirectory.listFiles(file ->
                file.isFile()
                        && file.getName().endsWith(".txt")
                        && !file.getName().equalsIgnoreCase("stopwords.txt"));

        if (articleFiles == null) {
            throw new IOException("Unable to read article files from src/articles.");
        }
        if (articleFiles.length == 0) {
            System.out.println("No article text files were found in src/articles.");
            return;
        }

        String richestArticle = null;
        int greatestUniqueWordCount = -1;
        ArrayList<String> tiedArticles = new ArrayList<>();
        TextToArray textToArray = new TextToArray();

        for (File articleFile : articleFiles) {
            String[] articleWords = textToArray.convertTextToArray(articleFile.getName());
            ArrayList<String> cleanedWords = new ArticleCleanUp(articleWords).clean_article();
            int uniqueWordCount = new ArticleAnalysis(cleanedWords).getUniqueWordCount();

            if (uniqueWordCount > greatestUniqueWordCount) {
                greatestUniqueWordCount = uniqueWordCount;
                richestArticle = articleFile.getName();
                tiedArticles.clear();
                tiedArticles.add(richestArticle);
            } else if (uniqueWordCount == greatestUniqueWordCount) {
                tiedArticles.add(articleFile.getName());
            }
        }

        if (tiedArticles.size() == 1) {
            System.out.println("Richest vocabulary: " + richestArticle +
                    " (" + greatestUniqueWordCount + " unique words)");
        } else {
            System.out.println("Tie for richest vocabulary (" + greatestUniqueWordCount +
                    " unique words): " + String.join(", ", tiedArticles));
        }
    }
}

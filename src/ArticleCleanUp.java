import java.io.IOException;
import java.util.*;

public class ArticleCleanUp {
    private String[] article;

    public ArticleCleanUp(String[] article){
        this.article = article;
    }

    public ArrayList<String> clean_article() throws IOException {
        /*
        * This class turns the String[] array of an article into an ArrayList and
        * compares it to a Set of common stopwords, removing them if found so not
        * upset the statistics that ArticleAnalysis will afterwards run.
        * */

        // Convert stopwords.txt file into String array so it can later be converted
        // to a Set to compare with the article's words.
        TextToArray text_to_array = new TextToArray();
        String[] stopwords = text_to_array.convertTextToArray("stopwords.txt");

        // Normalize both lists so stop-word matching and later statistics ignore case.
        Set<String> StopWordsHashSet = new HashSet<>();
        for (String stopword : stopwords) {
            StopWordsHashSet.add(stopword.toLowerCase(Locale.ROOT));
        }

        ArrayList<String> ArticleArrayList = new ArrayList<>();
        for (String word : this.article) {
            ArticleArrayList.add(word.toLowerCase(Locale.ROOT));
        }

        // Remove elements if they exist in the reference set.
        ArticleArrayList.removeIf(StopWordsHashSet::contains);

        return ArticleArrayList;

    }

}

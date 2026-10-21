import java.util.*;

public class ArticleCleanUp {
    private String[] article;
    private TextToArray stop_words;

    public ArticleCleanUp(String[] article){
        this.article = article;
    }

    public ArrayList<String> clean_article() throws Exception {
        /*
        * This class turns the String[] array of an article into an ArrayList and
        * compares it to a Set of common stopwords, removing them if found so not
        * upset the statistics that ArticleAnalysis will afterwards run.
        * */

        // Convert stopwords.txt file into String array so it can later be converted
        // to a Set to compare with the article's words.
        TextToArray text_to_array = new TextToArray();
        String[] stopwords = text_to_array.convertTextToArray("stopwords.txt");

        // Make ArrayLists from the String[] arrays of the article and the stopwords.
        ArrayList<String> StopWordsArrayList = new ArrayList<>(Arrays.asList(stopwords));
        ArrayList<String> ArticleArrayList = new ArrayList<>(Arrays.asList(this.article));


        // Turn the StopWordsArrayList into a set for faster processing.
        Set<String> StopWordsHashSet = new HashSet<>(StopWordsArrayList);

        // Remove elements if they exist in the reference set.
        ArticleArrayList.removeIf(StopWordsHashSet::contains);

        return ArticleArrayList;

    }

}

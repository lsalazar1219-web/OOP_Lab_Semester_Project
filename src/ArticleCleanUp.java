import java.util.*;

public class ArticleCleanUp {
    private String[] article;
    private TextToArray stop_words;

    public ArticleCleanUp(String[] article){
        this.article = article;
    }

    public ArrayList<String> clean_article() throws Exception {
        TextToArray stop_words = new TextToArray();

        String[] stopwords = stop_words.convertTextToArray("stopwords.txt");

        ArrayList<String> StopWordsArrayList = new ArrayList<>(Arrays.asList(stopwords));
        ArrayList<String> ArticleArrayList = new ArrayList<>(Arrays.asList(this.article));

        Set<String> StopWordsHashSet = new HashSet<>(StopWordsArrayList);

        // Remove elements if they exist in the reference set
        ArticleArrayList.removeIf(StopWordsHashSet::contains);

        return ArticleArrayList;

    }

}

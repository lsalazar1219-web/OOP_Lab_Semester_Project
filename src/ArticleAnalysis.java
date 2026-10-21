import java.util.*;

public class ArticleAnalysis {
    private ArrayList<String> article_words;

    public ArticleAnalysis(ArrayList<String> article_words){
        this.article_words = article_words;
    }

    public void calculate_statistics() throws Exception {

        int numberOfWords = this.article_words.size();

        Set<String> UniqueWords = new HashSet<>(this.article_words);
        int numberOfUniqueWords = UniqueWords.size();

        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : this.article_words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        //Filter out items that appear only once
        List<Map.Entry<String, Integer>> duplicateList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > 1) {
                duplicateList.add(entry);
            }
        }

        //Sort the entries by value in descending order
        duplicateList.sort(new Comparator<Map.Entry<String, Integer>>() {
            //@Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                return e2.getValue().compareTo(e1.getValue()); // Descending
            }
        });

        //Print results
        System.out.println("Number of words: "+numberOfWords);
        System.out.println("\nNumber of unique words: "+numberOfUniqueWords);
        System.out.println("\nFrequency of words:\n");
        for (Map.Entry<String, Integer> entry : duplicateList) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " times");
        }
    }

}

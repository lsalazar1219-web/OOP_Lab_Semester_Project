import java.util.*;

public class ArticleAnalysis {
    private ArrayList<String> article_words;

    public ArticleAnalysis(ArrayList<String> article_words){
        this.article_words = article_words;
    }

    public void calculate_statistics(int action) throws Exception {
        /*
        * This class takes the cleaned up ArrayList from ArticleCleanUp and runs basic statistics
        * on it. It finds out how many words the article has, how many unique words, and how frequent
        * each word is. Then it prints this information for the user.
        * */

        // Find the total number of words.
        int numberOfWords = this.article_words.size();

        //Find the total number of unique words using a HashSet, which merges duplicated entries,
        // thus producing the collection of all unique words in the article.
        Set<String> UniqueWords = new HashSet<>(this.article_words);
        int numberOfUniqueWords = UniqueWords.size();

        // Make the frequency map using a HashMap.
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : this.article_words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        //Filter out items that appear only once.
        List<Map.Entry<String, Integer>> duplicateList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > 1) {
                duplicateList.add(entry);
            }
        }

        //Sort the entries by value in descending order.
        duplicateList.sort(new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                return e2.getValue().compareTo(e1.getValue()); // Descending
            }
        });

        //Print results, allowing the user to decide which statistic is printed.
        switch (action) {
            case 1:
                System.out.println("Number of words: "+numberOfWords);
                break;
            case 2:
                System.out.println("\nNumber of unique words: "+numberOfUniqueWords);
                break;
            case 3:
                System.out.println("\nFrequency of words:\n");
                for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()){
                    System.out.println(entry.getKey() + ": " + entry.getValue() + " times");}
                break;
            case 4:
                System.out.println("Number of words: "+numberOfWords);
                System.out.println("\nNumber of unique words: "+numberOfUniqueWords);
                System.out.println("\nFrequency of words:\n");
                for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()){
                    System.out.println(entry.getKey() + ": " + entry.getValue() + " times");}
                break;
                }
        }
    }
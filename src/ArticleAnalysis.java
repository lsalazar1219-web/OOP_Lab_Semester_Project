import java.util.*;

public class ArticleAnalysis {
    private ArrayList<String> article_words;

    public ArticleAnalysis(ArrayList<String> article_words){
        this.article_words = article_words;
    }

    public int getUniqueWordCount() {
        Set<String> uniqueWords = new HashSet<>(this.article_words);
        return uniqueWords.size();
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

        List<Map.Entry<String, Integer>> sortedFrequencyList = getSortedWordFrequencies();

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
                for (Map.Entry<String, Integer> entry : sortedFrequencyList) {
                    if (entry.getValue() > 1) {
                        System.out.println(entry.getKey() + ": " + entry.getValue() + " times");
                    }
                }
                break;
            case 4:
                System.out.println("Number of words: "+numberOfWords);
                System.out.println("\nNumber of unique words: "+numberOfUniqueWords);
                System.out.println("\nFrequency of words:\n");
                for (Map.Entry<String, Integer> entry : sortedFrequencyList) {
                    if (entry.getValue() > 1) {
                        System.out.println(entry.getKey() + ": " + entry.getValue() + " times");
                    }
                }
                break;
        }
    }

    public void printTopTenWords(String articleName) {
        List<Map.Entry<String, Integer>> sortedFrequencyList = getSortedWordFrequencies();
        System.out.println("\nTop words in " + articleName + ":");
        for (int i = 0; i < Math.min(10, sortedFrequencyList.size()); i++) {
            Map.Entry<String, Integer> entry = sortedFrequencyList.get(i);
            System.out.println((i + 1) + ". " + entry.getKey() + ": " +
                    entry.getValue() + " times");
        }
    }

    private List<Map.Entry<String, Integer>> getSortedWordFrequencies() {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : this.article_words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        List<Map.Entry<String, Integer>> sortedFrequencyList =
                new ArrayList<>(frequencyMap.entrySet());
        sortedFrequencyList.sort(new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> first, Map.Entry<String, Integer> second) {
                int frequencyComparison = second.getValue().compareTo(first.getValue());
                return frequencyComparison != 0
                        ? frequencyComparison
                        : first.getKey().compareTo(second.getKey());
            }
        });
        return sortedFrequencyList;
    }
}
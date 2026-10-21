import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main() throws Exception {
        /*d
         * Main class. First uses TextToArray to convert the raw .txt file into a regular array
         * of String objects. Then use ArticleCleanUp to remove stop words. Finally, use the
         * ArticleAnalysis class to find out how many words, how many unique words, and how
         * frequent words are.

         * This method supports user interactivity. It allows you to choose what file to analyze
         * by entering the file's name, and allows you to choose what statistics you would like
         * shown. It runs until quit by the user, so you can analyze multiple files in one program
         * execution.
         * */
        outerLoop:
        while (true) {
            // Initialize TextToArray object and String array which the object will return.
            TextToArray text_to_array = new TextToArray();
            String[] article_array_1;
            ArrayList<String> article_ArrayList_1;

            // Read the user-inputted file and use TextToArray + ArticleCleanUp
            // to prepare the article for analysis.
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter file_name of article:");
            String file_name = scanner.nextLine();
            article_array_1 = text_to_array.convertTextToArray(file_name);
            ArticleCleanUp articleCleaner = new ArticleCleanUp(article_array_1);
            article_ArrayList_1 = articleCleaner.clean_article();

            // Initialize the ArticleAnalysis object that will calculate article statistics.
            ArticleAnalysis articleAnalyzer = new ArticleAnalysis(article_ArrayList_1);


            // Allow user choice in what statistics are calculated.
            samearticleloop:
            while (true){
                System.out.println("\nEnter action for statistics:\n" +
                        "1. Number of words\n" +
                        "2. Number of unique words\n" +
                        "3. Frequency of words\n" +
                        "4. All of the above");
                int int_command = scanner.nextInt();

                action_switch:
                switch (int_command) {
                    case 1:
                        articleAnalyzer.calculate_statistics(1);
                        break action_switch;
                    case 2:
                        articleAnalyzer.calculate_statistics(2);
                        break action_switch;
                    case 3:
                        articleAnalyzer.calculate_statistics(3);
                        break action_switch;
                    case 4:
                        articleAnalyzer.calculate_statistics(4);
                        break action_switch;
                    default:
                        continue;
                }

                // Allow user to run more statistics on the same article or return to the
                // previous menu and enter a new article.
                // Or quit.
                nextactionloop:
                while (true) {
                    System.out.println("\nEnter next action:\n" +
                            "1. Another statistic on same article\n" +
                            "2. To to a different article\n" +
                            "3. quit");

                    int_command = scanner.nextInt();

                    switch (int_command) {
                        case 1:
                            continue samearticleloop;
                        case 2:
                            continue outerLoop;
                        case 3:
                            break outerLoop;
                        default:
                            continue;

                    }
                }
            }
        }
    }

}


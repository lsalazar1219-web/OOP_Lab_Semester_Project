import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main() throws Exception {
        outerLoop:
        while (true) {
            TextToArray text_to_array = new TextToArray();
            String[] article_array_1;
            ArrayList<String> article_ArrayList_1;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter file_name of article:");
            String file_name = scanner.nextLine();
            article_array_1 = text_to_array.convertTextToArray(file_name);
            ArticleCleanUp articleCleaner = new ArticleCleanUp(article_array_1);
            article_ArrayList_1 = articleCleaner.clean_article();

            ArticleAnalysis articleAnalyzer = new ArticleAnalysis(article_ArrayList_1);

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


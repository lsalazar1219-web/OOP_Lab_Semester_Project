import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main() throws Exception {
        System.out.println("Java is looking in: " + new java.io.File(".").getAbsolutePath());
        TextToArray text_to_array = new TextToArray();
        String[] article_array_1;
        ArrayList<String> article_ArrayList_1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name of article, and I will tell you the number of words,\n" +
                "number of unique words, and word frequency.");
        String file_name = scanner.nextLine();

        article_array_1 = text_to_array.convertTextToArray(file_name);
        ArticleCleanUp articleCleaner = new ArticleCleanUp(article_array_1);
        article_ArrayList_1 = articleCleaner.clean_article();

        ArticleAnalysis articleAnalyzer = new ArticleAnalysis(article_ArrayList_1);

        articleAnalyzer.calculate_statistics();



    }
}

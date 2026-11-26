import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main() throws Exception {
        /*
         * Main class. First uses TextToArray to convert the raw .txt file into a regular array
         * of String objects. Then use ArticleCleanUp to remove stop words. Finally, use the
         * ArticleAnalysis class to find out how many words, how many unique words, and how
         * frequent words are.

         * This method supports user interactivity. It allows you to choose what file to analyze
         * by entering the file's name, and allows you to choose what statistics you would like
         * shown. It runs until quit by the user, so you can analyze multiple files in one program
         * execution.
         * */
        Scanner scanner = new Scanner(System.in);
        mainMenuLoop:
        while (true) {
            String menuCommand = readChoice(scanner,
                    "\nMain menu:\n" +
                            "1. Statistics on 1 article\n" +
                            "2. Statistics on all articles",
                    "1", "2");
            if (menuCommand == null) {
                break;
            }
            if (menuCommand.equals("2")) {
                String allArticlesCommand = readChoice(scanner,
                        "\nStatistics on all articles:\n" +
                                "1. Richest vocabulary\n" +
                                "2. Top ten words in each article\n" +
                                "3. Positive or negative articles\n" +
                                "4. All three statistics\n" +
                                "5. Return to main menu",
                        "1", "2", "3", "4", "5");
                if (allArticlesCommand == null) {
                    break;
                }
                switch (allArticlesCommand) {
                    case "1":
                        new RichestVocabulary().printRichestVocabulary();
                        break;
                    case "2":
                        new TopTenWords().printTopTenWordsForAllArticles();
                        break;
                    case "3":
                        new PositiveOrNegative().analyzeAllArticles();
                        break;
                    case "4":
                        new RichestVocabulary().printRichestVocabulary();
                        new TopTenWords().printTopTenWordsForAllArticles();
                        new PositiveOrNegative().analyzeAllArticles();
                        break;
                    case "5":
                        break;
                }
                continue;
            }

            articleLoop:
            while (true) {
                // Initialize TextToArray object and String array which the object will return.
                TextToArray textToArray = new TextToArray();
                String[] articleArray;
                ArrayList<String> articleWords;

                // Read the user-inputted file and use TextToArray + ArticleCleanUp
                // to prepare the article for analysis.
                System.out.println("Enter file_name of article (or 0 to return to main menu):");
                if (!scanner.hasNextLine()) {
                    break mainMenuLoop;
                }
                String fileName = scanner.nextLine().trim();
                if (fileName.equals("0")) {
                    continue mainMenuLoop;
                }
                if (fileName.isEmpty()) {
                    System.out.println("File name cannot be blank.");
                    continue articleLoop;
                }

                Path articlesDirectory = Path.of("src", "articles").toAbsolutePath().normalize();
                Path articlePath;
                try {
                    articlePath = articlesDirectory.resolve(fileName).normalize();
                } catch (InvalidPathException e) {
                    System.out.println("Invalid file name. Enter a file from src/articles.");
                    continue articleLoop;
                }
                if (!articlePath.startsWith(articlesDirectory) || !Files.isRegularFile(articlePath)) {
                    System.out.println("Article file not found. Enter a file from src/articles.");
                    continue articleLoop;
                }

                try {
                    articleArray = textToArray.convertTextToArray(fileName);
                } catch (IOException e) {
                    System.out.println("Unable to read article file. Please enter another file name.");
                    continue articleLoop;
                }
                ArticleCleanUp articleCleaner = new ArticleCleanUp(articleArray);
                articleWords = articleCleaner.clean_article();

                // Initialize the ArticleAnalysis object that will calculate article statistics.
                ArticleAnalysis articleAnalyzer = new ArticleAnalysis(articleWords);

                // Allow user choice in what statistics are calculated.
                samearticleloop:
                while (true) {
                    String statisticsCommand = readChoice(scanner,
                            "\nEnter action for statistics:\n" +
                                    "1. Number of words\n" +
                                    "2. Number of unique words\n" +
                                    "3. Frequency of words\n" +
                                    "4. All of the above\n" +
                                    "5. Return to main menu",
                            "1", "2", "3", "4", "5");
                    if (statisticsCommand == null) {
                        break mainMenuLoop;
                    }

                    action_switch:
                    switch (statisticsCommand) {
                        case "1":
                            articleAnalyzer.calculate_statistics(1);
                            break action_switch;
                        case "2":
                            articleAnalyzer.calculate_statistics(2);
                            break action_switch;
                        case "3":
                            articleAnalyzer.calculate_statistics(3);
                            break action_switch;
                        case "4":
                            articleAnalyzer.calculate_statistics(4);
                            break action_switch;
                        case "5":
                            continue mainMenuLoop;
                    }

                    // Allow user to run more statistics on the same article or return to the
                    // previous menu and enter a new article.
                    // Or quit.
                    while (true) {
                        String nextCommand = readChoice(scanner,
                                "\nEnter next action:\n" +
                                        "1. Another statistic on same article\n" +
                                        "2. To a different article\n" +
                                        "3. Return to main menu\n" +
                                        "4. Quit",
                                "1", "2", "3", "4");
                        if (nextCommand == null) {
                            break mainMenuLoop;
                        }

                        switch (nextCommand) {
                            case "1":
                                continue samearticleloop;
                            case "2":
                                continue articleLoop;
                            case "3":
                                continue mainMenuLoop;
                            case "4":
                                break mainMenuLoop;
                        }
                    }
                }
            }
        }
    }

    private static String readChoice(Scanner scanner, String prompt, String... validChoices) {
        while (true) {
            System.out.println(prompt);
            if (!scanner.hasNextLine()) {
                return null;
            }

            String choice = scanner.nextLine().trim();
            for (String validChoice : validChoices) {
                if (choice.equals(validChoice)) {
                    return choice;
                }
            }
            System.out.println("Invalid choice. Enter one of: " +
                    String.join(", ", validChoices) + ".");
        }
    }
}


Project Description:

This project analyzes an article after removing stop words. It reports the total and unique word counts and ranks word frequencies. Words are lowercased before stop-word removal and analysis.

Opening the program runs the Main class. When you run it, press 1 for stats on one article and 2 for stats on all articles. Pressing 2 opens a second menu where you can press 1 for the richest vocabulary, 2 for the ten most frequent words in each article, 3 for positive or negative classification, or 4 to run all three. Choose. Multi-article options analyze the files in src/articles, excluding stopwords.txt in the analysis. Pressing 3 for positive/negative testing subtracts negative-word matches from positive-word matches, and the results are shown. The word lists in src/positiveornegative are lists of basic positive and negative vocabulary.

```mermaid
classDiagram
    class Main {
        +main() throws Exception
        -readChoice(scanner: Scanner, prompt: String, validChoices: String[]): String
    }

    class TextToArray {
        +convertTextToArray(file_name: String): String[] throws IOException
    }

    class ArticleCleanUp {
        -article: String[]
        +ArticleCleanUp(article: String[])
        +clean_article(): ArrayList~String~ throws IOException
    }

    class ArticleAnalysis {
        -article_words: ArrayList~String~
        +ArticleAnalysis(article_words: ArrayList~String~)
        +calculate_statistics(action: int): void throws Exception
        +getUniqueWordCount(): int
        +printTopTenWords(articleName: String): void
    }

    class RichestVocabulary {
        +printRichestVocabulary(): void throws IOException
    }

    class TopTenWords {
        +printTopTenWordsForAllArticles(): void throws IOException
    }

    class PositiveOrNegative {
        +analyzeAllArticles(): void throws IOException
        -loadWords(fileName: String): Set~String~ throws IOException
    }

    Main ..> Scanner : reads menu input
    Main ..> TextToArray : reads selected article
    Main ..> ArticleCleanUp : cleans article words
    Main ..> ArticleAnalysis : analyzes cleaned words and displays statistics
    Main ..> RichestVocabulary : compares all articles
    Main ..> TopTenWords : prints most frequent words in all articles
    Main ..> PositiveOrNegative : classifies all articles

    ArticleCleanUp ..> TextToArray : reads stopwords file
    RichestVocabulary ..> TextToArray : reads article files
    RichestVocabulary ..> ArticleCleanUp : removes stop words
    RichestVocabulary ..> ArticleAnalysis : counts unique words
    TopTenWords ..> TextToArray : reads article files
    TopTenWords ..> ArticleCleanUp : removes stop words
    TopTenWords ..> ArticleAnalysis : ranks word frequencies
    PositiveOrNegative ..> TextToArray : reads article files
    PositiveOrNegative ..> positive.txt : loads positive word list
    PositiveOrNegative ..> negative.txt : loads negative word list
```

## Build and manual testing

From the project root, compile and run:

```powershell
javac -d out src\*.java
java -cp out Main
```

Check these behaviors in the terminal:

1. Enter an invalid menu choice (for example, `x`). The program reports an invalid choice and shows the menu again.
2. Choose opening-menu option `2` and verify the second menu displays the three separate multi-article statistics, an all-three choice, and a return choice.
3. Choose second-menu option `1`, `2`, or `3`. Verify only the selected report is shown. Option `4` should run all three reports, and option `5` should return to the opening menu.
4. Choose opening-menu option `1`, then enter `0` at the article filename prompt. Verify that it returns to the opening menu.
5. Enter `ai.txt`, then choose statistics-menu option `5`. Verify that it returns to the opening menu.
6. Enter a blank or nonexistent article file name. The program reports the problem and prompts for a file again.
7. Enter `ai.txt`, choose frequency statistics, and verify counts are in descending order. Words with matching counts should appear alphabetically.
8. Verify frequency output uses lowercase words and excludes stop words regardless of their capitalization (for example, `The` and `the`).
9. Enter invalid choices in the opening menu, multi-article menu, statistics menu, and next-action menu. Each menu should report the invalid choice and prompt again.
10. Verify next-action choices `2`, `3`, and `4` respectively start a different article, return to the opening menu, and quit.




Previous test screenshots:
<img width="2880" height="1704" alt="Screenshot 2026-10-21 194025" src="https://github.com/user-attachments/assets/40893304-dae8-4bd4-8d05-b6c73f37924c" />
<img width="2880" height="1704" alt="Screenshot 2026-10-21 194041" src="https://github.com/user-attachments/assets/ca8614aa-1b05-43d5-bdeb-ce85085cf57b" />
<img width="2880" height="1704" alt="Screenshot 2026-10-21 194046" src="https://github.com/user-attachments/assets/1445db9d-fa5a-4bf4-9fde-8a393985703b" />
<img width="2880" height="1704" alt="Screenshot 2026-10-21 194117" src="https://github.com/user-attachments/assets/e8eb9385-b8fc-4c25-bde6-34005e886bde" />


Work Completed by Each Group Member

John: Uploaded/found articles, wrote comments, created readme.

Louis: Programmed the main classes.

Milestone 2:

Louis: added the new classes and functionality, such as RichestVocabulary, PositiveOrNegative, and TopTenWords.

John:

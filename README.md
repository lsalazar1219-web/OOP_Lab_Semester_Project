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

Milestone 1 screenshots:
<img width="2880" height="1704" alt="Screenshot 2026-10-21 194025" src="https://github.com/user-attachments/assets/40893304-dae8-4bd4-8d05-b6c73f37924c" />
<img width="2880" height="1704" alt="Screenshot 2026-10-21 194041" src="https://github.com/user-attachments/assets/ca8614aa-1b05-43d5-bdeb-ce85085cf57b" />
<img width="2880" height="1704" alt="Screenshot 2026-10-21 194046" src="https://github.com/user-attachments/assets/1445db9d-fa5a-4bf4-9fde-8a393985703b" />
<img width="2880" height="1704" alt="Screenshot 2026-10-21 194117" src="https://github.com/user-attachments/assets/e8eb9385-b8fc-4c25-bde6-34005e886bde" />


Milestone 2 screenshots:




Work Completed by Each Group Member

John: Uploaded/found articles, wrote comments, created readme.

Louis: Programmed the main classes.

Milestone 2:

Louis: added the new classes and functionality, such as RichestVocabulary, PositiveOrNegative, and TopTenWords.

John:

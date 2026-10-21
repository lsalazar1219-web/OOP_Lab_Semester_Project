Project Description:

This project analyzes a given article and removes a set of stop words and prints the number of words, the number of unique words, and the words that appear most frequently and how often they appear. To use this program please run the main class and enter the name of your desired article (.txt) into the console. You will be directed then with clearly enumerated choices.

```mermaid
classDiagram
    class Main {
        +main() throws Exception
    }

    class TextToArray {
        +convertTextToArray(file_name: String) String[]
    }

    class ArticleCleanUp {
        -article: String[]
        -stop_words: TextToArray
        +ArticleCleanUp(article: String[])
        +clean_article() ArrayList~String~
    }

    class ArticleAnalysis {
        -article_words: ArrayList~String~
        +ArticleAnalysis(article_words: ArrayList~String~)
        +calculate_statistics(action: int) throws Exception
    }

    Main --> TextToArray : uses
    Main --> ArticleCleanUp : creates
    Main --> ArticleAnalysis : creates

    ArticleCleanUp ..> TextToArray : reads stopwords file
    ArticleCleanUp --> ArticleAnalysis : produces cleaned data
```




Test Screenshots:
<img width="2880" height="1704" alt="image" src="https://github.com/user-attachments/assets/1526a152-5eb4-45f9-882b-a82c1754543e" />
<img width="2880" height="1704" alt="image" src="https://github.com/user-attachments/assets/4efb5219-9d1e-408b-b005-4b200a7d6ec7" />
<img width="2880" height="1704" alt="Screenshot 2026-10-21 194046" src="https://github.com/user-attachments/assets/318b1e92-4372-4647-8a3d-3ba70ea4dbf1" />
<img width="2880" height="1704" alt="Screenshot 2026-10-21 194117" src="https://github.com/user-attachments/assets/aa0c6071-233d-4cdb-b818-8c88c8792c0f" />






Work Completed by Each Group Member

John: Uploaded/found articles, wrote comments, created readme.

Louis: Programmed the main classes.

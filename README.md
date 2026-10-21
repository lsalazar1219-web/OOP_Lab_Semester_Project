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
<img width="2880" height="1704" alt="Screenshot 2026-10-21 194025" src="https://github.com/user-attachments/assets/40893304-dae8-4bd4-8d05-b6c73f37924c" />
<img width="2880" height="1704" alt="Screenshot 2026-10-21 194041" src="https://github.com/user-attachments/assets/ca8614aa-1b05-43d5-bdeb-ce85085cf57b" />
<img width="2880" height="1704" alt="Screenshot 2026-10-21 194046" src="https://github.com/user-attachments/assets/1445db9d-fa5a-4bf4-9fde-8a393985703b" />
<img width="2880" height="1704" alt="Screenshot 2026-10-21 194117" src="https://github.com/user-attachments/assets/e8eb9385-b8fc-4c25-bde6-34005e886bde" />


Work Completed by Each Group Member

John: Uploaded/found articles, wrote comments, created readme.

Louis: Programmed the main classes.

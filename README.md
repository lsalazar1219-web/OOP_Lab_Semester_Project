Project Description:

This project analyzes a given article and removes a set of stop words and prints the number of words, the number of unique words, and the words that appear most frequently and how often they appear. To use this program please run the main class and enter the name of your desired article (.txt) into the scanner. 

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
<img width="2588" height="786" alt="image" src="https://github.com/user-attachments/assets/3fccb7ef-2044-403c-a282-58c28bca9258" />
<img width="2528" height="1250" alt="image" src="https://github.com/user-attachments/assets/e45e0d4b-bc31-427f-a979-cf120b38143f" />




Work Completed by Each Group Member

John: Uploaded/found articles,

Louis:

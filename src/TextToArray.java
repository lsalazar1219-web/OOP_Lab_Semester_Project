import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
public class TextToArray {

    public String[] convertTextToArray(String file_name) throws Exception {
        /*
         * This class converts the original text file of an article into a String[] array.
         * Then it returns the array for use by other classes.
         */
        //Establish path
        String path = ("src/articles/" + file_name);

        //Read the entire file content into a single String.
        String fileContent = Files.readString(Path.of(path));

        //Split the string by any whitespace sequence into an array.
        String[] articleWords = fileContent.trim().split(("[\\s.,!?;:\"]+"));

        return articleWords;
    }
}
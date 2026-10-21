import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
public class TextToArray {

    private String file_name;

    public TextToArray(){//String file_name) {

        //this.file_name = file_name;
    }


    public String[] convertTextToArray(String file_name) throws Exception {
        //Establish path
        String path = ("src/articles/" + file_name);

        //Read the entire file content into a single String
        String fileContent = Files.readString(Path.of(path));

        //Split the string by any whitespace sequence into an array
        String[] articleWords = fileContent.trim().split(("[\\s.,!?;:\"]+"));

        return articleWords;
    }
}
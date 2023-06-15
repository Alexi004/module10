package task3;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WordsFile {
    public static void main(String[] args) {
        String fileName = "words.txt";
        createWordsFile(fileName);
    }

    public static void createWordsFile(String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println("the day is sunny the the");
            writer.println("the sunny is is");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}







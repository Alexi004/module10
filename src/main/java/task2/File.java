package task2;

import java.io.FileWriter;
import java.io.IOException;

public class File {
    public static void main(String[] args) {
        String content = "name age\nalice 21\nryan 30";

        try (FileWriter writer = new FileWriter("C:\\Users\\Dell\\IdeaProjects\\module10\\file.txt")) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
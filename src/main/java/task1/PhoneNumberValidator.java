package task1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
public class PhoneNumberValidator {

    public static void main(String[] args){
        String fileName = "C:/file.txt";
        Object validatePhoneNumbers;
        validatePhoneNumbers(fileName);
    }

    public static void validatePhoneNumbers(String fileName){
        try {
            List<String>  lines = Files.readAllLines(Paths.get(fileName));
            for (String line : lines){
                if (isVaildFileNumber(line)){
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
    public static boolean isVaildFileNumber(String phoneNumber){
        return phoneNumber.matches("\\(\\d{3}\\) \\d{3}-\\d{4}|\\d{3}-\\d{3}-\\d{4}");
    }
}

package task2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static class User {
        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();

        // Читання файлу file.txt
        try (BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
            String line;
            boolean isFirstLine = true;

            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue; // Пропустити перший рядок (заголовок)
                }

                String[] values = line.split(" ");

                String name = values[0];
                int age = Integer.parseInt(values[1]);

                User user = new User(name, age);
                userList.add(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Запис у файл user.json
        try (FileWriter writer = new FileWriter("user.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(userList);
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
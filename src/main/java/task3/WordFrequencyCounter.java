package task3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordFrequencyCounter {

    public static void main(String[] args) {

        String fileName = "C:\\Users\\Dell\\IdeaProjects\\module10\\words.txt";

        // Викликаємо метод для розрахунку частоти слів
        Map<String, Integer> wordFrequencyMap = calculateWordFrequency(fileName);

        // Викликаємо метод для виводу результату
        printWordFrequencies(wordFrequencyMap);
    }

    public static Map<String, Integer> calculateWordFrequency(String fileName) {
        // Створюємо словник для збереження частоти слів
        Map<String, Integer> wordFrequencyMap = new HashMap<>();

        try {
            // Створюємо об'єкт файлу
            File file = new File(fileName);

            // Створюємо об'єкт Scanner для читання файлу
            Scanner scanner = new Scanner(file);

            // Читаємо файл по словам
            while (scanner.hasNext()) {
                String word = scanner.next();

                // Оновлюємо частоту слова в словнику
                wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
            }

            // Закриваємо Scanner
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Повертаємо словник з частотою слів
        return wordFrequencyMap;
    }

    public static void printWordFrequencies(Map<String, Integer> wordFrequencyMap) {
        // Створюємо TreeMap для сортування словників за частотою
        Map<String, Integer> sortedMap = new TreeMap<>((w1, w2) -> {
            int freqComparison = wordFrequencyMap.get(w2).compareTo(wordFrequencyMap.get(w1));
            if (freqComparison == 0) {
                return w1.compareTo(w2);
            }
            return freqComparison;
        });

        // Додаємо всі записи зі словника wordFrequencyMap в відсортований TreeMap
        sortedMap.putAll(wordFrequencyMap);

        // Виводимо результат
        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
package ru.sladkov.task5.utility;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;


public class HandlersUtility {

    public static Map<String, Integer> putWordsInMap(
            Map<String, Integer> mapOfWords, String stringOfWords) {
        String[] words = stringOfWords
                .toLowerCase()
                .split(" ");
        for (String word:words) {
            if (mapOfWords.containsKey(word)) {
                mapOfWords.put(word, mapOfWords.get(word) + 1);
            } else {
                mapOfWords.put(word, 1);
            }
        }
        return mapOfWords;
    }

    public static void sortAndPrint(Map<String, Integer> mapOfWords) {
        ArrayList<Map.Entry<String, Integer>> listWithWords =
                new ArrayList<>(mapOfWords.entrySet());
        listWithWords
                .sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        for (int i = 0; i < 10; i++) {
            Map.Entry currentWord = listWithWords.get(i);
            System.out.println("Слово \"" + currentWord.getKey() +
                    "\" встретилось " + currentWord.getValue() + " раз");
        }
    }
}

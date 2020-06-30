package ru.sladkov.task5.utility;

import org.osgi.service.component.annotations.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;

@Component
public class HandlersUtility {

    public HandlersUtility() {

    }

    public static Map<String, Integer> putWordsInMap(Map<String, Integer> mapOfWords, String stringOfWords) {
        try {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mapOfWords;
    }

    public static void sortAndPrint(Map<String, Integer> mapOfWords) {
        ArrayList<Map.Entry<String, Integer>> listWithWords = new ArrayList<>(mapOfWords.entrySet());
        listWithWords.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        for (int i = 0; i < 10; i++) {
            Map.Entry currentWord = listWithWords.get(i);
            System.out.println("Слово \"" + currentWord.getKey() + "\" встретилось " + currentWord.getValue() + " раз");
        }
    }

    public static Map<String, Integer> mergeMaps(Map<String, Integer> mapMergeTo, Map<String, Integer> mapMergeFrom) {
        for (Map.Entry currEntry:mapMergeFrom.entrySet()) {
            String key = (String) currEntry.getKey();
            Integer value = (Integer) currEntry.getValue();
            if (mapMergeTo.containsKey(key)) {
                mapMergeTo.put(key, mapMergeTo.get(key) + value);
            } else {
                mapMergeTo.put(key, value);
            }
        }
        return mapMergeTo;
    }
}

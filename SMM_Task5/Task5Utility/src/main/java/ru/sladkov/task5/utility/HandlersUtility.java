package ru.sladkov.task5.utility;

import org.osgi.service.component.annotations.Component;

import java.util.*;


@Component
public class HandlersUtility {

    public static int WORDS_TO_DISPLAY = 10;
    public static int WORDS_LENGTH_LOWER_LIMIT = 2;

    public HandlersUtility() {

    }

    public static Map<String, Integer> putWordsInMap(Map<String, Integer> mapOfWords, String stringOfWords) {
        try {
            String[] words = stringOfWords
                    .toLowerCase()
                    .split(" ");
            for (String word:words) {
                if (word.length() > WORDS_LENGTH_LOWER_LIMIT)
                {
                    if (mapOfWords.containsKey(word)) {
                        mapOfWords.put(word, mapOfWords.get(word) + 1);
                    } else {
                        mapOfWords.put(word, 1);
                    }
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
        for (int i = 0; i < WORDS_TO_DISPLAY; i++) {
            Map.Entry currentWord = listWithWords.get(i);
            System.out.println("Слово \"" + currentWord.getKey() + "\" встретилось " + currentWord.getValue() + " раз");
        }
    }

    public static Map<String, Integer> mergeMaps(List<Map<String, Integer>> listOfMaps) {
        Map<String, Integer> finalMap = new HashMap();
        for (Map<String, Integer> currmap: listOfMaps) {
            for (Map.Entry currEntry: currmap.entrySet()) {
                    String key = (String) currEntry.getKey();
                    Integer value = (Integer) currEntry.getValue();
                    if (finalMap.containsKey(key)) {
                        finalMap.put(key, finalMap.get(key) + value);
                } else {
                    finalMap.put(key, value);
                }
            }
        }
        return finalMap;
    }
}

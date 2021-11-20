//package assignment10;

/*
 *
 * Name: WordTypeCount.java
 * Purpose: Uses Maps to determine the number of
 *          times a word appears
 * Author: grivera64
 * Date: 11/24/2021
 *
 */

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.Scanner;

public class WordTypeCount {

    public static final Scanner keyboard = new Scanner(System.in);

    private static void createMap(Map<String, Integer> myMap) {

        String setOfWords, tempWord;
        String[] tokens;

        System.out.println("Enter a string:");
        setOfWords = WordTypeCount.keyboard.nextLine();
        tokens = setOfWords.split(" ");

        for (String element : tokens) {

            if (element.isBlank() || element.isEmpty()) {

                continue;

            }

            tempWord = element.toLowerCase();

            if (myMap.containsKey(tempWord)) {

                myMap.put(tempWord, myMap.get(tempWord) + 1);

            } else {

                myMap.put(tempWord, 1);

            }

        }

    }

    private static void displayMap(Map<String, Integer> myMap) {

        Set<String> keys = myMap.keySet();
        Set<String> sortedKeys = new TreeSet<>(keys);

        System.out.println("\nMap contains:");
        System.out.printf("%-16s%s\n", "Key", "Value");

        for (String key : sortedKeys) {

            System.out.printf("%-16s%2d\n", key, myMap.get(key));

        }

        System.out.printf("\nsize: %d\nisEmpty: %s\n", myMap.size(), myMap.isEmpty());

    }

    public static void main(String[] args) {

        Map<String, Integer> myMap = new HashMap<>();

        WordTypeCount.createMap(myMap);
        WordTypeCount.displayMap(myMap);

    }

}

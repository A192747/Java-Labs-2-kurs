package com.example.Lab5.Methods;

import java.util.*;
import java.util.stream.Collectors;

public class Methods {
    public static double average(List<Integer> list) {
        return list.stream()
                .mapToInt(Integer::intValue)
                .summaryStatistics()
                .getAverage();
    }

    public static List<String> strToUpperNew(List<String> list) {
        return list.stream()
                .map(String::toUpperCase)
                .map(str -> "_new_" + str)
                .toList();
    }
    public static List<Integer> uniqSquares(List<Integer> list) {
        return list.stream()
                .filter(num -> Collections.frequency(list, num) == 1)
                .map(num -> num * num)
                .toList();
    }
    public static List<String> firstLetterStrSort(List<String> list, char letter) {
        return list.stream()
                .filter(str -> str.charAt(0) == letter)
                .sorted()
                .toList();
    }
    public static <T> T lastElement(Collection<T> collection) {
        return collection.stream()
                .skip(collection.size() > 0 ? collection.size() - 1 : 0)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Collection is empty!"));
    }

    public static int numsEven(int[] a) {
        return Arrays.stream(a)
                .filter(num -> num % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static Map<Character, String> stringToMap(List<String> list) {
        return list.stream()
                .collect(Collectors.toMap(str -> str.charAt(0), str -> str.substring(1)));
    }
}

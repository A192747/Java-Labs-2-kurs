package com.example.Lab4.Translator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Matcher;
import com.example.Lab4.Exceptions.*;
import java.util.regex.Pattern;

public class Translator {

    // Словарь
    private HashMap<String, String> dictionary;
    private int maxLength = 0;

    private ArrayList<String> containsArray;

    public static int wordsCount(String str) {
        int count = 0;
        int index = 0;
        String target = " ";
        while ((index = str.indexOf(target, index)) != -1) {
            count++;
            index += target.length();
        }
        return count + 1;
    }


    public Translator(String fileName) throws InvalidFileFormatException, FileReadException {
        this.dictionary = new HashMap<String, String>();
        File file = new File(fileName);

        // Проверяем формат файла
        if (!fileName.endsWith(".txt")) {
            throw new InvalidFileFormatException("Invalid file format, expected .txt");
        }

        // Читаем файл со словарём
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\s\\|\s");
                if (parts.length != 2) {
                    throw new InvalidFileFormatException("Invalid file format");
                }

                dictionary.put(parts[0].trim().toLowerCase(), parts[1].trim());
                maxLength = Math.max(wordsCount(parts[0]), maxLength);
            }
        } catch (IOException e) {
            throw new FileReadException("Cannot read file " + fileName);
        }
    }

    private int findIndexOfFirstSymbol(String str) {
        String elem;
        Pattern pattern = Pattern.compile("[a-zA-Z]");
        Pattern patternSpace = Pattern.compile("\s");

        for (int i = 0; i < str.length(); i++) {
            elem = String.valueOf(str.charAt(i));
            Matcher matcherSpace = patternSpace.matcher(elem);
            Matcher matcher = pattern.matcher(elem);
            if (!(matcher.find() || matcherSpace.find()))
                return i;

        }
        return -1;
    }

    private int isStrSubstr(String str) {
        int counter = 0;
        String tempStr = str;
        containsArray = new ArrayList<>();
        if (findIndexOfFirstSymbol(tempStr) != -1) {
            tempStr = tempStr.substring(0, findIndexOfFirstSymbol(tempStr));
        }
        for (HashMap.Entry<String, String> entry : dictionary.entrySet()) {
            if (entry.getKey().contains(tempStr)) {
                counter++;
                containsArray.add(entry.getKey());
            }
        }
        return counter;
    }
    private StringBuilder translateLine(ArrayList<String> arr) {
        int counter = 0;
        int index = 0;
        int numberOfWords = 0;
        String maxLengthTranslate = "";
        String resultLine = null;
        char elem = 0;
        StringBuilder translatedLine = new StringBuilder();
        while(index != arr.size()) {
            if (isStrSubstr(arr.get(index)) == 0) {
                translatedLine.append(arr.get(index)).append(" ");
                index++;
            } else {
                //find max str with translate
                String tempLine = "";
                maxLengthTranslate = "";
                counter = 0;
                numberOfWords = 0;
                for(int i = 0; i < maxLength; i++) {
                    if(i > 0)
                        tempLine += " ";
                    tempLine += arr.get(index + i);
                    numberOfWords++;
                    elem = 0;
                    if(findIndexOfFirstSymbol(tempLine) != -1) {
                        elem = tempLine.charAt(findIndexOfFirstSymbol(tempLine));
                        i = maxLength;
                        resultLine = tempLine;
                        tempLine = tempLine.substring(0, findIndexOfFirstSymbol(tempLine));
                    }
                    for (String s : containsArray) {
                        if (s.equals(tempLine)) {
                            maxLengthTranslate = s;
                            counter = numberOfWords;
                        }
                    }
                }
                if("".equals(maxLengthTranslate)) {
                    translatedLine.append(arr.get(index));
                    index++;
                } else {
                    translatedLine.append(translateWord(maxLengthTranslate));
                    index += counter;
                }
                if(elem != 0) {
                    if(resultLine.substring(0, resultLine.length() - 1).equals(maxLengthTranslate))
                        translatedLine.append(elem);
                }
                translatedLine.append(" ");
            }
        }
        return translatedLine;
    }

    private String translateWord(String word) {
        String lowerCaseWord = word.toLowerCase();

        if (dictionary.containsKey(lowerCaseWord)) {
            if(findIndexOfFirstSymbol(lowerCaseWord) != -1)
                return dictionary.get(lowerCaseWord) + lowerCaseWord.charAt(findIndexOfFirstSymbol(lowerCaseWord));
            return dictionary.get(lowerCaseWord);
        }
        else {
            return word;
        }
    }

    public String translateFile(String fileName) throws FileReadException {
        File file = new File(fileName);
        StringBuilder result = new StringBuilder();

        // Читаем входной файл
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            ArrayList<String> arr;
            while ((line = reader.readLine()) != null) {
                StringBuilder translatedLine;
                arr = new ArrayList<>(Arrays.asList(line.trim().split("\s+")));
                translatedLine = translateLine(arr);
                result.append(translatedLine.toString().trim()).append("\n");
            }
        } catch (IOException e) {
            throw new FileReadException("Cannot read file " + fileName);
        }
        return result.toString();
    }
}

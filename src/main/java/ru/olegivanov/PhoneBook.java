package ru.olegivanov;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class PhoneBook {
    private static Map<String, Integer> phones = new HashMap<>();

    public int add(String name, int number) {
        if (!phones.containsKey(name)) {
            phones.put(name, number);
            return phones.size();
        }
        return 0;
    }

    public String findByNumber(int number) {
        if (phones.containsValue(number)) {
            String key = phones.entrySet().stream()
                    .filter(entry -> entry.getValue().equals(number))
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList()).toString()
                    .replace("[", "")  //remove the right bracket
                    .replace("]", "")  //remove the left bracket
                    .trim();
            return key;
        }
        return null;
    }
}

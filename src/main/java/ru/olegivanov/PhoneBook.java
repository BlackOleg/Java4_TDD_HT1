package ru.olegivanov;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private static Map<String,Integer> phones = new HashMap<>();
    public int add(String name, int number) {
        if (!phones.containsKey(name)) {
            phones.put(name, number);
            return phones.size();
        }
        return 0;
    }
}

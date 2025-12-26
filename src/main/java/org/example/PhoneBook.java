package org.example;
import java.util.*;
// Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и телефонных номеров.
public class PhoneBook {
   private final Map<String, List<String>> phoneBook = new HashMap<>();

       public void add(String surname, String number) {
            if (!phoneBook.containsKey(surname)) {
                phoneBook.put(surname, new ArrayList<>());
            }

          phoneBook.get(surname).add(number);
        }

        public List<String> get(String surname) {
            return phoneBook.getOrDefault(surname, Collections.emptyList());
        }
    }


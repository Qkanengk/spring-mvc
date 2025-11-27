package com.codegym.spring_dictionary.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DictionaryRepository implements IDictionaryRepository {
   private static Map<String, String> dictionary = HashMap.newHashMap(10);
   static {
       dictionary.put("hello", "xin chao");
       dictionary.put("bye", "tam biet");
       dictionary.put("hi", "chao ban");
       dictionary.put("thank you", "cam on");
       dictionary.put("goodbye", "tam biet");
   }

    @Override
    public String findWord(String word) {
        return dictionary.get(word);
    }
}

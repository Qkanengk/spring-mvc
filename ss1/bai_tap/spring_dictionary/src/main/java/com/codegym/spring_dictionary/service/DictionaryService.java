package com.codegym.spring_dictionary.service;

import com.codegym.spring_dictionary.repository.IDictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryService implements IDictionaryService {
    @Autowired
    private IDictionaryRepository dictionaryRepository;

    @Override
    public String findWord(String word) {
        return dictionaryRepository.findWord(word);
    }
}

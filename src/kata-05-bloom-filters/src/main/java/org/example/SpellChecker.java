package org.example;

import lombok.extern.slf4j.Slf4j;
import org.example.util.Constants;
import org.example.util.ResourceReader;

import java.util.stream.Stream;

@Slf4j
public class SpellChecker {

    public SpellChecker() {
        populate();
    }

    private void populate() {
        Object[] words = ResourceReader.read(Constants.WORDLIST_RESOURCE);
        Stream.of(words).limit(50).forEach(w -> log.info("Word: {} Hash: {}", w, w.hashCode()));
    }
}

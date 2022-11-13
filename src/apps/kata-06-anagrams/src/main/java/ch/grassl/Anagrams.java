package ch.grassl;

import ch.grassl.file.ResourceReader;
import ch.grassl.util.Constants;
import ch.grassl.util.Utility;
import lombok.Getter;

import java.util.*;

public class Anagrams {

    @Getter
    private final String[] wordList;
    private final Map<String, List<String>> map = new HashMap<>();

    public Anagrams() {
        wordList = ResourceReader.of(Constants.WORDLIST_RESOURCE).read();
        init();
    }

    public List<String> getAnagrams() {
        return format(map);
    }

    public String biggestSet() {
        List<String> biggest = Collections.emptyList();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getValue().size() > biggest.size()) {
                biggest = entry.getValue();
            }
        }
        return String.join(" ", biggest);
    }

    public String longestSet() {
        String longest = "";
        for (String word : map.keySet()){
            if (map.get(word).size() > 1 && word.length() > longest.length()) {
                longest = word;
            }
        }
        return String.join(" ", map.get(longest));
    }

    private void init() {
        for (String word : wordList) {
            populate(word);
        }
        format(map);
    }

    private void populate(String word) {
        String sortedWord = Utility.sort(word);
        if (map.containsKey(sortedWord)) {
            map.get(sortedWord).add(word);
        } else {
            map.put(sortedWord, new ArrayList<>(List.of(word)));
        }
    }

    private static List<String> format(Map<String, List<String>> anagrams) {
        return anagrams.values().stream()
                .filter(a -> a.size() > 1)
                .map(a -> String.join(" ", a))
                .toList();
    }
}

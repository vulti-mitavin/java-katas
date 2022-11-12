package org.example;

import ch.grassl.file.ResourceReader;
import lombok.extern.slf4j.Slf4j;
import org.example.util.Constants;
import org.example.util.Utility;

@Slf4j
public class Dictionary {

    private final boolean[] bitmap;

    public Dictionary() {
        bitmap = Utility.getBitMap(Constants.BIT_ARRAY_SIZE);
        filter();
    }

    public boolean contains(String word) {
        int[] indices = Utility.createIndices(Constants.HASH_FUNCTIONS, word);
        for (int index : indices) {
            if (!bitmap[index]) {
                return false;
            }
        }
        return true;
    }

    private void filter() {
        Object[] words = ResourceReader.read(Constants.WORDLIST_RESOURCE);
        for (Object word : words) {
            int[] indices = Utility.createIndices(Constants.HASH_FUNCTIONS, (String) word);
            for (int index : indices) {
                bitmap[index] = true;
            }
        }
    }
}

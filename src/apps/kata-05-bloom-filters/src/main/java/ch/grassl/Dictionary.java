package ch.grassl;

import ch.grassl.file.ResourceReader;
import ch.grassl.util.Constants;
import ch.grassl.util.Utility;
import lombok.extern.slf4j.Slf4j;

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
        String[] words = ResourceReader.of(Constants.WORDLIST_RESOURCE).read();
        for (String word : words) {
            int[] indices = Utility.createIndices(Constants.HASH_FUNCTIONS, word);
            for (int index : indices) {
                bitmap[index] = true;
            }
        }
    }
}

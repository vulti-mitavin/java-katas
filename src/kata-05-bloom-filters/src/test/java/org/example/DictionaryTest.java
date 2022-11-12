package org.example;

import ch.grassl.file.ResourceReader;
import org.example.util.Constants;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DictionaryTest {

    public static final String[] WORDS = {"sfjpo2q3tpqehr98gdev", "ü0jvsajvdsaöljfp0t",
            "üjr0jdölvakvoi4h3pfa", "lskjfwj3ro2ij3r", "32oi4poüpuv0uewr",
            "welkjrr3232", "324324wer", "üpi3tü0ure0gugq3ö4jf",
            "i3u092u4", "5457858", "123123213123123",
            "xchewhjf3iu", "cpvu090we", "fkjewf3q",
            "welkjrr3232", "324324wer", "üpi3tü0ure0gugq3ö4jf",
            "ölajewpr23ur409294uwlfd", "309468ewrgegw", "4309853jg039rgf",
            "pug 09u0ß9430ßu43g98 lreg", "jshf2h3trh432r"};

    private final Dictionary dictionary = new Dictionary();

    @Test
    void testDictionary_falsePositiveThreshhold() {
        int falsePositive = 0;
        for (String word : WORDS) {
            if (dictionary.contains(word)) {
                falsePositive++;
            }
        }

        double falsePositiveRate = falsePositive / (double) WORDS.length;
        double falsePositiveThreshhold = 0.3;
        assertTrue(falsePositiveRate <= falsePositiveThreshhold,
                String.format("False positive rate %s greater than %s!", falsePositiveRate, falsePositiveThreshhold));
    }

    @Test
    void testDictionary_noFalseNegative() {
        Object[] wordList = ResourceReader.read(Constants.WORDLIST_RESOURCE);

        List<String> negatives = new ArrayList<>();
        for (String word : WORDS) {
            if (!dictionary.contains(word)) {
                negatives.add(word);
            }
        }

        for (Object word : wordList) {
            assertFalse(negatives.contains((String) word));
        }
    }
}
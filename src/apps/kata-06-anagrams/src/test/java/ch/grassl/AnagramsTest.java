package ch.grassl;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnagramsTest {

    private final Anagrams anagrams = new Anagrams();

    @Test
    void testWordList() {
        assertTrue(anagrams.getWordList().length > 0);
    }

    @Test
    void testAnagrams() {
        List<String> anagrams = this.anagrams.getAnagrams();
        assertTrue(anagrams.size() > 0);
    }

    @Test
    void testAnagramsBiggestSet() {
        assertEquals("alerts alters artels estral laster rastle ratels salter slater staler stelar talers tarsel",
                this.anagrams.biggestSet());
    }

    @Test
    void testAnagramsLongestSet() {
        assertEquals("acoustoelectrically electroacoustically",
                this.anagrams.longestSet());
    }

    @Test
    void testAnagramsSpeed() {
        Instant i1 = Instant.now();
        this.anagrams.getAnagrams();
        Instant i2 = Instant.now();
        assertTrue(Duration.between(i1, i2).toMillis() <= 1000);
    }
}
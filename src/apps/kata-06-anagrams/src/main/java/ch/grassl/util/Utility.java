package ch.grassl.util;

import lombok.experimental.UtilityClass;

import java.util.Arrays;

@UtilityClass
public class Utility {

    public static String sort(String candidate) {
        char[] chars = candidate.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}

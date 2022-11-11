package org.example.util;

import lombok.experimental.UtilityClass;

import java.util.Arrays;

@UtilityClass
public class Utility {

    public static boolean[] getBitArray(int size) {
        boolean[] bits = new boolean[size];
        Arrays.fill(bits, false);
        return bits;
    }
}

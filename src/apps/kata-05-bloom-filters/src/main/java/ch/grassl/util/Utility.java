package ch.grassl.util;

import lombok.experimental.UtilityClass;

import java.util.Arrays;

@UtilityClass
public class Utility {

    public static boolean[] getBitMap(int size) {
        boolean[] bits = new boolean[size];
        Arrays.fill(bits, false);
        return bits;
    }

    public static int[] createIndices(int hashFunctions, String val) {
        StringBuilder salt = new StringBuilder(Constants.DEFAULT_SALT);
        int[] indices = new int[hashFunctions];
        for (int i = 0; i < indices.length; i++) {
            int hashCode = (val + salt).hashCode();
            indices[i] = getIndex(hashCode);
            salt.append(hashCode).append(val).append(Constants.DEFAULT_SALT);
        }
        return indices;
    }

    private static int getIndex(int hash) {
        hash = Math.abs(hash);
        while (hash >= Constants.BIT_ARRAY_SIZE) {
            hash /= 10;
        }
        return hash;
    }
}

package org.example.util;

import lombok.experimental.UtilityClass;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.Arrays;

@UtilityClass
public class Utility {

    public static boolean[] getBitMap(int size) {
        boolean[] bits = new boolean[size];
        Arrays.fill(bits, false);
        return bits;
    }

    public static String getMd5HashValue(String val) {
        return getMd5HashValue(val, Constants.DEFAULT_SALT);
    }

    public static String getMd5HashValue(String val, String salt) {
        if (val != null) {
            return DigestUtils.md5Hex(val + salt).toUpperCase();
        } else {
            throw new IllegalArgumentException("Error calculating MD5 hash value. Input must not be null.");
        }
    }

    public static int[] createIndices(int hashFunctions, String val) {
        StringBuilder salt = new StringBuilder(Constants.DEFAULT_SALT);
        int[] indices = new int[hashFunctions];
        for (int i = 0; i < indices.length; i++) {
            String hash = getMd5HashValue(val, salt.toString());
            int index = getIndex(hash);
            indices[i] = index;
            salt.append(hash).append(val).append(Constants.DEFAULT_SALT);
        }
        return indices;
    }

    private static int getIndex(String hash) {
        return Integer.parseInt(hash.substring(0, Constants.NUMBER_OF_BYTES_FROM_HASH), 16);
    }
}

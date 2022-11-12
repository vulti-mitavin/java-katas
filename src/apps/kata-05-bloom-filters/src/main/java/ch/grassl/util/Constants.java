package ch.grassl.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Constants {
    public static final String WORDLIST_RESOURCE = "/wordlist.txt";
    public static final String DEFAULT_SALT = "";
    public static final int HASH_FUNCTIONS = 5;
    public static final int BIT_ARRAY_SIZE = (int) Math.pow(10, 6);
}

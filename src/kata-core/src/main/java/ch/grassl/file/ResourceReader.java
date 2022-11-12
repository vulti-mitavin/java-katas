package ch.grassl.file;

import lombok.experimental.UtilityClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@UtilityClass
public class ResourceReader {

    private static InputStream in;

    public static Object[] read(String resource) {
        in = ResourceReader.class.getResourceAsStream(resource);
        return readLines();
    }

    private static Object[] readLines() {
        if (in != null) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
                return br.lines().toArray();
            } catch (IOException e) {
                return new String[0];
            }
        } else {
            return new String[0];
        }
    }
}

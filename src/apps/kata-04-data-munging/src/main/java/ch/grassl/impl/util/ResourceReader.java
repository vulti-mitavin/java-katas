package ch.grassl.impl.util;

import ch.grassl.impl.importer.AbstractDataImporter;
import lombok.experimental.UtilityClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@UtilityClass
public class ResourceReader {

    private static final int NOT_SPECIFIED = -1;

    private static InputStream in;
    private static int from;
    private static int to;

    public static List<String[]> read(String resource) {
        return read(resource, NOT_SPECIFIED, NOT_SPECIFIED);
    }

    public static List<String[]> read(String resource, int fromColumn) {
        return read(resource, fromColumn, NOT_SPECIFIED);
    }

    public static List<String[]> read(String resource, int fromColumn, int toColumn) {
        in = AbstractDataImporter.class.getResourceAsStream(resource);
        from = fromColumn;
        to = toColumn;
        return readLines();
    }

    private static List<String[]> readLines() {
        if (in != null) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
                return mapLinesToArray(br);
            } catch (IOException e) {
                return Collections.emptyList();
            }
        } else {
            return Collections.emptyList();
        }
    }

    /**
     * Maps String lines from a resource stream to arrays. It filters empty lines and cuts the arrays to
     * the desired indices.
     *
     * @param br The resource stream
     * @return Array of lines from the resource stream
     */
    private static List<String[]> mapLinesToArray(BufferedReader br) {
        return br.lines()
                .skip(Constants.DATA_LINES_START)
                .map(String::trim)
                .map(l -> l.split("[ -]+"))
                .filter(arr -> arr.length > 1)
                .map(ResourceReader::cutArray)
                .toList();
    }

    private static String[] cutArray(String[] arr) {
        if (from < NOT_SPECIFIED || from >= arr.length) {
            throw new IllegalArgumentException(String.format("From column '%d' must not be larger or smaller than line" +
                            " array length '%d'.", from, arr.length));
        }
        if (to < NOT_SPECIFIED || to >= arr.length) {
            throw new IllegalArgumentException(String.format("From column '%d' must not be larger or smaller than line" +
                            " array length '%d'.", to, arr.length));
        }
        return Arrays.copyOfRange(arr, from == NOT_SPECIFIED ? 0 : from, to == NOT_SPECIFIED ? arr.length : to);
    }
}

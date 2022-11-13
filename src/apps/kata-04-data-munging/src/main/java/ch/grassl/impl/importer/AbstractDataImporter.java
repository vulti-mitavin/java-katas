package ch.grassl.impl.importer;

import ch.grassl.file.ResourceReader;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Slf4j
public abstract class AbstractDataImporter<T> {

    private static final int NOT_SPECIFIED = -1;
    private static final boolean SKIP_HEADER = true;
    public static final String SPLIT_REGEX = "[ -]+";

    private List<String[]> rawData;
    private final int fromColumn;
    private final int toColumn;

    AbstractDataImporter() {
        this(NOT_SPECIFIED, NOT_SPECIFIED);
    }

    AbstractDataImporter(int fromCoulmn, int toColumn) {
        this.fromColumn = fromCoulmn;
        this.toColumn = toColumn;
    }

    public abstract T map(String[] line);

    public List<T> importData(String resource) {
        List<T> data = new ArrayList<>();
        String[] lines = ResourceReader.of(resource).read();
        rawData = mapLinesToArrays(lines);
        populate(data);
        return data;
    }

    /**
     * Maps String lines from a resource stream to arrays. It filters empty lines and cuts the arrays to
     * the desired indices.
     *
     * @param lines The imported data in form of a String array
     * @return Array of lines from the imported data
     */
    private List<String[]> mapLinesToArrays(String[] lines) {
        return Stream.of(lines)
                .skip(SKIP_HEADER ? 1 : 0)
                .map(this::splitString)
                .filter(this::isNotEmpty)
                .map(this::cutArray)
                .toList();
    }

    private String[] splitString(String line) {
        return line.trim().split(SPLIT_REGEX);
    }

    private boolean isNotEmpty(String[] arr) {
        return arr.length > 1;
    }

    private String[] cutArray(String[] arr) {
        if (fromColumn < NOT_SPECIFIED || fromColumn >= arr.length) {
            throw new IllegalArgumentException(String.format("From column '%d' must not be larger or smaller than line" +
                    " array length '%d'.", fromColumn, arr.length));
        }
        if (toColumn < NOT_SPECIFIED || toColumn >= arr.length) {
            throw new IllegalArgumentException(String.format("From column '%d' must not be larger or smaller than line" +
                    " array length '%d'.", toColumn, arr.length));
        }
        return Arrays.copyOfRange(arr,
                fromColumn == NOT_SPECIFIED ? 0 : fromColumn, toColumn == NOT_SPECIFIED ? arr.length : toColumn);
    }

    private void populate(List<T> data) {
        for (String[] rawDatum : rawData) {
            try {
                data.add(
                        map(rawDatum)
                );
            } catch (IllegalArgumentException e) {
                log.error("Error mapping line {} to {}: {}", rawDatum, data.get(0).getClass(), e.getMessage());
            }
        }
    }
}

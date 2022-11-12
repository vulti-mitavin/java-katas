package ch.grassl.impl.importer;

import lombok.extern.slf4j.Slf4j;
import ch.grassl.impl.util.ResourceReader;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public abstract class AbstractDataImporter<T> {

    private List<String[]> rawData;
    private final int fromColumn;
    private final int toColumn;

    AbstractDataImporter(int fromCoulmn, int toColumn) {
        this.fromColumn = fromCoulmn;
        this.toColumn = toColumn;
    }

    public List<T> importData(String resource) {
        List<T> data = new ArrayList<>();
        rawData = ResourceReader.read(resource, fromColumn, toColumn);
        populate(data);
        return data;
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

    public abstract T map(String[] line);
}

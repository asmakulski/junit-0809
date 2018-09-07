package pl.codeleak.samples.unit_testing.product;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

class CsvReader<T> {

    private static final String SEPARATOR = ";";

    List<T> readAll(Reader source, Function<String[], T> mapper) {

        if (source == null) {
            throw new RuntimeException("source may not be null!");
        }

        try (BufferedReader reader = new BufferedReader(source)) {
            return reader.lines()
                         .map(line -> line.split(SEPARATOR))
                         .map(mapper)
                         .collect(Collectors.toList());
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}

package pl.codeleak.samples.unit_testing.product;

import java.io.Reader;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

class CsvProductRepository implements ProductRepository {

    private final CsvReader<Product> csvProductReader;
    private final Reader source;

    CsvProductRepository(CsvReader<Product> csvProductReader, Reader source) {
        this.csvProductReader = csvProductReader;
        this.source = source;
    }

    @Override
    public List<Product> findAllProducts() {
        Function<String[], Product> mapper =
            rawRecord -> Product.builder()
                                .withName(rawRecord[0])
                                .withCategory(rawRecord[1])
                                .withPrice(new BigDecimal(rawRecord[2]))
                                .build();

        return csvProductReader.readAll(source, mapper);
    }

    @Override
    public Optional<Product> findByName(String name) {
        return findAllProducts()
            .stream()
            .filter(p -> name.equals(p.getName())).findFirst();
    }

    @Override
    public void save(Product product) {
        throw new RuntimeException("Not implemented");
    }
}

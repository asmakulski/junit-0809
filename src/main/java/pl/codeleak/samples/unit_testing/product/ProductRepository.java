package pl.codeleak.samples.unit_testing.product;

import java.util.List;
import java.util.Optional;

interface ProductRepository {

    List<Product> findAllProducts();

    void save(Product product);

    Optional<Product> findByName(String name);

}

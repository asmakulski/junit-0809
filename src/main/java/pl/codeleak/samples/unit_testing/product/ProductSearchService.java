package pl.codeleak.samples.unit_testing.product;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class ProductSearchService {

    private final ProductRepository productRepository;

    ProductSearchService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    List<Product> getProducts(ProductSearchCriteria productSearchCriteria) {
        if (!productSearchCriteria.isValid()) {
            throw new IllegalArgumentException("at least one search criteria must be specified");
        }

        List<Product> allProducts = getProducts();
        return allProducts
            .stream()
            .filter(productSearchCriteria.toPredicate())
            .collect(Collectors.toList());
    }

    Map<String, List<Product>> getProductCategories(ProductSearchCriteria productSearchCriteria) {
        List<Product> allProducts = getProducts(productSearchCriteria);
        return allProducts
            .stream()
            .collect(Collectors.groupingBy(Product::getCategory));
    }

    private List<Product> getProducts() {
        List<Product> allProducts = productRepository.findAllProducts();
        if (allProducts == null || allProducts.isEmpty()) {
            throw new RuntimeException("no products found");
        }
        return allProducts;
    }
}

package pl.codeleak.samples.unit_testing.product;

import java.math.BigDecimal;

class ProductSaveService {

    private final ProductRepository productRepository;
    private final ProductEventPublisher productEventPublisher;

    ProductSaveService(ProductRepository productRepository, ProductEventPublisher productEventPublisher) {
        this.productRepository = productRepository;
        this.productEventPublisher = productEventPublisher;
    }


    void save(String name, String category, BigDecimal price) {

        if (productRepository.findByName(name).isPresent()) {
            throw new RuntimeException("product with name '" + name + "' already exists!");
        }


        Product newProduct = Product.builder()
                                    .withName(name)
                                    .withCategory(category)
                                    .withPrice(price).build();

        productRepository.save(newProduct);
        productEventPublisher.publishEvent("product '" + name + "' saved");
    }
}

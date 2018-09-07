package pl.codeleak.samples.unit_testing.product;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Product search service test")
class ProductSearchServiceTest {

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductSearchService service;

    @Test
    @DisplayName("Should find only products matched by given price range")
    void findsAllProductsByPriceRange() {
        // arrange
        when(productRepository.findAllProducts()).thenReturn(ProductsCatalogue.testProducts());

        ProductSearchCriteria criteria = ProductSearchCriteria.priceRange(
            BigDecimal.valueOf(350.00), BigDecimal.valueOf(850.00)
        );

        // act
        List<Product> products = service.getProducts(criteria);

        // assert
        assertThat(products)
            .hasSize(3)
            .extracting(product -> product.getName())
            .contains("Apple iPhone 8", "Apple iPhone 8 Plus", "Apple Watch Sport 42mm with Sport Band");

        verify(productRepository).findAllProducts();
        verifyNoMoreInteractions(productRepository);
    }

    @Test
    @DisplayName("Should find only products matched by name and category")
    void findsAllProductsByNameAndCategory() {
        // arrange
        when(productRepository.findAllProducts()).thenReturn(ProductsCatalogue.testProducts());

        ProductSearchCriteria criteria = ProductSearchCriteria
            .builder()
            .nameMatches("Apple.*")
            .categoryMatches("Electronics")
            .build();

        // act
        List<Product> products = service.getProducts(criteria);

        // assert
        assertThat(products)
            .hasSize(1)
            .extracting(product -> product.getName())
            .contains("Apple Watch Sport 42mm with Sport Band");

        verify(productRepository).findAllProducts();
        verifyNoMoreInteractions(productRepository);
    }

    @Test
    @DisplayName("Should throw an exception when no products found")
    void throwsExceptionsWhenNoProductsFound() {
        // arrange
        when(productRepository.findAllProducts()).thenReturn(Collections.emptyList());

        ProductSearchCriteria criteria = ProductSearchCriteria
            .builder()
            .nameMatches(".*")
            .build();

        // act & assert
        assertThatThrownBy(() -> service.getProducts(criteria)).hasMessage("no products found");

        verify(productRepository).findAllProducts();
        verifyNoMoreInteractions(productRepository);
    }
}
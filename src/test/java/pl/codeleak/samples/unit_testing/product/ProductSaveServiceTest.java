package pl.codeleak.samples.unit_testing.product;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("Product save service test")
class ProductSaveServiceTest {

    @Mock
    ProductRepository productRepository;

    @Mock
    ProductEventPublisher productEventPublisher;

    @InjectMocks
    ProductSaveService productSaveService;

    @Test
    @DisplayName("Should create product object on product save")
    void productShouldBeSaved() {
        // arrange
        String productName = "Galaxy Tab S";
        String productCategory = "Smartphones";
        BigDecimal productPrice = new BigDecimal("1100.00");

        when(productRepository.findByName(productName)).thenReturn(Optional.empty());

        // act
        productSaveService.save(productName, productCategory, productPrice);

        // assert
        ArgumentCaptor<Product> productCaptor = ArgumentCaptor.forClass(Product.class);
        verify(productRepository).save(productCaptor.capture());

        Product product = productCaptor.getValue();

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(product.getName()).isEqualTo(productName);
        softAssertions.assertThat(product.getCategory()).isEqualTo(productCategory);
        softAssertions.assertThat(product.getPrice()).isEqualTo(productPrice);
        softAssertions.assertAll();
    }

    @Test
    @DisplayName("Should public an event after product save")
    void eventIsPublishedOnProductSave() {
        // arrange
        String productName = "Galaxy Tab S";
        String productCategory = "Smartphones";
        BigDecimal productPrice = new BigDecimal("1100.00");

        when(productRepository.findByName(productName)).thenReturn(Optional.empty());

        // act
        productSaveService.save(productName, productCategory, productPrice);

        // assert
        ArgumentCaptor<String> eventCaptor = ArgumentCaptor.forClass(String.class);
        verify(productEventPublisher).publishEvent(eventCaptor.capture());

        assertEquals("product 'Galaxy Tab S' saved", eventCaptor.getValue());

        verify(productRepository).save(any(Product.class));
        verifyNoMoreInteractions(productRepository, productEventPublisher);
    }
}
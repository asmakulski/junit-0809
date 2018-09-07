package pl.codeleak.samples.unit_testing.product;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

@DisplayName("Product save service test")
class ProductSaveServiceTest {

    @Test
    @DisplayName("Should create product object on product save")
    void productShouldBeSaved() {
        // arrange
        String productName = "Galaxy Tab S";
        String productCategory = "Smartphones";
        BigDecimal productPrice = new BigDecimal("1100.00");

        // act

        // assert

    }

    @Test
    @DisplayName("Should public an event after product save")
    void eventIsPublishedOnProductSave() {
        // arrange
        String productName = "Galaxy Tab S";
        String productCategory = "Smartphones";
        BigDecimal productPrice = new BigDecimal("1100.00");

        // act

        // assert

    }
}
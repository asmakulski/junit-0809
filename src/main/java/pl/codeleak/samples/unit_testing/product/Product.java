package pl.codeleak.samples.unit_testing.product;

import java.math.BigDecimal;
import java.util.Objects;

class Product {

    private final String name;
    private final String category;
    private final BigDecimal price;

    private Product(String name, String category, BigDecimal price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    static Builder builder() {
        return new Builder();
    }

    String getName() {
        return name;
    }

    String getCategory() {
        return category;
    }

    BigDecimal getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Product))
            return false;
        Product product = (Product) o;
        return Objects.equals(getName(), product.getName()) &&
            Objects.equals(getCategory(), product.getCategory()) &&
            Objects.equals(getPrice(), product.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCategory(), getPrice());
    }

    static class Builder {
        private String name;
        private String category;
        private BigDecimal price;

        Builder withName(String name) {
            this.name = name;
            return this;
        }

        Builder withCategory(String category) {
            this.category = category;
            return this;
        }

        Builder withPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        Product build() {
            return new Product(name, category, price);
        }
    }
}

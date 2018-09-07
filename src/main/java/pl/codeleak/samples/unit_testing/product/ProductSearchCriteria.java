package pl.codeleak.samples.unit_testing.product;

import java.math.BigDecimal;
import java.util.function.Predicate;

class ProductSearchCriteria {

    private final BigDecimal minPrice;
    private final BigDecimal maxPrice;
    private final String category;
    private final String name;

    private ProductSearchCriteria(String namePattern, String categoryPattern, BigDecimal minPrice, BigDecimal maxPrice) {
        this.name = namePattern;
        this.category = categoryPattern;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    static ProductSearchCriteria empty() {
        return builder().build();
    }

    static ProductSearchCriteria priceRange(BigDecimal min, BigDecimal max) {
        return builder().min(min).max(max).build();
    }

    static CriteriaBuilder builder() {
        return new CriteriaBuilder();
    }

    String getNamePattern() {
        return name;
    }

    String getCategoryPattern() {
        return category;
    }

    BigDecimal getMinPrice() {
        return minPrice;
    }

    BigDecimal getMaxPrice() {
        return maxPrice;
    }

    boolean isValid() {
        return getMinPrice() != null
            || getMaxPrice() != null
            || getNamePattern() != null
            || getCategoryPattern() != null;
    }

    Predicate<Product> toPredicate() {

        Predicate<Product> filters = p -> true;
        if (getMinPrice() != null) {
            filters = filters.and(
                p -> getMinPrice().compareTo(p.getPrice()) <= 0
            );
        }

        if (getMaxPrice() != null) {
            filters = filters.and(
                p -> getMaxPrice().compareTo(p.getPrice()) >= 0
            );
        }

        if (getNamePattern() != null) {
            filters = filters.and(
                p -> p.getName().matches(getNamePattern())
            );
        }

        if (getCategoryPattern() != null) {
            filters = filters.and(
                p -> p.getCategory().matches(getCategoryPattern())
            );
        }

        return filters;
    }

    static class CriteriaBuilder {

        private BigDecimal minPrice;
        private BigDecimal maxPrice;
        private String categoryPattern;
        private String namePattern;

        private CriteriaBuilder() {

        }

        CriteriaBuilder min(BigDecimal min) {
            this.minPrice = min;
            return this;
        }

        CriteriaBuilder max(BigDecimal max) {
            this.maxPrice = max;
            return this;
        }

        CriteriaBuilder categoryMatches(String regex) {
            this.categoryPattern = regex;
            return this;
        }

        CriteriaBuilder nameMatches(String regex) {
            this.namePattern = regex;
            return this;
        }

        ProductSearchCriteria build() {
            return new ProductSearchCriteria(namePattern, categoryPattern, minPrice, maxPrice);
        }
    }
}

package pl.codeleak.samples.unit_testing.product;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class ProductsCatalogue {

    private static final String products =
        "Apple Watch Sport 42mm with Sport Band;Electronics;399.00\n" +
            "JBL Pebbles PC Speakers;Electronics;59.99\n" +
            "Astro A30 System;Electronics;199.99\n" +
            "Apple iPhone 8;Smartphones;650.00\n" +
            "Apple iPhone 8 Plus;Smartphones;850.00\n" +
            "Apple iPhone X;Smartphones;1000.00\n" +
            "DOTA 2 - Series 3 Micro Plush Blind Box;Toys;14.99\n" +
            "Minions Pop Vinyl Figures;Toys;9.99";

    static List<Product> testProducts() {
        return Arrays.stream(products.split("\n"))
                     .map(line -> line.split(";"))
                     .map(row -> Product
                         .builder()
                         .withName(row[0])
                         .withCategory(row[1])
                         .withPrice(new BigDecimal(row[2]))
                         .build())
                     .collect(Collectors.toList());
    }
}

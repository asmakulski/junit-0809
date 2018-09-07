package pl.codeleak.samples.unit_testing.assertj;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


class AssertJSamplesTest {

    @Test
    void basics() {
        // arrange
        boolean bool = true;
        int integer = 2;
        String string = "AssertJ";

        // assert
        assertThat(bool).isTrue();

        assertThat(integer)
            .isLessThan(3)
            .isGreaterThan(1);

        assertThat(string)
            .hasSize(7)
            .matches("^AssertJ$")
            .contains("t")
            .doesNotContain("x");
    }

    @Test
    void dates() {
        // arrange
        LocalDate localDate = LocalDate.of(2011, 1, 1);

        // assert
        assertThat(localDate)
            .isBefore(LocalDate.now())
            .isAfter(LocalDate.of(2010, 1, 1));
    }

    @Test
    void lists() {
        // arrange
        List<String> list = Arrays.asList("one", "two", "three", "four");

        // assert
        assertThat(list)
            .isNotEmpty()
            .containsAnyOf("two", "four")
            .containsSubsequence("two", "three")
            .containsOnlyOnce("one");
    }

    @Test
    void maps() {
        // arrange
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");

        // assert
        assertThat(map)
            .doesNotContainKeys(6, 7)
            .containsKeys(1, 3)
            .containsValues("one", "five");
    }

    @Test
    void arrays() {
        // arrange
        String[] array = new String[]{"one", "two", "three", "four"};

        // assert
        assertThat(array)
            .isNotEmpty()
            .containsAnyOf("two", "four")
            .containsSubsequence("two", "three")
            .containsOnlyOnce("one");
    }

    @Test
    void files() throws IOException {
        // arrange
        File file1 = File.createTempFile("abc", "xyz");
        File file2 = File.createTempFile("abc", "xyz");

        // assert
        assertThat(file1)
            .isFile()
            .hasSameContentAs(file2);
    }

    @Test
    void softAssertions() {
        // arrange
        boolean bool = true;
        int integer = 2;
        String string = "AssertJ";

        // assert
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(bool).isTrue();
        softAssertions.assertThat(integer).isBetween(0, 3).isPositive();
        softAssertions.assertThat(string).contains("t");
        softAssertions.assertAll();
    }
}

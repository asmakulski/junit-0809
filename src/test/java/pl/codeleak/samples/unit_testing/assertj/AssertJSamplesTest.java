package pl.codeleak.samples.unit_testing.assertj;

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
        // TODO
    }

    @Test
    void dates() {
        // arrange
        LocalDate localDate = LocalDate.of(2011, 1, 1);

        // assert
        // TODO
    }

    @Test
    void lists() {
        // arrange
        List<String> list = Arrays.asList("one", "two", "three", "four");

        // assert
        // TODO
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
        // TODO
    }

    @Test
    void arrays() {
        // arrange
        String[] array = new String[]{"one", "two", "three", "four"};

        // assert
        // TODO
    }

    @Test
    void files() throws IOException {
        // arrange
        File file1 = File.createTempFile("abc", "xyz");
        File file2 = File.createTempFile("abc", "xyz");

        // assert
        // TODO
    }

    @Test
    void softAssertions() {
        // arrange
        boolean bool = true;
        int integer = 2;
        String string = "AssertJ";

        // assert
        // TODO
    }
}

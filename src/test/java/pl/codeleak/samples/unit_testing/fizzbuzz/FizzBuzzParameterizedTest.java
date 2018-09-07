package pl.codeleak.samples.unit_testing.fizzbuzz;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("FizzBuzz parameterized tests")
class FizzBuzzParameterizedTest {

    FizzBuzz fizzBuzz = new FizzBuzz();

    @Test
    void returnsFizzForNumberDivisibleByThree() {
        // TODO Parameterize with value source
        int[] numbers = {1, 2, 4, 7, 11, 13, 14};
        for (int number : numbers) {
            assertThat(fizzBuzz.play(number)).isEqualTo("" + number);
        }
    }

    @Test
    void returnBuzzForNumberDivisibleByFive() {
        // TODO Parameterize with method source (single argument)
        int[] numbers = {5, 10, 20, 25, 35, 40, 50};
        for (int number : numbers) {
            assertThat(fizzBuzz.play(number)).isEqualTo("Buzz");
        }
    }

    @Test
    void play1() {
        // TODO Parameterize with method source
    }

    @Test
    void play2() {
        // TODO Parameterize with csv source
    }
}

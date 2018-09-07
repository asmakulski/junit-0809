package pl.codeleak.samples.unit_testing.fizzbuzz;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("FizzBuzz parameterized tests")
class FizzBuzzParameterizedTest {

    FizzBuzz fizzBuzz = new FizzBuzz();

    @ParameterizedTest(name = "{index} - playing FizzBuzz with {arguments}")
    @ValueSource(ints = {1, 2, 4, 7, 11, 13, 14})
    void returnsFizzForNumberDivisibleByThree(int number) {
        assertThat(fizzBuzz.play(number)).isEqualTo("" + number);
    }

    @ParameterizedTest(name = "{index} - playing FizzBuzz with {arguments}")
    @MethodSource("paramsForReturnBuzzForNumberDivisibleByFive")
    void returnBuzzForNumberDivisibleByFive(int number) {
        assertThat(fizzBuzz.play(number)).isEqualTo("Buzz");
    }

    private static Stream<Integer> paramsForReturnBuzzForNumberDivisibleByFive() {
        return Stream.of(5, 10, 20, 25, 35, 40, 50);
    }

    @ParameterizedTest(name = "{index} - playing FizzBuzz with {arguments}")
    @MethodSource("paramsForPlay1")
    void play1(int input, String output) {
        assertThat(fizzBuzz.play(input)).isEqualTo(output);
    }

    private static Stream<Arguments> paramsForPlay1() {
        return Stream.of(
            Arguments.arguments(1, "1"),
            Arguments.arguments(3, "Fizz"),
            Arguments.arguments(5, "Buzz"),
            Arguments.arguments(15, "FizzBuzz")
        );
    }

    @ParameterizedTest(name = "{index} - playing FizzBuzz with {arguments}")
    @CsvFileSource(resources = "/fizzbuzz-test-parameters.csv", numLinesToSkip = 1)
    void play2(int input, String output) {
        assertThat(fizzBuzz.play(input)).isEqualTo(output);
    }
}

package pl.codeleak.samples.unit_testing.fizzbuzz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("FizzBuzz basic tests")
class FizzBuzzTest {

    private FizzBuzz fizzBuzz;

    @BeforeEach
    void setUp() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    @DisplayName("Should return given number as String when it is not divisible by 3 and 5")
    void returnsNumberForNumberNotDivisibleByThreeAndFive() {
        // arrange
        int number = 1;
        // act
        String result = fizzBuzz.play(number);
        // assert
        assertEquals(result, "1");
    }

    @Test
    @DisplayName("Should return 'Fizz' when given number is divisible by 3")
    void returnsFizzForNumberDivisibleByThree() {
        // arrange
        int number = 3;
        // act
        String result = fizzBuzz.play(number);
        // assert
        assertEquals(result, "Fizz");
    }

    @Test
    @DisplayName("Should return 'Buzz' when given number is divisible by 5")
    void returnsBuzzForNumberDivisibleByFive() {
        // arrange
        int number = 5;
        // act
        String result = fizzBuzz.play(number);
        // assert
        assertEquals(result, "Buzz");
    }

    @Test
    @DisplayName("Should return 'FizzBuzz' when given number is divisible by 3 and 5")
    void returnsFizzBuzzForNumberDivisibleByThreeAndFive() {
        // arrange
        int number = 15;
        // act
        String result = fizzBuzz.play(number);
        // assert
        assertEquals(result, "FizzBuzz");
    }
}
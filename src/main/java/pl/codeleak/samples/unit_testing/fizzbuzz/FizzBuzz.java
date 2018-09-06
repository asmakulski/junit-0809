package pl.codeleak.samples.unit_testing.fizzbuzz;

class FizzBuzz {

    String play(int number) {
        if (isDivisibleBy(number, 3) && isDivisibleBy(number, 5)) {
            return "FizzBuzz";
        }

        if (isDivisibleBy(number, 3)) {
            return "Fizz";
        }

        if (isDivisibleBy(number, 5)) {
            return "Buzz";
        }

        return String.valueOf(number);
    }

    private static boolean isDivisibleBy(int dividend, int divisor) {
        return dividend % divisor == 0;
    }
}

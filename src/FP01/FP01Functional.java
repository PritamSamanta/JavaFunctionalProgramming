package FP01;

import java.util.List;

public class FP01Functional {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 5, 34, 87, 23, 98, 31, 55, 78, 90, 21);

        // Print all numbers in a list in functional programming way
        //printAllNumbersInListFunctional(numbers);

        // Print all EVEN numbers in a list in functional programming way
        //printEvenNumbersInListFunctional(numbers);

        // Print squares of every numbers in a list in functional programming way
        printSquareOfNumbersInListFunctional(numbers);
    }

    private static void printSquareOfNumbersInListFunctional(List<Integer> numbers) {
        numbers.stream()
                .map(num -> Math.pow(num,2))// Map- will map every element by applying a function here in lambda expr
                .forEach(System.out::println);
    }

    private static void printElement(int element){
        System.out.println(element);
    }
    private static void printAllNumbersInListFunctional(List<Integer> numbers) {

        // Approach - What to do
        // First convert the elements to a stream
        // Second use a stream function like forEach
        // Use method reference to call a method for every element

        numbers.stream().forEach(FP01Functional::printElement);
        // OR
        numbers.stream().forEach(System.out::println);

        //Both will work and return the same result.

    }

    private static boolean isEven(int num){
        return num % 2 == 0;
    }
    private static void printEvenNumbersInListFunctional(List<Integer> numbers) {

        numbers.stream() // stream - sequence of elements where a lot of operations can be performed
               // .filter(FP01.FP01Functional::isEven) // filter - for filtering only specific elements with a given predicate here even
                .filter(num -> num % 2 == 0)  // lambda expr-defining the whole function logic & hence simple code
                .forEach(System.out::println); // Method reference - for referring to the method

        /*
        Lambda - simple representation of methods
        forEach - is Consuming all the elements
         */
    }
}

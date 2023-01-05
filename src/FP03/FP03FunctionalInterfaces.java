package FP03;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FP03FunctionalInterfaces {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 5, 34, 87, 23, 98, 31, 78, 90, 21);

        //Print Square of every even number
        printSquareOfEveryEvenNumber(numbers);

        /*
        Find Functional Interface behind the second argument of reduce method.
        Create an implementation for the Functional Interface.
        int sum = numbers.stream() .reduce(0, Integer::sum);
         */
        findFunctionalInterfaceOfSecondArgumentOfReduce(numbers);
    }

    private static void findFunctionalInterfaceOfSecondArgumentOfReduce(List<Integer> numbers) {
        /*
        A BinaryOperator represents a operation which takes 2 arguments of same type and returns a result
        of the same type as well.
         */

        BinaryOperator<Integer> sum = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer num1, Integer num2) {
                return num1 + num2;
            }
        };

        System.out.println(numbers.stream() .reduce(0, sum));
    }

    private static void printSquareOfEveryEvenNumber(List<Integer> numbers) {
        /*
        When we use a lambda expr like num -> num * num it basically means :-
        int squareNum(num) {
            return num * num;
        }

        Predicate, Function,Consumer etc are all Functional Interfaces. A functional interface is a interface
        which is annotated with @FunctionalInterface and will have only one abstract method - no body is defined.
        This abstract method is called function descriptor. The signature of the lambda expression matches
        the definition of the func descriptor.
        Func Interfaces can have however default,static and overloaded methods definitions.
         */

        Predicate<Integer> isEvenPredicate = num -> num % 2 == 0;
        /*
        A Predicate is something which returns a boolean value by evaluating an expression.
        Internally Java creates something of this sort from this lambda expr : -

        Predicate<Integer> isEvenPredicate = new Predicate<Integer>() {

            @Override
            public boolean test(Integer num) {
                return num % 2 == 0;
            }
        };
        Here test is the abstract method.
        */

        Function<Integer, Integer> squareFunction = num -> num * num;
        /*
        A Function represents a function that accepts one argument and produces a result.
        Here Function<T,R> represents T- the input type and R- the output type.

        Function<Integer, Integer> squareFunction2 = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer num) {
                return num * num;
            }
        };
        */
        Consumer<Integer> printlnConsumer = System.out::println;
        /*
        A Consumer represents an operation that accepts a single input argument and returns no result.
        Consumer<Integer> printlnConsumer2 = new Consumer<Integer>() {
            @Override
            public void accept(Integer num) {
                System.out.println(num);
            }
        };
        So here we have created instances or implementations of these functional interfaces. When we use
        new Consumer<T> or anything actually we are creating anonymous class implementation, as we are not
        mentioning the class name;
        */
        numbers.stream().filter(isEvenPredicate).map(squareFunction).forEach(printlnConsumer);
    }
}

package FP03;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FP03BehaviorParameterization {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 5, 34, 87, 23, 98, 31, 78, 90, 21);

        //Predicate<Integer> evenPredicate = num -> num % 2 == 0;
        //Predicate<Integer> oddPredicate = num -> num % 2 != 0;
        //Predicate<Integer> multipleOf3Predicate = num -> num % 3 == 0;

        filterAndPrint(numbers, num -> num % 2 == 0); // even filter
        filterAndPrint(numbers, num -> num % 2 != 0); // odd filter
        filterAndPrint(numbers, num -> num % 3 == 0); // multiple of 3 filter

        /*
        Do Behavior Parameterization for the mapping logic.
        List squaredNumbers = numbers.stream() .map(x -> x*x) .collect(Collectors.toList());
         */

        List squaredNumbers = getMappedNumbers(numbers, num -> num * num);
        System.out.println("Mapped numbers are -> " + squaredNumbers);

        //Similarly we can do....
        List cubedNumbers = getMappedNumbers(numbers, num -> num * num * num);
        System.out.println("Mapped numbers are -> " + cubedNumbers);

        List quadrupledNumbers = getMappedNumbers(numbers, num -> 4 * num);
        System.out.println("Mapped numbers are -> " + quadrupledNumbers);


    }

    private static List<Integer> getMappedNumbers(List<Integer> numbers,
                                                  Function<Integer, Integer> mappingFunction) {
        return numbers.stream().map(mappingFunction).collect(Collectors.toList());
    }


    private static void filterAndPrint(List<Integer> numbers, Predicate<Integer> filterPredicate) {
        System.out.println("Filtered Results ----------- > ");
        numbers.stream().filter(filterPredicate).forEach(System.out::println);

        /*
        Here we are passing the logic of the method or the behavior of the method as a parameter to
        a method. This is called Behavior Parameterization. Typically, we pass in data as a parameter and
        over here, what we are doing? We are passing the code of the method as the parameter.
        We are passing the algorithm, the strategy, as a parameter. We are externalizing this strategy and
        making it a parameter. And this would provide a lot of flexibility in how we code.

        In this example we have passed Predicate as a parameter. We have written the logic in a lambda
        expr form while defining or instantiating the Predicate of our required type. Then passed it as
        a parameter to the method filterAndPrint which takes the predicate and further uses it.
        In this way we didn't need to write the stream and print code for every single predicate
        rather we just defined the predicate and the function will work accordingly. So this function
        will work for any kind of predicate i.e:- filter condition.
        Rather than passing the predicate we can directly pass the predicate logic as a lambda expr
        and it will work also fine. This reduces the code extremely.
         */
    }
}

package FP03;

import java.util.List;
import java.util.Random;
import java.util.function.IntUnaryOperator;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FP03FunctionalInterfaces2 {
    public static void main(String[] args) {

        /*
        Until now we have worked with Predicate,Function,Consumer,BinaryOperator FunctionalInterfaces.
        This is Supplier<T>. It will take no inputs and will return a result of type T. here in this case - Integer
        It has only 1 abstract method which is get(), which we use to get the value here in println.
         */
        Supplier<Integer> randomIntegerSupplier = () -> new Random().nextInt(1000);
        System.out.println(randomIntegerSupplier.get());

        /*
        As BinaryOperator would take 2 inputs and return a result, a UnaryOperator will only take a single input
        and return the result of the same type. apply() is the abstract method for this funcInterface.
        */
        UnaryOperator<Integer> tripledNumber = (num) -> 3 * num;
        System.out.println(tripledNumber.apply(10));

        /*
        Instead of Wrapper class we should use primitives whenever possible as autoboxing etc hits performance
        and not efficient. So there a lot of functional interfaces with primitive types like long,double etc.
         */
        IntUnaryOperator tripledNumber2 = (num) -> 3 * num;
        System.out.println(tripledNumber2.applyAsInt(15));

        /*
        Apart from all this do check out java.util.function package for all the Functional Interfaces there is.
         */

        List<String> courses =
                List.of("Spring", "Spring Boot", "API" , "Microservices", "AWS",
                        "PCF","Azure", "Docker", "Kubernetes");
        courses.stream()
                //.map(str -> str.toUpperCase())
                .map(String::toUpperCase)
                .forEach(System.out::println);

        /*
        As you can see above for first mapping we have used lambda expr for converting to uppercase of each string.
        But for second mapping we used method reference. Yes, apart from static methods we can also use
        method reference for those which needs an instance of a class as toUpperCase is non-static method.
         */

        //Supplier<String> newStringSupplier = () -> new String();
        Supplier<String> newStringSupplier = String::new;

        /*
        Above code where a supplier gives a new string by invoking the constructor of String class can also be
        written in short form with help of Constructor Reference, which can be used to create new Objects.
         */
    }
}

package FP02;

import java.util.List;
import java.util.stream.Collectors;

public class FP02Functional {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 5, 34, 87, 23, 98, 31, 55, 78, 90, 21);

        // return the sum of the elements in functional programming way
        //int sum = addListFunctional(numbers);
        //System.out.println(sum);

        //more functionalities with reduce
        moreFunctionalitiesWithReduce(numbers);
    }

    private static void moreFunctionalitiesWithReduce(List<Integer> numbers) {
        // This code will only return 0 ,as it is the first element we want to return
        //System.out.println(numbers.stream().reduce(0,(x,y)-> x));

        //This code will return the last element of the list as per the functionality of reduce
        //System.out.println(numbers.stream().reduce(0,(x,y) -> y));

        /*
        This following piece of code with reduce will print the maximum or the largest element in the
        list. Here it is comparing x and y if x is > y then it returns x or else y.
        One drawback of this approach is that it only works for positive numbers in the list and will
        return 0 if there are all negative numbers, as initially it will be comparing with the initial value
        which is given 0 here and as 0 is greater than any -ve numbers hence the result.
        Next piece of code gives the solution for this also.
         */
        //System.out.println(numbers.stream().reduce(0,(x,y) -> x>y?x:y));

        //This code will work for -ve numbers also as MIN_VALUE is the minimum integer value possible
        //System.out.println(numbers.stream().reduce(Integer.MIN_VALUE,(x,y) -> x>y?x:y));

        System.out.println(numbers.stream().reduce(Integer.MAX_VALUE,(x,y) -> x<y?x:y));
    }

    private static int add(int aggregate, int nextNumber){
        System.out.println(aggregate + "  " + nextNumber);
        return aggregate + nextNumber;

        /*
        here the first argument is the aggragate or the initial value and second argument is the next element
        from the stream which will be used by reduce.
        We are printing the elements to show how reduce works internally. This is the result : -
                    0  12
                    12  5
                    17  34
                    51  87
                    138  23
                    161  98
                    259  31
                    290  55
                    345  78
                    423  90
                    513  21
                    534
         As you can see 0 is the first element or aggregate or the identity that we provided in first
         argument of reduce and 12 is the first element from the stream of numbers of our List Numbers.
         Using this the reduce is adding both of them by using our function and then again providing it
         as the first element in the next iteration. In this way it achieves a single result until there
         is no element from the stream to reduce and we got our sum.
         */
    }
    private static int addListFunctional(List<Integer> numbers) {

        return numbers.stream().reduce(0,FP02Functional::add); // Using custom add method
        /*
        When we want a Stream of numbers to reduce to a single number -- here in this case its the sum
        When we want to combine the whole result into - a single value --- use reduce
        First argument is the identity or the intitial value you want, in this case since initial value of sum
        should be 0 hence its 0.
        Next argument takes a aggregator or accumulater BiFunction -- which is nothing but a function that
        takes 2 arguments and returns a single result -- in this case we manually defined a function
        named add which takes 2 elements and add them and returns and used it as a static
        method reference. Look at the comment of add method to see how reduce internally works.

        We can also use a lambda expression to remove this boilerplate code and it will be even
        simpler.(Just has to be a BiFunction) as coded below.
         */
        //return numbers.stream().reduce(0,(a,b) -> a + b);  // using lambda expression

        //return numbers.stream().reduce(0,Integer::sum); // Using pre-defined Integer
        // class as static method reference

        //return numbers.stream().collect(Collectors.summingInt(Integer::intValue)); // using collect
        /*
        Here the collect as the name suggests will take a Collector function which will do nothing
        but collect the elements and apply whatever method logic is there here in this case its summing
        the integers - which in turn will take a parameter asking for what integers here in this
        case its the integer value as we can also do for eg hashcode.
         */

        //return numbers.stream().mapToInt(Integer::intValue).sum(); // using mapToInt
        /*
        here mapToInt will convert the stream to a Intstream where we have readymade methods available
        like sum and average. mapToInt will also an argument to know what value of int you want
        in this case we take intValue but we can also take for eg byteValue etc.
         */

    }


}
/*
map,filter,distinct,sorted and others are all intermediate operations. As they return a stream again which
can be further processed.
Whereas collect,reduce,forEach etc are all terminal operations as they don't return streams rather
some specific type or don't return at all.These cannot be further processed and have to be returned or
collected.
 */

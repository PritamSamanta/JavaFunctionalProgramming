package FP04;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class FP04Exercise {
    public static void main(String[] args) {
        // use sout to print the elements
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        numbers.stream();

        Stream.of(12, 9, 13, 4, 6, 2, 4, 12, 15).count();
        Stream.of(12, 9, 13, 4, 6, 2, 4, 12, 15).reduce(0, Integer::sum);
        Stream.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        int[] numberArray = {12, 9, 13, 4, 6, 2, 4, 12, 15};
        Arrays.stream(numberArray);
        Arrays.stream(numberArray).sum();
        Arrays.stream(numberArray).average();
        Arrays.stream(numberArray).min();
        Arrays.stream(numberArray).max();

        IntStream.range(1,10);
        IntStream.range(1,10).sum();
        IntStream.rangeClosed(1,10).sum();

        IntStream.iterate(1, e -> e + 2).limit(10).sum();
        IntStream.iterate(1, e -> e + 2).limit(10).peek(System.out::println).sum();
        IntStream.iterate(2, e -> e + 2).limit(10).peek(System.out::println).sum();
        IntStream.iterate(2, e -> e * 2).limit(10).peek(System.out::println).sum();
        IntStream.iterate(2, e -> e * 2).limit(10).boxed().collect(Collectors.toList());

        System.out.println(Integer.MAX_VALUE);;
        System.out.println(Long.MAX_VALUE);;

        IntStream.rangeClosed(1,50).reduce(1, (x,y)->x*y);
        LongStream.rangeClosed(1,50).reduce(1, (x, y)->x*y);
        LongStream.rangeClosed(1,50).reduce(1L, (x,y)->x*y);
        LongStream.rangeClosed(1,10).reduce(1, (x,y)->x*y);
        LongStream.rangeClosed(1,20).reduce(1, (x,y)->x*y);
        LongStream.rangeClosed(1,40).reduce(1, (x,y)->x*y);
        LongStream.rangeClosed(1,50).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE, BigInteger::multiply);
    }
}

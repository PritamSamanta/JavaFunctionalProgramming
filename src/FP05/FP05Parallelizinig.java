package FP05;

import java.util.stream.LongStream;

public class FP05Parallelizinig {
    public static void main(String[] args) {
        long time = System.currentTimeMillis();

        System.out.println(LongStream.range(0,1000000000).sum());

        long serialTime = System.currentTimeMillis() - time;
        long time2 = System.currentTimeMillis();

        System.out.println(LongStream.range(0,1000000000).parallel().sum());

        long parallelTime = System.currentTimeMillis() - time2;

        System.out.println(" Serial processing time is : "+serialTime);
        System.out.println(" Parallel processing time is : "+parallelTime);
    }
}

package FP05;

import java.util.stream.IntStream;

public class FP05Threads {
    public static void main(String[] args) {

        // Old way of making threads
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 20; i++) {
                    System.out.println(Thread.currentThread().getId() + " : " + i);
                }
            }
        };

        Thread th1 = new Thread(runnable);
        Thread th2 = new Thread(runnable);
        Thread th3 = new Thread(runnable);

        th1.start();
        th2.start();
        th3.start();

        // Functional way of making threads as Runnable is a Functional Interface
        Runnable runnable2 = () -> {
            IntStream.range(0,20).forEach(i -> System.out.println(Thread.currentThread().getId() + " : " + i));
        };

        Thread th4 = new Thread(runnable2);
        Thread th5 = new Thread(runnable2);
        Thread th6 = new Thread(runnable2);

        th4.start();
        th5.start();
        th6.start();

    }
}

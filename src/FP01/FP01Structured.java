package FP01;

import java.util.List;

public class FP01Structured {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 5, 34, 87, 23, 98, 31, 55, 78, 90, 21);
        // Print all numbers in a list in structured programming way
        
        //printAllNumbersInListStructured(numbers);

        // Print all EVEN numbers in a list in structured programming way

        printEvenNumbersInListStructured(numbers);
    }

    private static void printAllNumbersInListStructured(List<Integer> numbers) {
        //Approach - How to do eg:- how to loop all elements
        for(int num : numbers) {
            System.out.println(num);
        }
    }

    private static void printEvenNumbersInListStructured(List<Integer> numbers) {
        //Approach - How to do eg:- how to loop all elements
        for(int num : numbers) {
            if(num % 2 == 0) {
                System.out.println(num);
            }
        }
    }
}

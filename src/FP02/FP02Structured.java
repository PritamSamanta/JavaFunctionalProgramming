package FP02;

import java.util.List;

public class FP02Structured {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 5, 34, 87, 23, 98, 31, 55, 78, 90, 21);

        // return the sum of the elements in structured programming way
        int sum = addListStructured(numbers);
        System.out.println(sum);
    }

    private static int addListStructured(List<Integer> numbers) {
        int sum = 0;
        for(int num : numbers){
            sum += num;
        }
        return sum;
    }
}

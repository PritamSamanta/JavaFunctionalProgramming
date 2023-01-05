package FP02;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FP02Exercises {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 5, 34, 87, 23, 98, 31, 5, 78, 90, 21);

        List<String> courses =
                List.of("Spring", "Spring Boot", "API" , "Microservices", "AWS",
                        "PCF","Azure", "Docker", "Kubernetes");

        // Square every number in a list and find the sum of squares
        //printSumOfSquareOfEveryNumberInTheList(numbers);

        //Cube every number in a list and find the sum of cubes
        //printSumOfCubeOfEveryNumberInTheList(numbers);

        //Find Sum of Odd Numbers in a list
        //printSumOfOddNumbersInTheList(numbers);

        //print distict elements in the list -- here 5 is removed
        //numbers.stream().distinct().forEach(System.out::println);

        //print sorted list of the elements
        //numbers.stream().sorted().forEach(System.out::println);

        //print sorted list of distict elements
        //numbers.stream().distinct().sorted().forEach(System.out::println);

        //print each course in alphabetical order -ie - sorted
        //courses.stream().sorted().forEach(System.out::println);

        //print each course in reverse order
        //printEachCourseInReverseOrder(courses);

        //print each course in a sorted order using custom Comparator - here use string length
        //sortTheCourseListUsingCustomComparatorAndPrint(courses);

        //Create a List with Even Numbers Filtered from the Numbers List
        //List<Integer> evenNumbers = getEvenNumbers(numbers);
        //System.out.println(evenNumbers);

        //Create a List with lengths of all course titles.
        List<Integer> courseTitleLengths = getCourseTitleLengths(courses);
        System.out.println(courseTitleLengths);

    }

    private static List<Integer> getCourseTitleLengths(List<String> courses) {
        return courses.stream().map(course -> course.length()).collect(Collectors.toList());
    }

    private static List<Integer> getEvenNumbers(List<Integer> numbers) {

        return numbers.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());
        /*
        Here the collect will take a Collector as an argument where we hve used toList method which will
        collect all the elements into a list and return
         */
    }

    private static void sortTheCourseListUsingCustomComparatorAndPrint(List<String> courses) {
//        courses.stream()
//                .sorted(Comparator.comparing(course -> course.length()))
//                .forEach(System.out::println);

        /*
        here the sorted will take a Comparator as an argument. We can provide a custom comparator
        by using Comparator.comparing() and inside it will take a function which we can define using
        a lambda expression. For example in this case here we are taking the course string and
        returning the string length of it. So it will be comparing every string in the list based on
        length of the string and hence the result will be in an ascending order of strings printed.

        Similarly, we can use it on integers as well and use any type of algorithm to compare the elements

         */

        List<String> eFilterList = List.of("eee","eeeeee","ee","eeeeeee","e","eeee");

        eFilterList.stream()
                .sorted(Comparator.comparing(course -> course.chars().filter(ch -> ch == 'e').sum()))
                .forEach(System.out::println);
        /*
        Above code prints the strings in ascending order of how many 'e' are in the string. We have used a
        custom comparator. here course.chars will convert the string to a IntStream of characters. From that
        stream we can filter the characters which equals 'e' and then finally summing it to get how many
        'e' are there in the string. This value will be used for comparison.
         */

    }

    private static void printEachCourseInReverseOrder(List<String> courses) {
        courses.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
        /*
        Here sorted will take a Comparator as an argument. By default, it is Comparator.naturalOrder()
        which if used will give the same result as sorted in ascending order. here in this case - alphabetical
        for strings.
         */
    }

    private static void printSumOfOddNumbersInTheList(List<Integer> numbers) {
        System.out.println(numbers.stream()
                .filter(num -> num % 2 == 1) // filter odd numbers
                .reduce(0, (x,y) -> x + y)); // Sum every element
    }

    private static void printSumOfCubeOfEveryNumberInTheList(List<Integer> numbers) {
        System.out.println(numbers.stream()
                .map(num -> num*num*num) // Cube every element
                .reduce(0,(x,y) -> x + y)); // Sum every element
    }

    private static void printSumOfSquareOfEveryNumberInTheList(List<Integer> numbers) {
        System.out.println(numbers.stream()
                .map(num -> num*num) // Squaring every element
                .reduce(0,(x,y) -> x + y)); // Summing every element
    }
}

package FP01;

import java.util.List;

public class FP01Exercises {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 5, 34, 87, 23, 98, 31, 55, 78, 90, 21);
        // Print odd numbers
        //printOddNumbersInListStructured(numbers);

        //Print All Courses individually
        List<String> courses =
                List.of("Spring", "Spring Boot", "API" , "Microservices", "AWS",
                        "PCF","Azure", "Docker", "Kubernetes");
        //printAllCoursesIndividually(courses);

        //Print Courses Containing the word "Spring"
        //printCoursesContainingTheWordSpring(courses);

        //Print Courses Whose Name has atleast 4 letters
        //printCoursesWhoseNameHasAtLeast4Letters(courses);

        //Print the cubes of odd numbers
        printCubesOfOddNumbers(numbers);

        //Print the number of characters in each course name
        printNumberOfCharactersInEachCourseName(courses);
    }

    private static void printNumberOfCharactersInEachCourseName(List<String> courses) {
        courses.stream().map(course -> course + " -> " + course.length())
                .forEach(System.out::println);
    }

    private static void printCubesOfOddNumbers(List<Integer> numbers) {
        numbers.parallelStream().filter(num -> num % 2 == 1)
                .map(num -> num + " -> " + Math.pow(num,3))
                .forEach(System.out::println);
    }

    private static void printCoursesWhoseNameHasAtLeast4Letters(List<String> courses) {
        courses.stream().filter(course -> course.length() >= 4).forEach(System.out::println);
    }

    private static void printCoursesContainingTheWordSpring(List<String> courses) {
        courses.stream().filter(course -> course.contains("Spring")).forEach(System.out::println);
    }

    private static void printAllCoursesIndividually(List<String> courses) {
        courses.stream().forEach(System.out::println);
    }


    private static void printOddNumbersInListStructured(List<Integer> numbers) {
        numbers.stream().filter(num -> num % 2 != 0).forEach(System.out::println);
    }
}

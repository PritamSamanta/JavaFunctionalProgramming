package FP04;

import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FP04Exercise2 {
    public static void main(String[] args) {

        List<String> courses =
                List.of("Spring", "Spring Boot", "API" , "Microservices", "AWS",
                        "PCF","Azure", "Docker", "Kubernetes");

        List<String> courses2 =
                List.of("Spring", "Spring Boot", "API" , "Microservices", "AWS",
                        "PCF","Azure", "Docker", "Kubernetes");

        // To concatenate/join all the elements into a single string with space as delimiter
        System.out.println(courses.stream().collect(Collectors.joining(" ")));

        // To concatenate/join all the elements into a single string with ','(comma) as delimiter
        System.out.println(courses.stream().collect(Collectors.joining(",")));

        // to split each course string into characters
        List<String[]> listOfChars = courses.stream().map(Course -> Course.split(""))
                .collect(Collectors.toList());
        for(String[] course : listOfChars){
            for(String character : course) {
                System.out.print(character+ " ");
            }
            System.out.print(",");
        }
        System.out.println();

        /* Since the previous approach produces a list of string array it is not desirable and therefore we
        need to use flatMap to flatten the stream of String array into a single stream. Flatmap basically
        maps every element in the stream array and then flattens it into a single stream.
        Here in the following example, the String array of characters has been map to stream and then all these
        stream has been flattened or joined to form a single new stream which has all the elements, we then
        collect it in form of list and print it.
         */
        System.out.println(courses.stream()
                .map(Course -> Course.split(""))
                .flatMap(Arrays::stream)
                .collect(Collectors.toList()));

        // To get distinct characters
        System.out.println(courses.stream()
                .map(Course -> Course.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList()));

        // This is a much more efficient way
        System.out.println(courses.stream()
                .flatMap(course -> Arrays.stream(course.split("")))
                .collect(Collectors.toList()));

        /*
        here our ultimate goal is to list of tuples of distinct course name which have same string length.

        In the first step, for every course name we iterate through courses2 and for a list of the 2 course names
        and then flatten it to a single stream.
        In the second step, we filter out the tuples which have both the same course name and remove.
        In the third step, while iterating through course2 we are actually filtering the courses with same string
        length.
         */
        System.out.println(courses.stream()
                .flatMap(course -> courses2.stream().map(course2 -> List.of(course,course2)))
                .collect(Collectors.toList()));

        System.out.println(courses.stream()
                .flatMap(course -> courses2.stream().map(course2 -> List.of(course,course2)))
                .filter(list -> !list.get(0).equals(list.get(1)))
                .collect(Collectors.toList()));

        System.out.println(courses.stream()
                .flatMap(course -> courses2.stream()
                        .filter(course2 -> course2.length() == course.length())
                        .map(course2 -> List.of(course,course2)))
                .filter(list -> !list.get(0).equals(list.get(1)))
                .collect(Collectors.toList()));


    }
}

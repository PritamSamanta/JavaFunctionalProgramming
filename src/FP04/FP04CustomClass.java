package FP04;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FP04CustomClass {
    public static void main(String[] args) {

        List<Course> courses = List.of(
                new Course("Spring", "Framework", 98, 20000),
                new Course("Spring Boot", "Framework", 95, 18000),
                new Course("API", "Microservices", 97, 22000),
                new Course("Microservices", "Microservices", 96, 25000),
                new Course("FullStack", "FullStack", 91, 14000),
                new Course("AWS", "Cloud", 92, 21000),
                new Course("Azure", "Cloud", 99, 21000),
                new Course("Docker", "Cloud", 92, 20000),
                new Course("Kubernetes", "Cloud", 91, 20000));

        /*
        Below all these allMatch,noneMatch and anyMatch takes a predicate and returns either true or false.
        allMatch -> Returns whether all elements of this stream match the provided predicate.
                    May not evaluate the predicate on all elements if not necessary for determining the result.
                    If the stream is empty then true is returned and the predicate is not evaluated.
        noneMatch -> Returns whether no elements of this stream match the provided predicate.
                     May not evaluate the predicate on all elements if not necessary for determining the result.
                     If the stream is empty then true is returned and the predicate is not evaluated
        anyMatch -> Returns whether any elements of this stream match the provided predicate.
                    May not evaluate the predicate on all elements if not necessary for determining the result.
                    If the stream is empty then false is returned and the predicate is not evaluated.
         */
        Predicate<Course> getReviewScoreGreaterThan97 = course -> course.getReviewScore() > 97;

        System.out.println(courses.stream().allMatch(course -> course.getReviewScore() > 90));
        System.out.println(courses.stream().noneMatch(course -> course.getReviewScore() < 90));
        System.out.println(courses.stream().anyMatch(getReviewScoreGreaterThan97));

        /*
        In this section we discussed about sorted() in streams. sorted takes a Comparator as argument which then
        sorts according to it otherwise uses natural ordering. We have defined both external comparator and
        internal comparators. for primitive values comparing always use comparingInt/comparingDouble etc
        for performance benefit. for descending order use reversed() at the end. for chaining comparisons like
        first compare no of students the compare the reviews we have to use "thenComparing()". use method
        reference inside comparators to have the logic build.
         */
        Comparator<Course> compareNoOfStudentsIncreasing = Comparator.comparing(Course::getNoOfStudents);
        Comparator<Course> comparingNoOfStudentsDecreasing =
                Comparator.comparingInt(Course::getNoOfStudents).reversed();
        Comparator<Course> comparingNoOfStudentsAndReviewsDecreasing =
                Comparator.comparingInt(Course::getNoOfStudents)
                        .thenComparingInt(Course::getReviewScore).reversed();

        System.out.println(courses.stream().sorted(compareNoOfStudentsIncreasing).collect(Collectors.toList()));

        System.out.println(courses.stream().sorted(comparingNoOfStudentsDecreasing)
                .collect(Collectors.toList()));

        System.out.println(courses.stream().sorted(comparingNoOfStudentsAndReviewsDecreasing)
                .collect(Collectors.toList()));

        System.out.println(courses.stream().sorted(Comparator.comparing(Course::getName))
                .collect(Collectors.toList()));

        // Limit the results to only 4
        System.out.println(courses.stream().sorted(comparingNoOfStudentsDecreasing)
                .limit(4).collect(Collectors.toList()));
        // skip the first 3 elements
        System.out.println(courses.stream().sorted(comparingNoOfStudentsDecreasing)
                .skip(3).collect(Collectors.toList()));
        /* Returns, if this stream is ordered, a stream consisting of the longest prefix of elements taken from
         this stream that match the given predicate. Otherwise returns, if this stream is unordered, a stream
         consisting of a subset of elements taken from this stream that match the given predicate.
         Basically will return the elements in a sequential manner until the predicate is true, i.e as soon as
         an element doesn't satisfy the criteria, all the further elements are dropped.
         */
        System.out.println(courses.stream()
                .takeWhile(course -> course.getReviewScore() >= 95).collect(Collectors.toList()));

        /*
        Returns, if this stream is ordered, a stream consisting of the remaining elements of this stream after
        dropping the longest prefix of elements that match the given predicate. Otherwise returns, if this
        stream is unordered, a stream consisting of the remaining elements of this stream after dropping a
        subset of elements that match the given predicate.
        Basically, will drop or skip all the elements till the predicate is true, once the predicate is false
        for an element then all the other elements in the stream will be returned.s
         */
        System.out.println(courses.stream()
                .dropWhile(course -> course.getReviewScore() > 95).collect(Collectors.toList()));

        /* Returns the maximum element of this stream according to the provided Comparator. Since it returns a
        Optional hence had to use get() to get the element.
         */
        System.out.println(courses.stream().max(comparingNoOfStudentsAndReviewsDecreasing).get());

        // Returns the minimum element of this stream according to the provided Comparator.
        System.out.println(courses.stream().min(comparingNoOfStudentsAndReviewsDecreasing).get());

        /*
        here we have used filter in such a way that no results will come hence the min will give a Optional.empty
        which if we dont want then we have to return a default value which we can provide with orElse().
         */
        System.out.println(courses.stream()
                .filter(course -> course.getReviewScore() < 90)
                .min(comparingNoOfStudentsAndReviewsDecreasing)
                .orElse(new Course("Kubernetes", "Cloud", 91, 20000)));

        /*
        Returns an Optional describing the first element of this stream, or an empty Optional if the
        stream is empty. If the stream has no encounter order, then any element may be returned.
         */
        System.out.println(courses.stream()
                .filter(getReviewScoreGreaterThan97).findFirst().get());

        /*
        Returns an Optional describing some element of the stream, or an empty Optional if the stream is empty.
        The behavior of this operation is explicitly nondeterministic; it is free to select any element
        in the stream. This is to allow for maximal performance in parallel operations; the cost is that
        multiple invocations on the same source may not return the same result.
        (If a stable result is desired, use findFirst() instead.)
         */
        System.out.println(courses.stream()
                .filter(getReviewScoreGreaterThan97).findAny().get());

        /*
        Returns an OptionalDouble describing the arithmetic mean of elements of this stream, or an empty
        optional if this stream is empty. We need to use getAsDouble() to get the actual double value.
         */
        System.out.println(courses.stream()
                .filter(getReviewScoreGreaterThan97)
                .mapToInt(Course::getNoOfStudents)
                .average().getAsDouble());
        // Returns the count of elements in this stream. Can be used in intStream also.
        System.out.println(courses.stream()
                .filter(getReviewScoreGreaterThan97).count());

        // To group elements by category. Here the category is the Map key and the values are list of objects
        // which belong to that category.
        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory)));

        // To get the count of courses in each category
        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory, Collectors.counting())));

        // To get the highest reviewed scored course in each category
        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory,
                        Collectors.maxBy(Comparator.comparing(Course::getReviewScore)))));

        // To get the list of course names in each category
        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory,
                        Collectors.mapping(Course::getName,Collectors.toList()))));
        /*
        below 2 examples are use of higher order functions. That is functions which return function. here
        createPre...() returns a Predicate which is a function.
         */
        Predicate<Course> reviewScoreGreaterThan95Predicate2
                = createPredicateWithCutoffReviewScore(95);

        Predicate<Course> reviewScoreGreaterThan90Predicate2
                = createPredicateWithCutoffReviewScore(90);
    }

    private static Predicate<Course> createPredicateWithCutoffReviewScore(int cutoffReviewScore) {
        return course -> course.getReviewScore() > cutoffReviewScore;
    }
}

package Collections;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Stream {
    public static void main(String[] args) {
        final List<String> friends =Arrays.asList("Brain","John","Bobur"," 4 th people","Naimjon");
        friends.stream().skip(4).map(String::toUpperCase).forEach(System.out::println);

        friends.stream().dropWhile(name -> name.length()  > 4)
                .map(String::toUpperCase).forEach(System.out::println);

        System.out.println("Working with Limit first 3 element ");
        friends.stream().limit(3).map(String::toUpperCase).forEach(System.out::println);

        System.out.println("TakeWhile output");
        friends.stream().takeWhile(name->name.length()>4).forEach(System.out::println);

        System.out.println("Refactoring for reuseablity and maintibility we can use also as variable ");
        final Predicate<String> startWithN = name -> name.startsWith("N");
        final long count = friends.stream().filter(startWithN).count();

        System.out.println("we can use also pridicate as function");

        final long countFriendsStartWith = friends.stream().filter(checkIfStartWith("N")).count();
        System.out.println(countFriendsStartWith);

        Function<String, Predicate<String>> startWithLetters =letter -> name -> name.startsWith(letter);
        final long countStartWithB = friends.stream().filter(startWithLetters.apply("B")).count();


    }

    public static Predicate<String> checkIfStartWith( final String letter){
        return name -> name.startsWith(letter);

        
    }




}

package Assignment3;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.List;
import java.util.Map;
import java.util.AbstractMap.SimpleEntry;
import java.util.stream.Stream;

public class assignment3 {

    public static void main(String[] args) {
        List<String> words = List.of("java","is","cool","but","challenging");

        Map<Integer, List<String>> groupLength = words.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println(groupLength);


        System.out.println("Second answer of the question  is below ");
        List<Integer> numbers = List.of(1, 2, 3, 2, 3, 4, 3, 5, 4, 6, 7, 3, 8, 3, 9);
        Map<Integer , Long> occurrence = numbers.stream()
                .collect(Collectors.groupingBy(i ->i, Collectors.counting()));
        System.out.println(occurrence);
        Map.Entry<Integer, Long> maxEntry = occurrence.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow();
        Integer mostFrequent = maxEntry.getKey();

        System.out.println("Most Frequent Element: " + mostFrequent);

        System.out.println("Third one is here below ");

        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        OptionalDouble average = nums.stream()
                .mapToDouble(Integer::doubleValue)
                .average();
        if (average.isPresent()) {
            System.out.println("The average is: " + average.getAsDouble());
        } else {
            System.out.println("Could not calculate the average.");
        }

        System.out.println("Question 4: Given two lists, one of keys and one of values, create a map by zipping them together");
        List<String> keys = List.of("one", "two", "three");
        List<Integer> values = List.of(1, 2, 3);

        Map<String, Integer> map;
        map=IntStream.range(0, Math.min(keys.size(), values.size()))
                .mapToObj(index -> new SimpleEntry<>(keys.get(index), values.get(index)))
                .collect(Collectors.toMap(SimpleEntry::getKey, SimpleEntry::getValue));

        System.out.println(map);

        System.out.println("Question 5 ");
        Stream<String> word = Stream.of("Java", "Functional", "Programming", "Collector");

        Collector<String, ?, List<String>> uppercaseCollector = Collector.of(
                ArrayList::new,
                (list, elem) -> list.add(elem.toUpperCase()),
                (list1, list2) -> {
                    list1.addAll(list2);
                    return list1;
                }
        );

        // Use the custom collector
        List<String> resultList = word.collect(uppercaseCollector);

        // Print the result
        System.out.println(resultList);

    }
}

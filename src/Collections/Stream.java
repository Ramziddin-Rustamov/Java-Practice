package Collections;

import java.util.Arrays;
import java.util.List;

public class Stream {
    public static void main(String[] args) {
        final List<String> friends =Arrays.asList("Brain","John","Bobur");
        friends.stream().skip(4).map(String::toUpperCase).forEach(System.out::println);

        friends.stream().dropWhile(name -> name.length()  > 4)
                .map(String::toUpperCase).forEach(System.out::println);
    }
}

package javasolution.easy.fizz_buzz;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println(fizzBuzz(22));
    }

    public static List<String> fizzBuzz(int n) {
        List<String> strings = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                strings.add("FizzBuzz");
            } else if (i % 3 == 0) {
                strings.add("Fizz");
            } else if (i % 5 == 0) {
                strings.add("Buzz");
            } else {
                strings.add(String.valueOf(i));
            }
        }

        return strings;
    }
}

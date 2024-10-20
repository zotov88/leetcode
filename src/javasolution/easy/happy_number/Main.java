package javasolution.easy.happy_number;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println(isHappy(16));
    }

    public static boolean isHappy(int n) {
        Set<Integer> integers = new HashSet<>();

        while (integers.add(n)) {
            int result = 0;
            while (n > 0) {
                int digit = n % 10;
                result += digit * digit;
                n /= 10;
            }
            if (result == 1) {
                return true;
            }
            n = result;
        }

        return false;
    }
}

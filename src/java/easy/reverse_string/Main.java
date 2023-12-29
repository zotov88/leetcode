package java.easy.reverse_string;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        char[] s = new char[]{'H'};
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }

    public static void reverseString(char[] s) {
        for (int i = 0, j = s.length - 1; i < s.length / 2; i++, j--) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
        }
    }
}

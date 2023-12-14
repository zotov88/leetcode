package easy.largest_odd_number_in_string;

public class Main {

    public static void main(String[] args) {
        System.out.println(largestOddNumber("54678"));
    }

    public static String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            if ((num.charAt(i) - 48) % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }
}

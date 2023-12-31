package javasolution.easy.largest_3_same_digit_number_in_string;

public class Main {

    public static void main(String[] args) {
        System.out.println(largestGoodInteger("677713333"));
    }

    public static String largestGoodInteger(String num) {
        char ch = ' ';
        int count = 0;

        for (int i = 1; i < num.length(); i++) {
            if (num.charAt(i) == num.charAt(i - 1)) {
                count++;
                if (count == 2 && num.charAt(i) >= ch) {
                    ch = num.charAt(i);
                }
            } else {
                count = 0;
            }

            if (ch == '9') {
                break;
            }
        }

        return ch == ' ' ? "" : String.valueOf(ch).repeat(3);
    }
}

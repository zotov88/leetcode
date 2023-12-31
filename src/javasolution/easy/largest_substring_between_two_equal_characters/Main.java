package javasolution.easy.largest_substring_between_two_equal_characters;

public class Main {

    public static void main(String[] args) {
        System.out.println(maxLengthBetweenEqualCharacters("aaqalacc"));
    }

    public static int maxLengthBetweenEqualCharacters(String s) {
        int maxLength = -1;
        int first, last;
        for (int i = 0; i < s.length(); i++) {
            first = s.indexOf(s.charAt(i)) + 1;
            int length = -1;
            if ((last = s.lastIndexOf(s.charAt(i))) != -1) {
                length = last - first;
            }
            if (length > maxLength) {
                maxLength = length;
            }
        }
        return maxLength;
    }
}

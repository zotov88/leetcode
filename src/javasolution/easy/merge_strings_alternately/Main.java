package javasolution.easy.merge_strings_alternately;

public class Main {

    public static void main(String[] args) {
        System.out.println(mergeAlternately("abcvv", "pqrs"));
    }

    public static String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int size = Math.min(word1.length(), word2.length());

        for (int i = 0; i < size; i++) {
            sb.append(word1.charAt(i)).append(word2.charAt(i));
        }

        if (word1.length() > word2.length()) {
            sb.append(word1.substring(word2.length()));
        } else {
            sb.append(word2.substring(word1.length()));
        }

        return sb.toString();
    }
}

package javasolution.easy.Is_Subsequence;

public class Main {
    public static void main(String[] args) {
        String s1 = "axc";
        String s2 = "ahbgdc";
        System.out.println(isSubsequence(s1, s2));
    }

    private static boolean isSubsequence(String s1, String s2) {
        int i = 0;
        for (int j = 0; i < s1.length() && j < s2.length(); j++) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
            }
        }
        return i == s1.length();
    }
}

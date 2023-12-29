package java.medium.Longest_Substring_Without_Repeating_Characters;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("bbbbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int result = 0;
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            while (list.contains(s.charAt(i))) {
                list.removeFirst();
            }
            list.add(s.charAt(i));
            result = Math.max(result, list.size());
        }
        return result;
    }
}

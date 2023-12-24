package easy.maximum_score_after_splitting_a_string;

public class Main {

    public static void main(String[] args) {
        String s = "100";
        System.out.println(maxScore(s));
    }

    public static int maxScore(String s) {
        int sum = 0;
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            int tmpSum = getSumOfInterval(chars, 0, i, '0') +
                    getSumOfInterval(chars, i, chars.length, '1');
            if (tmpSum > sum) {
                sum = tmpSum;
            }
        }
        return sum;
    }

    private static int getSumOfInterval(char[] chars, int start, int end, char ch) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            if (chars[i] == ch) {
                sum++;
            }
        }
        return sum;
    }
}

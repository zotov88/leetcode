package javasolution.easy.count_of_matches_in_tournament;

public class Main {

    public static void main(String[] args) {
        System.out.println(numberOfMatches(200));
    }

    public static int numberOfMatches(int n) {
        if (n == 1) {
            return 0;
        }
        int result = n / 2;
        if (result == 1 && n % 2 == 0) {
            return result;
        }
        return result + numberOfMatches(result + n % 2);
    }
}

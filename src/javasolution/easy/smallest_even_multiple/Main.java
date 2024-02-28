package javasolution.easy.smallest_even_multiple;

public class Main {
    public static void main(String[] args) {
        System.out.println(smallestEvenMultiple(7));
    }

    public static int smallestEvenMultiple(int n) {
        if (n % 2 == 0) {
            return n;
        }
        return n + n;
    }
}

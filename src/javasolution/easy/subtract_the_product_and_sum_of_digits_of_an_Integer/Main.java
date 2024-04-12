package javasolution.easy.subtract_the_product_and_sum_of_digits_of_an_Integer;

public class Main {
    public static void main(String[] args) {
        System.out.println(subtractProductAndSum(4421));
    }

    public static int subtractProductAndSum(int n) {
        int product = (n == 0) ? 0 : 1;
        int sum = 0;

        while (n > 0) {
            int num = n % 10;
            product *= num;
            sum += num;
            n /= 10;
        }

        return product - sum;
    }
}

package java.easy.buy_two_chocolates;

public class Main {

    public static void main(String[] args) {
        int[] prices = new int[]{98, 54, 6, 34, 66, 63, 52, 39, 62};
        int money = 62;
        System.out.println(buyChoco(prices, money));
    }

    public static int buyChoco(int[] prices, int money) {
        int firstMinPrice = Math.min(prices[0], prices[1]);
        int secondMinPrice = Math.max(prices[0], prices[1]);

        for (int i = 2; i < prices.length; i++) {
            if (prices[i] <= firstMinPrice) {
                secondMinPrice = firstMinPrice;
                firstMinPrice = prices[i];
            } else if (prices[i] < secondMinPrice) {
                secondMinPrice = prices[i];
            }
        }

        return firstMinPrice + secondMinPrice > money ? money : money - firstMinPrice - secondMinPrice;
    }
}

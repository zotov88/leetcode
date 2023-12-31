package javasolution.easy.calculate_money_in_leetcode_bank;

public class Main {

    public static void main(String[] args) {
        System.out.println(totalMoney(20));
    }

    public static int totalMoney(int n) {
        int totalWeeks = n / 7;
        int remainingDays = n % 7;
        int result = 0;
        int firstWeekMoney = 28;

        while (totalWeeks > 0) {
            result += firstWeekMoney + 7 * --totalWeeks;
        }

        int moneyLastWeek = (n / 7) + 1;
        for (int i = 0; i < remainingDays; i++) {
            result += moneyLastWeek++;
        }

        return result;
    }
}

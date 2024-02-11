package javasolution.easy.add_digits;

public class Main {
    public static void main(String[] args) {
        System.out.println(addDigits(15499));
    }

    public static int addDigits(int num) {
        if (num < 10) {
            return num;
        }

        int result = 0;
        while (num > 0) {
            result += num % 10;
            num /= 10;
        }

        return addDigits(result);
    }
}

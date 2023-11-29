package easy.missing_number;

public class Main {

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }

    public static int missingNumber(int[] nums) {
        int expect = 0;
        int real = 0;

        for (int i = 0; i <= nums.length; i++) {
            expect += i;
            real = i < nums.length ? real + nums[i] : real;
        }

        return expect - real;
    }
}

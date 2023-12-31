package javasolution.easy.number_of_1_bits;

public class Main {

    public static void main(String[] args) {

        System.out.println(hammingWeight(000000000000000000000100001011));
    }

    public static int hammingWeight(int n) {
        int count = 0;

        for (int i = 0; i < 32; i++) {
            count = (n & 1) == 1 ? count + 1 : count;
            n = n >> 1;
        }

        return count;
    }

}

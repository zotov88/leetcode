package javasolution.easy.can_place_flowers;

public class Main {

    public static void main(String[] args) {
        int[] flowerbed = new int[]{0, 0, 0};
        int n = 0;
        System.out.println(canPlaceFlowers(flowerbed, n));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }

        if (flowerbed.length == 1 && flowerbed[0] == 0) {
            return true;
        }

        int zeroesInRow = 0;
        if (flowerbed[0] == 0 && flowerbed[1] == 0) {
            n--;
        }
        if (n == 0) {
            return true;
        }

        for (int i = 1; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                zeroesInRow++;
            } else {
                zeroesInRow = 0;
            }
            if (zeroesInRow == 3) {
                n--;
                zeroesInRow = 1;
            }
            if (n == 0) {
                return true;
            }
        }

        if (zeroesInRow == 2) {
            n--;
        }
        return n == 0;
    }
}

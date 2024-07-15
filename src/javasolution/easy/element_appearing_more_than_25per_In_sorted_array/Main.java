package javasolution.easy.element_appearing_more_than_25per_In_sorted_array;

public class Main {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 6, 6, 6, 6, 7, 10};
        System.out.println(findSpecialInteger(arr));
    }

    public static int findSpecialInteger(int[] arr) {
        int countNumsMoreIn25Percent = arr.length / 4 + 1;
        int result = arr[0];
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (count >= countNumsMoreIn25Percent) {
                break;
            }
            if (arr[i] == result) {
                count++;
            } else {
                result = arr[i];
                count = 1;
            }
        }
        return result;
    }
}

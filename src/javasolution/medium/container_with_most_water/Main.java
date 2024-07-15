package javasolution.medium.container_with_most_water;

public class Main {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }

    private static int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int tmpArea = Math.min(height[left], height[right]) * (right - left);
            if (tmpArea > maxArea) {
                maxArea = tmpArea;
            }
            if (height[left] < height[right]) {
                left++;
            } else if (height[left] > height[right]) {
                right--;
            } else {
                left++;
                right--;
            }
        }
        return maxArea;
    }

    private static int maxArea1(int[] height) {
        int maxArea = 0;
        int previousHeightLeftBoard = 0;
        for (int i = 0; i < height.length - 1; i++) {
            if (height[i] <= previousHeightLeftBoard) {
                continue;
            }
            for (int j = height.length - 1; j > i; j--) {
                int tmpArea = Math.min(height[i], height[j]) * (j - i);
                if (tmpArea > maxArea) {
                    maxArea = tmpArea;
                }
                if (height[j] >= height[i]) {
                    break;
                }
            }
            previousHeightLeftBoard = height[i];
        }
        return maxArea;
    }
}

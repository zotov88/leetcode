package javasolution.medium.furthest_building_you_can_reach;

public class Main {
    public static void main(String[] args) {

        //TODO не проходит этот случай. Ответ 5, а у меня 3
        int[] heights = {1, 5, 1, 2, 3, 4, 10000};
        int bricks = 4;
        int ladders = 1;

        System.out.println(furthestBuilding(heights, bricks, ladders));
    }

    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        for (int i = 0; i < heights.length - 1; i++) {
            int different = heights[i + 1] - heights[i];
            if (different > 0) {
                if (bricks >= different) {
                    bricks -= different;
                } else if (ladders > 0) {
                    ladders--;
                } else {
                    return i;
                }
            }
        }

        return heights.length - 1;
    }
}

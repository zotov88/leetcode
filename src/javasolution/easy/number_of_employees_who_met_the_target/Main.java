package javasolution.easy.number_of_employees_who_met_the_target;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] hours = {0, 1, 2, 3, 4};
        int target = 2;

        System.out.println(numberOfEmployeesWhoMetTarget(hours, target));
    }

    public static int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        return (int) Arrays.stream(hours)
                .filter(hour -> hour >= target)
                .count();
    }
}

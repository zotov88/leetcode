package javasolution.easy.design_parking_system;

public class Main {
    public static void main(String[] args) {
        ParkingSystem parkingSystem = new ParkingSystem(2, 2, 1);
        System.out.println(parkingSystem.addCar(2));
        System.out.println(parkingSystem.addCar(2));
        System.out.println(parkingSystem.addCar(3));
        System.out.println(parkingSystem.addCar(3));
    }

    static class ParkingSystem {

        private int big;
        private int medium;
        private int small;

        public ParkingSystem(int big, int medium, int small) {
            this.big = big;
            this.medium = medium;
            this.small = small;
        }

        public boolean addCar(int carType) {
            return switch (carType) {
                case 1 -> checkBig();
                case 2 -> checkMedium();
                case 3 -> checkSmall();
                default -> false;
            };
        }

        private boolean checkBig() {
            if (big > 0) {
                big--;
                return true;
            }
            return false;
        }

        private boolean checkMedium() {
            if (medium > 0) {
                medium--;
                return true;
            }
            return false;
        }

        private boolean checkSmall() {
            if (small > 0) {
                small--;
                return true;
            }
            return false;
        }
    }
}

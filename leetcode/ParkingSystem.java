/*
        https://leetcode.com/problems/design-parking-system/
*/
class ParkingSystem {
    int[] store;

    public ParkingSystem(int big, int medium, int small) {
        store = new int[4];
        store[1]= big;
        store[2] = medium;
        store[3] = small;
    }

    public boolean addCar(int carType) {
        if(store[carType] == 0) return false;
        store[carType]--;
        return true;
    }

    public static void main(String[] args) {
        ParkingSystem obj = new ParkingSystem(1, 1, 0);
        System.out.println(obj.addCar(1));
        System.out.println(obj.addCar(2));
        System.out.println(obj.addCar(3));
        System.out.println(obj.addCar(1));
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */

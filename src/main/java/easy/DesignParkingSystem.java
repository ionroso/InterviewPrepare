package easy;

public class DesignParkingSystem {
    class ParkingSystem {
        int [] slots;
        public ParkingSystem(int big, int medium, int small) {

            slots = new int[]{big, medium, small};
        }

        public boolean addCar(int carType) {
            boolean available = false;
            if(slots[carType-1]>0){
                slots[carType-1]--;
                available = true;
            }

            return available;
        }
    }

}

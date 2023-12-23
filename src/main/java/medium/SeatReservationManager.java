package medium;

import java.util.PriorityQueue;

public class SeatReservationManager {
    public static void main(String[] args) {

    }



    static
    class SeatManager {

        PriorityQueue<Integer> pq;
        public SeatManager(int n) {
            pq = new PriorityQueue<>();
            for (int i = 0; i < n; i++) {
                pq.offer(i);
            }
        }

        public int reserve() {
            return pq.poll();
        }

        public void unreserve(int seatNumber) {
            pq.offer(seatNumber);
        }
    }
}

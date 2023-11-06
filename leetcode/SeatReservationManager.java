import java.util.*;

/*
	https://leetcode.com/problems/seat-reservation-manager/description/
*/
class SeatReservationManager {
	public static void main(String... args) {
 		SeatManager manager = new SeatManager(5);
 		System.out.println(manager.reserve()); // 1
 		System.out.println(manager.reserve()); // 2
 		manager.unreserve(2);
 		System.out.println(manager.reserve()); // 2
 		System.out.println(manager.reserve()); // 3
 		System.out.println(manager.reserve()); // 4
 		System.out.println(manager.reserve()); // 5

	}
}

class SeatManager {

    private final PriorityQueue<Integer> que;
    private int curr = 1;
    public SeatManager(int n) {
        this.que = new PriorityQueue<>((a,b) -> Integer.compare(a,b));
    }

    public int reserve() {
        if (que.isEmpty()) {
            return curr++;
        }
        return que.poll();
    }

    public void unreserve(int seatNumber) {
        que.offer(seatNumber);
    }
}

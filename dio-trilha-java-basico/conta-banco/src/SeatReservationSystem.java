/**
 * The `SeatReservationSystem` class is responsible for managing the reservation of seats in a seating system.
 * It provides methods to reserve, cancel, and view the status of seat reservations.
 */
import java.util.*;

public class SeatReservationSystem {
    public static int[] solution(int N, int K, int[] seat) {
        TreeSet<Integer> reservedSeats = new TreeSet<>();
        List<Integer> result = new ArrayList<>();
        
        // Track next unreserved seat
        int nextAvailableSeat = 1;
        
        for (int i = 0; i < K; i++) {
            if (seat[i] == 0) {
                // Reserve the smallest available seat
                while (reservedSeats.contains(nextAvailableSeat)) {
                    nextAvailableSeat++;
                }
                reservedSeats.add(nextAvailableSeat);
                result.add(nextAvailableSeat);
                nextAvailableSeat++;  // Increment for the next reservation
            } else {
                // Cancel the reservation of seat[i]
                reservedSeats.remove(seat[i]);
                nextAvailableSeat = Math.min(nextAvailableSeat, seat[i]);
            }
        }
        
        // Convert result list to array
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int[] seat = new int[K];
        for (int i = 0; i < K; i++) {
            seat[i] = scanner.nextInt();
        }

        int[] result = solution(N, K, seat);
        for (int res : result) {
            System.out.print(res + " ");
        }
    }
}

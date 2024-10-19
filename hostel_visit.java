import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class hostel_visit {
      public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Q = sc.nextInt(); // Total number of queries
        int K = sc.nextInt(); // K nearest hostels

        // Max-heap to store the distances of the nearest K hostels
        PriorityQueue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < Q; i++) {
            int type = sc.nextInt();

            if (type == 1) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                long distance = (long) x * x + (long) y * y;

                if (maxHeap.size() < K) {
                    maxHeap.offer(distance);
                } else if (distance < maxHeap.peek()) {
                    maxHeap.poll(); // Remove the largest distance in the heap
                    maxHeap.offer(distance); // Add the smaller distance
                }

            } else if (type == 2) {
                // Output the Kth nearest distance
                System.out.println(maxHeap.peek());
            }
        }
        sc.close();
    }
}

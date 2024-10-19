import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class median_in_stream_of_running_integers {
      public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases

        while (t-- > 0) {
            int n = sc.nextInt(); // Number of elements in the data stream
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            findRunningMedian(arr, n);
        }
        sc.close();
    }

    public static void findRunningMedian(int[] arr, int n) {
        // Max heap for the smaller half
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        // Min heap for the larger half
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int num = arr[i];

            // Add the number to the maxHeap
            if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }

            // Balance the heaps so that the size difference is at most 1
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            } else if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }

            // Find and print the median
            if (maxHeap.size() == minHeap.size()) {
                System.out.print((maxHeap.peek() + minHeap.peek()) / 2 + " ");
            } else {
                System.out.print(maxHeap.peek() + " ");
            }
        }
        System.out.println(); // For a new line after each test case
    }
}

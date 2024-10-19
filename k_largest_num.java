import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class k_largest_num {
     public static void main (String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            int n=sc.nextInt();
            int k=sc.nextInt();
             PriorityQueue<Integer> pq
                = new PriorityQueue<Integer>(
                    Collections.reverseOrder());

            for(int i=0;i<n;i++){
                pq.add(sc.nextInt());
            }
             for (int i = 0; i < k - 1; i++) {
                pq.poll();
            }
            System.out.print(pq.poll());
        }

    }
}

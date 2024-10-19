import java.util.PriorityQueue;
import java.util.Scanner;

public class merge_k_sorted_array {
     public static void main(String args[]) {
        @SuppressWarnings("resource")
        Scanner sc=new Scanner(System.in);
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
        int k=sc.nextInt();
        int n=sc.nextInt();
        for(int i=0;i<n*k;i++){
            pq.add(sc.nextInt());
        }
        for(int i=0;i<n*k;i++){
          System.out.print(pq.poll()+" ");
        }
    }
}

import java.util.*;
public class Unlock {
    public static void main(String args[]) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Map<Integer, Integer> position = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            maxHeap.add(arr[i]);
            position.put(arr[i], i);
        }
        
        for (int i = 0; i < n && k > 0; i++) {
            int largest = maxHeap.poll();
            
            if (arr[i] == largest) {
                continue;
            }
            
            int largestPos = position.get(largest);
            
            position.put(arr[i], largestPos);
            position.put(largest, i);
            
            int temp = arr[i];
            arr[i] = arr[largestPos];
            arr[largestPos] = temp;
            
            k--;
        }
        
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

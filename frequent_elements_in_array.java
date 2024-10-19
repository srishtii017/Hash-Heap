import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class frequent_elements_in_array {
       public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int K = scanner.nextInt();
        

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int num = scanner.nextInt();
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
 
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
            (a, b) -> b.getValue() - a.getValue()
        );

        maxHeap.addAll(frequencyMap.entrySet());
 
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            result.add(maxHeap.poll().getKey());
        }
        Collections.sort(result);

        for (int num : result) {
            System.out.print(num + " ");
        }
       
       
    }
}

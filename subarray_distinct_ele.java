import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class subarray_distinct_ele {
     public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        long MOD = 1000000007;
        long ans = 0;
        int start = 0;
        Map<Integer, Integer> lastIndex = new HashMap<>();
        
        for (int end = 0; end < n; end++) {
            if (lastIndex.containsKey(arr[end])) {
                start = Math.max(start, lastIndex.get(arr[end]) + 1);
            }
            
            ans += (end - start + 1) * (end - start + 2) / 2; // sum of subarray lengths
            ans %= MOD;
            lastIndex.put(arr[end], end);
        }
        
        System.out.println(ans);
    }
}

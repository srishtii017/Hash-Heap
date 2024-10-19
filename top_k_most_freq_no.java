import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class top_k_most_freq_no {
      public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            
            // Read the array elements
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            
            Map<Integer, Integer> map = new HashMap<>();
            List<String> ans = new ArrayList<>();
            
            for (int i = 0; i < n; i++) {
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
                
                List<Map.Entry<Integer, Integer>> ls = new ArrayList<>(map.entrySet());
                ls.sort((a, b) -> {
                    if (b.getValue().equals(a.getValue())) {
                        return Integer.compare(a.getKey(), b.getKey());
                    }
                    return Integer.compare(b.getValue(), a.getValue());
                });
                
                StringBuilder sb = new StringBuilder();
                int limit = Math.min(k, ls.size());
                for (int j = 0; j < limit; j++) {
                    sb.append(ls.get(j).getKey()).append(" ");
                }
                ans.add(sb.toString().trim());
            }
            for (String result : ans) {
                System.out.print(result+" ");
            }
            System.out.println();
        }
        
        sc.close();
    }
}


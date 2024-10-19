import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
public class Exist_or_Not {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int t = 0; t < T; t++) {
            int L = sc.nextInt();
            int[] arr = new int[L];
            for (int i = 0; i < L; i++) {
                arr[i] = sc.nextInt();
            }
            
            Set<Integer> set = new HashSet<>();
            for (int num : arr) {
                set.add(num);
            }
            
            int Q = sc.nextInt();
            for (int q = 0; q < Q; q++) {
                int query = sc.nextInt();
                if (set.contains(query)) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
        }
        
        sc.close();
}
}

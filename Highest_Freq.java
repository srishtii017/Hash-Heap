import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Highest_Freq {
    public static void main (String args[]) {
        @SuppressWarnings("resource")
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        Map<Integer,Integer> freqMap=new HashMap<>();
        int maxf=0;
        int mostfno=arr[0];
        for(int num:arr){
            int freq=freqMap.getOrDefault(num,0)+1;
            freqMap.put(num,freq);
            if(freq>maxf){
                maxf=freq;
                mostfno=num;
            }

        }
        System.out.print(mostfno);
    }
}

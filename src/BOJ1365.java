import java.net.Inet4Address;
import java.util.*;

public class BOJ1365 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int []arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }
        ArrayList<Integer> dp = new ArrayList<Integer>();
        dp.add(arr[0]);

        for(int i=1; i<N; i++){
            if( arr[i]> dp.get(dp.size()-1)){
                dp.add(arr[i]);
            }else{
                int idx = Collections.binarySearch(dp, arr[i]);
                 if(idx <0){
                     idx = (-idx-1);
                 }
                dp.set(idx, arr[i]);
            }

        }

        System.out.println(N-dp.size());


    }
}

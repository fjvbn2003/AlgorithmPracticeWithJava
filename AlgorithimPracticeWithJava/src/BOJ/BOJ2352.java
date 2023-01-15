package BOJ;
import java.util.*;
public class BOJ2352 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt()-1;
        }
        int []dp = new int[n];
        for(int i=0; i<n; i++) dp[i] = 1;
        int ans = 1;
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(arr[j]<arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            ans = Math.max(dp[i], ans);
        }
        System.out.println(ans);

        return;
    }

}

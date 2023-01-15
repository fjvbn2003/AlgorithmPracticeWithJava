package BOJ;
import java.util.*;


public class BOJ2980 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();
        int [][] arr = new int[101][3];
        for(int i=0; i<N; i++){
            int D = sc.nextInt();
            int R = sc.nextInt();
            int G = sc.nextInt();
            arr[i][0] = D;
            arr[i][1] = R;
            arr[i][2] = G;
        }
        int times = 0;
        int before = 0;
        for(int i=0; i<N; i++){
            times += (arr[i][0]-before);
            int t  = (times)%(arr[i][1]+arr[i][2]);
            if(t<arr[i][1]){
                times += (arr[i][1]-t);
            }
            before = arr[i][0];
        }
        times += (L-before);
        System.out.println(times);

    }
}

package BOJ;
import java.util.*;

// BOJ 1484 Brute Force

public class BOJ1484 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long  G = sc.nextInt();
        ArrayList<Long> arr  = new ArrayList<>();
        for(long i=2; i<123456789; i++){
            for(long j=i-1; j>=1; j--){
                long a = i*i;
                long b = j*j;
                if(a - b >G){break;}
                if(a-b ==G){
                    arr.add(i);
                    break;
                }
            }
        }
        if(arr.size() ==0){
            System.out.println(-1);
        }else{
            for(int i = 0; i<arr.size(); i++){
                System.out.println(arr.get(i));
            }
        }

    }
}

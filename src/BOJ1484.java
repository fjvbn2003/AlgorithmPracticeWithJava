import java.util.*;
// 훌륭한 개발자는 주석을 단다.
// 나는 훌륭한 개발자가 되고싶기 때문에 주석을 달고 있다.
// 그러므로 나는 훌륭한 개발자가 되어가는 중이다.

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

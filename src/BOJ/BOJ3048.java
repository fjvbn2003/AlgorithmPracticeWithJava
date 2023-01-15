package BOJ;
import java.util.*;
public class BOJ3048 {

    static int N1, N2, T;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N1 = sc.nextInt();
        N2 = sc.nextInt();
        String s1, s2;
        s1 = sc.next();
        s2 = sc.next();
        T = sc.nextInt();
        int n1 =  s1.length();
        int n2 = s2.length();
        ArrayList<Character> arr = new ArrayList<>();

        int n2_idx = 0;
        for(int i=n1-1; i>=0; i--){
            int cur_time = i+1;
            if(n2_idx>=n2){
                arr.add(s1.charAt(i));
            }else{
                int n2_time = T-n2_idx;
                while(n2_idx < n2 && n2_time>= cur_time){
                    arr.add(s2.charAt(n2_idx));
                    n2_idx++;
                    n2_time = T-n2_idx;
                }
                arr.add(s1.charAt(i));
            }
        }
        while(n2_idx<n2){
            arr.add(s2.charAt(n2_idx));
            n2_idx++;
        }
        for(int i=0; i<arr.size(); i++){
            System.out.print(arr.get(i));
        }

    }

}

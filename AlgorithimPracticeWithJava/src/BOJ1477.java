import java.util.*;

public class BOJ1477 {

    public static boolean possible(int[] arr, int mid, int remain, int L){
        int before = 0;
        for(int i=0; i<arr.length; i++){
            while(arr[i]-before > mid){
                remain--;
                if(remain<0) return false;
                before +=mid;
            }
            before= arr[i];
        }
        while (L-before >mid){
            remain--;
            if(remain<0) return false;
            before +=mid;
        }
        if(remain>=0){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        int N, M, L;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        L = sc.nextInt();
        int []arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
//        for(int i: arr){
//            System.out.print(i+" ");
//        }
        // 이진탐색(parametric search)
        int left = 0;
        int right = 1000;
        while (left<right){
            int mid = (left+right)/2;
            boolean t = possible(arr, mid, M, L);
            //System.out.println("mid: "+mid+ "t: "+ t);

            if(t){
                right = mid;
            }else{
                left = mid+1;
            }
        }

        System.out.println(left);
    }
}

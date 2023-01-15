package BOJ;
import java.util.*;

// BOJ17404 RGB 거리 2

public class BOJ17404 {
    static int N;
    static ArrayList<int[] > arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new ArrayList<int[]>();
        for(int i =0; i<N; i++){
            int[] tmp = new int[3];
            for(int j=0; j<3; j++){
                tmp[j] = sc.nextInt();
            }
            arr.add(tmp);
        }
        int ans = 1234567890;

        for(int target = 0; target<3; target++){
            ArrayList<int[]> dp = new ArrayList<>();
            for(int i=0; i<N; i++){
                dp.add(new int[3]);
            }
            //0번을 먼저 채워본다.
            for(int i=0; i<3; i++){
                if(i == target){
                    dp.get(0)[target] = arr.get(0)[target];
                }else{
                    dp.get(0)[i] = 1234567890;
                }

            }

            // N-2까지만 채우고 N-1은 나중에 채운다. 첫 숫자를 보고.
            for(int i=1; i<N; i++){
                // 맨 마지막 원소는 1또는 2중에 선택해야 함.
                for(int j=0; j<3; j++){
                    int min_before =1234567890;
                    int min_idx = -1;
                    for(int k=0; k<3; k++){
                        if(i==N-1){
                            if(j==target){
                                min_before = 1234567890;
                                break;
                            }
                        }
                        if(j ==k) continue;
                        if(min_before> dp.get(i-1)[k]){
                            min_before = dp.get(i-1)[k];
                            min_idx = k;
                        }
                    }
                    dp.get(i)[j] = min_before+arr.get(i)[j];
                }

            }
            for(int i=0; i<3; i++){
                ans = Math.min(ans, dp.get(N-1)[i]);
            }

        }
        System.out.println(ans);





        // 색깔을 고정하는 아이디어..!

        //for debugging
        /*
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                System.out.print(arr.get(i)[j] +" ");
            }
            System.out.println();
        }
        */

    }


}

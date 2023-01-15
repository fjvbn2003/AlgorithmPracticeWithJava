package BOJ;
import java.util.Arrays;
import java.util.Scanner;
public class BOJ2480 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] num = new int[3];
        num[0] = sc.nextInt();
        num[1] = sc.nextInt();
        num[2] = sc.nextInt();
        boolean[] booleans = new boolean[3];
        Arrays.sort(num);
        int answer = 0;
        int max = -1;
        for(int i=0; i<3; i++){
            int tmp_cnt = 1;
            if(max < num[i]) max = num[i];
            if(booleans[i] == false){
                booleans[i] = true;
                for(int j=i+1; j<3; j++){
                    if(num[i]== num[j]){
                        tmp_cnt+=1;
                        booleans[j] = true;
                    }
                }
            }
            if(tmp_cnt ==3){
                answer = 10000+num[i]*1000;
                break;
            }else if(tmp_cnt ==2){
                answer = 1000+num[i]*100;
                break;
            }
        }
        if(answer == 0){
            answer = max*100;
        }
        System.out.println(answer);

    }
}

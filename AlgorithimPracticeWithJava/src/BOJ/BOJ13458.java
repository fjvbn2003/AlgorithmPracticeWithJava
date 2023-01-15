package BOJ;
import java.io.*;
import java.util.*;

public class BOJ13458 {
    static int N;
    static int B, C;
    static int[] persons;
    static long answer =0;
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("input.txt"));
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        persons = new int[N];
        for(int i=0; i<N; i++){
            persons[i] = sc.nextInt();
        }
        B = sc.nextInt();
        C = sc.nextInt();
        for(int i=0; i<N; i++){
            if(persons[i]<=B) {
                answer+=1;
            }
            else{
                if((persons[i]-B)%C == 0){
                    answer += ((persons[i]-B)/C)+1;

                }else{
                    answer += ((persons[i]-B)/C)+2;
                }
            }
        }
        System.out.println(answer);
    }
}

import java.util.*;


public class BOJ17351 {
    // 클래스를 생성하지 않아도 사용하기 위해서 static 변수로 생성.
    static int N;
    static int[] Score = new int[100];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for( int i=0; i<N; i++){
            Score[i] = sc.nextInt();
        }
    }
}

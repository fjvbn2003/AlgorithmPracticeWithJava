import java.util.Scanner;

public class ArrayInputOuput {

    static int N;
    static int[] Score = new int[100];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for( int i=0; i<N; i++){
            Score[i] = sc.nextInt();
        }
        for(int i=0; i<N; i++){
            System.out.print(Score[i]+" ");
            
        }

    }
}

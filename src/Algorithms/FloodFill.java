package Algorithms;
import java.util.*;
public class FloodFill {
    // static 키워드는 클래스가 정의되는 순간 할당됨.
    // 클래스에 유일하게 존재.
    static int N;
    static int[][] Board = new int[100][100];
    static void fill(int r, int c){
        if(r<0 || r>N-1 || c<0 || c>N-1) return;
        if(Board[r][c] !=0 ) return;
        Board[r][c] =1;
        fill(r-1, c);
        fill(r+1, c);
        fill(r, c-1);
        fill(r, c+1);
        return;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for(int i=0; i<N; i++)
            for(int j=0; j<N; j++)
                Board[i][j] = sc.nextInt();
        int sRow, sCol;
        sRow = sc.nextInt(); sCol = sc.nextInt();
        fill(sRow, sCol);

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                System.out.print(Board[i][j]+" ");
            }
            System.out.println();
        }


    }
}

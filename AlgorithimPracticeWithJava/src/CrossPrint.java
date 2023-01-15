import java.util.*;
/*
input:
4 4
0 0 0 0
0 0 2 0
0 0 2 0
2 2 0 0
1 1

output:
0 1 0 0
1 1 2 0
0 1 2 0
2 2 0 0

 */

public class CrossPrint {
    static int Row, Col, Sr, Sc;
    static int[][] board = new int[100][100];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Row = sc.nextInt();
        Col = sc.nextInt();
        for(int i=0; i<Row; i++)
            for(int j=0; j<Col; j++)
                board[i][j] = sc.nextInt();

        Sr = sc.nextInt();
        Sc = sc.nextInt();

        //가로줄
        for(int i=Sc; i>=0; i--){
            if(board[Sr][i] ==2) break;
            board[Sr][i] = 1;
        }
        for(int i=Sc+1; i<Col; i++){
            if(board[Sr][i] ==2) break;
            board[Sr][i] = 1;
        }
        //세로줄
        for(int i=Sr; i>=0; i--){
            if(board[i][Sc] ==2) break;
            board[i][Sc] = 1;
        }
        for(int i=Sr+1; i<Row; i++){
            if(board[i][Sc] ==2) break;
            board[i][Sc] = 1;
        }
        // 십자가 출력.
        for(int i=0; i<Row; i++) {
            for (int j = 0; j < Col; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        return;
    }

}

import java.util.*;
public class MultiArray {

    public static void main(String[] args) {

        //int[][]board = new int[4][5];
        int[][] board = {{1,2,3,4,5},
                {1,3,4,3,2},
                {3,4,1,2,4},
                {1,2,4,1,2}};
        int row = board.length;
        int col = board[0].length;
        System.out.println("row: "+row+ " col: "+col);
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                System.out.print(board[i][j]+" ");
            }
            //System.out.print(board[i][0]);
            System.out.println();
        }

        return ;
    }
}

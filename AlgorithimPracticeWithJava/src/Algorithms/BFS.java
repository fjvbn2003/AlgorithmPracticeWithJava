package Algorithms;
import java.util.*;
// TODO BFS 
public class BFS {
    public static void main(String[] args) {
        int[][] arr  = {{1,4,2},{4,2,1},{2,3,4}};

        Arrays.sort(arr, (o1, o2)-> o1[0]-o2[0]);
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}

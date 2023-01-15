import java.util.*;
import java.io.File;

class BOJ17780{
    static int N;
    static int K;
    static int[][] map;
    static ArrayList<ArrayList<ArrayList<Integer>>> arrays;
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(new File("input.txt"));
        N = sc.nextInt();
        K = sc.nextInt();
        map = new int[N][N];
        
        for(int i=0; i<N ; i++){
            for(int j=0; j<N ; j++){
                map[i][j] = sc.nextInt();
            }
        }
        arrays = new ArrayList<>(N);
        for(int i=0; i<N ; i++){
            arrays.add(new ArrayList<ArrayList<Integer>>(N));
            for(int j=0; i<N ; j++){
                arrays.get(i).add(new ArrayList<Integer>());
            }
        }

    }

}
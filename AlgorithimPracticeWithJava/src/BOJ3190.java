import java.io.*;
import java.util.*;

public class BOJ3190 {
    static int N,K,L;
    static int[][] array;
    static int[][] direction = {{0,1},{1,0},{0,-1},{-1,0}}; // 우, 하, 좌, 상
    static class Pair{
        int y, x;
        Pair(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    static ArrayList<Pair> apples;
    static ArrayList<Pair> turns;
    static class Snake{
        LinkedList<Pair> body;
        int dir;
        Snake(){
            this.body = new LinkedList<Pair>();
            this.dir = 0;
        }
    }   

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("input.txt"));
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        array = new int[N][N];
        K = sc.nextInt();
        apples = new ArrayList<Pair>();
        turns = new ArrayList<Pair>();
        Snake mysnake = new Snake();
        for(int i=0; i<K ; i++){
            int y = sc.nextInt();
            int x = sc.nextInt();
            apples.add(new Pair(y, x));
            array[y][x] = 2;
        }
        L = sc.nextInt();
        for(int i=0; i<L; i++){
            int X = sc.nextInt();
            char C = sc.next().charAt(0);
            // System.out.println(X);
            turns.add(new Pair(X, (C == 'L')? 0: 1 ));
        }
    
        // for(int i=0; i<K ; i++){
        //     System.out.println(String.format("%d, %d", apples.get(i).y , apples.get(i).x ));  
        // }
        // for(int i=0; i<L ; i++){
        //     System.out.println(String.format("%d, %d", turns.get(i).y , turns.get(i).x ));  
        // }
    }
}

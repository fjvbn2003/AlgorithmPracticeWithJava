package BOJ;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BOJ1167 {
    static int V;
    static class Node {
        int node;
        int weight;
        public Node(int _node, int _weight){
            this.node = _node;
            this.weight = _weight;
        }
    }
    static int max_length = -1;
    static int max_length_node = -1;
    static int[] visited;
    static ArrayList<ArrayList<Node>> Tree;
    //return max node
    static void dfs(int node, int leng){
        if(max_length <= leng){
            max_length = leng;
            max_length_node = node;
        }
        for(Node i : Tree.get(node)){
            if(visited[i.node]==0){
                visited[i.node] = 1;
                dfs(i.node, leng+i.weight);
            }
        }
        return;
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("AlgorithimPracticeWithJava/src/resources/input.txt"));
        Scanner sc = new Scanner(System.in);
        Tree = new ArrayList<ArrayList<Node>>();
        V = sc.nextInt();
        for(int i=0; i<V+1; i++){
            Tree.add(new ArrayList<Node>());
        }
        for(int i=0; i<V; i++){
            int from = sc.nextInt();
            //System.out.println("from "+from);
            while(true){
                int to = sc.nextInt();
                //System.out.println("to "+to);
                if(to == -1) break;
                int weight = sc.nextInt();
                Tree.get(from).add(new Node(to,weight));
                Tree.get(to).add(new Node(from,weight));
            }
        }
        visited = new int[V+1];
        visited[1] = 1;
        dfs(1, 0);

        visited = new int [V+1];
        visited[max_length_node] = 1;
        dfs(max_length_node, 0);
        System.out.println(max_length);
    }
}

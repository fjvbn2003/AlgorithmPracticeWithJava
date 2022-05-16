import java.io.FileInputStream;
import java.util.*;

public class BOJ15591 {
    static class Node{
        int node;
        int weight;
        public Node(int _node, int _weight){
            this.node = _node;
            this.weight = _weight;
        }
    }
    static int video_refer_count(int k, int v, ArrayList<ArrayList<Node>> graph, int N){
        //System.out.println(System.identityHashCode(graph));
        int [] visited =  new int[N+1];
        int count = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(v);
        visited[v] = 1;
        while(!q.isEmpty()){
            int current = q.poll();

            for(int i=0;i< graph.get(current).size(); i++){
                int weight = graph.get(current).get(i).weight;
                int node = graph.get(current).get(i).node;
                if(weight>=k && visited[node]==0 ){
                    q.add(node);
                    visited[node] = 1;
                    count++;
                }
                //System.out.println(count);
            }

        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Q = sc.nextInt();
        ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
        for(int i=0; i<N+1; i++)
                graph.add(new ArrayList<Node>());
        //System.out.println(System.identityHashCode(graph));
        for(int i=0; i<N-1; i++){
            int p = sc.nextInt();
            int q = sc.nextInt();
            int r = sc.nextInt();
            graph.get(p).add(new Node(q, r));
            graph.get(q).add(new Node(p, r));
        }


        for(int i=0; i<Q; i++){
            int k = sc.nextInt();
            int v = sc.nextInt();
            int answer  = video_refer_count(k, v, graph, N);
            System.out.println(answer);
        }

        //for debugging
//        for(int i=0; i<graph.size(); i++){
//            for(int j=0;j<graph.get(i).size(); j++){
//                System.out.print(graph.get(i).get(j).node+" ");
//            }
//            System.out.println();
//        }
    }
}

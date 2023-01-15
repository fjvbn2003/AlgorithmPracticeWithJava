package Algorithms;
import java.util.*;
public class Dijkstra {
/*
    다익스트라알고리즘.
    - 매 선택에서 가까운 노드부터 탐색.
    - 음의 가중치는 허용하지 않음.

    Dynamic Programming.
    - 새로운 노드까지의 최단 경로를 구하기 위해서 이전에 계산한 결과를 사용.

    증명: 최단 경로를 구성하는 부분 경로도 최단 경로이다.-> 최적부분구조
 */
    static final int INF = 1234567890;
    static final int MAX_N = 10;
    static int N, E;
    static int[][] Graph = new int[MAX_N][MAX_N];
    static int[] Dist = new int[MAX_N];
    static int[] Prev = new int[MAX_N];
    static void dijkstra(int src){
        // 오름차순으로 priority queue를 운영한다.
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0]-b[0]);
        boolean[] visited = new boolean[MAX_N];
        for(int i=0; i<N; i++){
            Dist[i] = INF;
            Prev[i] = -1;
        }
        // 시작점의 거리 + 위치를 우선순위 큐에 삽입.
        Dist[src] = 0;
        pq.add(new int[]{0, src});

        while(!pq.isEmpty()) {
            int[] curr  = pq.poll();
            int u = curr[1];
            if(visited[u]) continue;

            visited[u] = true;
            for(int v=0; v<N; v++){
                if(Dist[v]> Dist[u]+Graph[u][v]){
                    Prev[v] = u;
                    Dist[v] = Dist[u]+Graph[u][v];
                    pq.add(new int[] {Dist[v], v});
                }
            }

        }
        return;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        E = sc.nextInt();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(i==j) Graph[i][j] = 0;
                else Graph[i][j] = INF;
            }
        }
        for(int i=0; i<E; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            int cost = sc.nextInt();
            Graph[u][v] = Graph[v][u] = cost;
        }
        dijkstra(0);
        for(int i=0; i<N; i++){
            System.out.print(Dist[i]+" ");
        }
        return ;
    }
}

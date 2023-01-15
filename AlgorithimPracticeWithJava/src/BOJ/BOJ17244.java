package BOJ;
import java.util.*;
public class BOJ17244 {
    static int N, M;
    static int ans=12345678;
    static boolean[] visited;
    static ArrayList<int[]> tmp;
    static int []start = {0,0};
    static int []exit = {0,0};
    static ArrayList<int[]> arrayList;
    static int[][] graph;

    static void permute(int cnt, int array_size){
        // 거리 계산
        int cand = 0;
        if(cnt>=array_size){
            //System.out.println("hi");
            // start -> X1 ->X2... Xn -> exit
            int from_r = start[0];
            int from_c = start[1];
            for(int i=0; i<tmp.size(); i++){
                int to_r = tmp.get(i)[0];
                int to_c = tmp.get(i)[1];
                cand += graph[from_r*N+from_c][to_r*N + to_c];
                from_r = to_r;
                from_c = to_c;
            }
            cand += graph[from_r*N+from_c][exit[0]*N+exit[1]];
            ans = Math.min(cand, ans);
            return;
        }

        for(int i=0; i<array_size; i++){
            if(visited[i]== false){
                visited[i] = true;
                tmp.add(arrayList.get(i));
                permute(cnt+1, array_size);
                visited[i] = false;
                tmp.remove(tmp.size()-1);
            }
        }
        return;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        tmp = new ArrayList<int[]>();
        N = sc.nextInt();
        M = sc.nextInt();
        arrayList = new ArrayList<int[]>();
        char[][] arr = new char[M][N];
        graph = new int[M*N][M*N];


        for(int i=0; i<N*M; i++){
            for(int j=0; j<N*M; j++){
                graph[i][j] = 12345678;
            }
        }
        for(int i=0; i<N*M; i++){
            graph[i][i] = 0;
        }

        for (int i = 0; i < M; i++) {
            String s = sc.next();
            for (int j = 0; j < N; j++) {
                arr[i][j] = s.charAt(j);
                if(arr[i][j]=='S'){
                    start[0] = i;
                    start[1] = j;
                }else if(arr[i][j]=='E'){
                    exit[0] = i;
                    exit[1] = j;
                }else if(arr[i][j] != '#' && arr[i][j] != '.'){
                    // 물건들.
                    arrayList.add(new int[]{i, j});
                }

            }
        }
        //System.out.println(arr.toString());
        int [][]D =  {{-1,0},{1,0},{0,1},{0,-1}};
        // 그래프 생성하기.
        for(int i=0; i<M*N; i++) {
            int r = i/N;
            int c = i%N;
            if(arr[r][c]=='#') continue;
            for(int j=0; j<4; j++){
                int nr = r+D[j][0];
                int nc = c+D[j][1];
                if(nr<0 || nr>=M || nc<0 || nc>=N || arr[nr][nc] =='#') continue;
                graph[r*N+c][nr*N+nc] = 1;
                graph[nr*N+nc ][r*N+c] = 1;
                //System.out.println("연결: r:"+r+" c:"+c+" nr:"+nr+" nc:"+nc);
            }
        }


        //플로이드 워셜 알고리즘
        for(int k=0; k<N*M; k++){
            for(int i=0; i<N*M; i++){
                for(int j=0; j<N*M; j++){
                    graph[i][j] = Math.min(graph[i][j], graph[i][k]+graph[k][j]);
                }
            }
        }
        // 바로 가면 된다.
        if(arrayList.size()==0){
            System.out.println(graph[start[0]*N+start[1]][exit[0]*N+exit[1]]);
            return;
        }

        // S에서 시작해서 E로 가야함..
        // S -> X1 ->X2 -> X3 ... Xn ->E
        visited = new boolean[arrayList.size()];
        permute(0, arrayList.size());
        System.out.println(ans);



        // for debuuging
//        for(int i=0; i<arrayList.size(); i++){
//            System.out.println( arrayList.get(i)[0]+" "+arrayList.get(i)[1]);
//        }
//        // for debugging
//        for(int i=0; i<N*M; i++){
//            for(int j=0; j<N*M; j++){
//                if(graph[i][j] !=12345678 && graph[i][j] !=0){
//                    int fr = i/N;
//                    int fc = i%N;
//                    int tr = j/N;
//                    int tc = j%N;
//                    System.out.println("from: "+fr+" "+fc+ " to: "+ tr+" "+tc+" dist: "+graph[i][j]);
//                }
//            }
//        }
        //System.out.println("minimum _ dist 1,5 ~ 5,5" + Integer.toString(graph[1*6+5][5*6+5]));


        //System.out.println(arr.toString());
//        for(int i=0; i<M; i++) {
//            for (int j = 0; j < N; j++) {
//                System.out.print(arr[i][j]+" ");
//            }
//            System.out.println();
//        }


    }

}

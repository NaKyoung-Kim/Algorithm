import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static List<List<Integer>> graph;
    static int[] parent;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N-1 ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int vtx1 = Integer.parseInt(st.nextToken());
            int vtx2 = Integer.parseInt(st.nextToken());
            graph.get(vtx1).add(vtx2);
            graph.get(vtx2).add(vtx1);
        }

        StringBuilder sb = new StringBuilder();
        
        parent = new int[N+1];
        visited = new boolean[N+1];
        dfs(1);

        for (int i = 2; i < N+1; i++) sb.append(parent[i]).append("\n");
        System.out.println(sb);
    }

    static void dfs(int node) {
        visited[node] = true;
        for (int next : graph.get(node)) {
            if (!visited[next]) {
                parent[next] = node;
                dfs(next);
            }
        }
    }

}

import java.io.*;
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main
{
	public static void main(String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 도시의 개수
        int M = Integer.parseInt(st.nextToken()); // 도로의 개수
        int K = Integer.parseInt(st.nextToken()); // 거리 정보
        int X = Integer.parseInt(st.nextToken()); // 출발 도시의 번호

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N+1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph.get(A).add(B);
        }

        // X부터 BFS
        int[] d_from_X = new int[N+1];
        for (int i = 0; i < N+1; i++) {
            d_from_X[i] = -1;
        }
        bfs(graph, X, d_from_X);

        List<Integer> distance_K = new ArrayList<>();

        for (int i = 0; i < N+1; i++) {
            if (d_from_X[i] == K) {
                distance_K.add(i);
            }
        }
        if (distance_K.isEmpty()) {
            System.out.println(-1);
        } else {
            for (int city : distance_K) {
                System.out.println(city);
            }
        }

	}

    static void bfs(List<List<Integer>> graph, int start, int[] d_from_X) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        d_from_X[start] = 0;

        while(!q.isEmpty()) {
            int current = q.poll();
            for (int next: graph.get(current)) {
                if (d_from_X[next] == -1) {
                    d_from_X[next] = d_from_X[current] + 1;
                    q.add(next);
                }
            }
        }
    }
}

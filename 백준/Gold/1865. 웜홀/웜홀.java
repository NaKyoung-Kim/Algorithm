import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int from, to, cost;
        
        Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        while (TC-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 지점
            int M = Integer.parseInt(st.nextToken()); // 도로
            int W = Integer.parseInt(st.nextToken()); // 웜홀
            
            List<Edge> edges = new ArrayList<>();
            
            // 도로 정보
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                
                edges.add(new Edge(S, E, T));
                edges.add(new Edge(E, S, T)); // 양방향
            }
            
            // 웜홀 정보 (단방향, 음수 가중치)
            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                
                edges.add(new Edge(S, E, -T)); // 시간이 줄어들므로 음수
            }
            
            // 벨만-포드로 음수 사이클 검출
            if (hasNegativeCycle(N, edges)) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        
        System.out.print(sb);
    }
    
    static boolean hasNegativeCycle(int N, List<Edge> edges) {
        long[] dist = new long[N + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        
        // 모든 정점을 시작점으로 설정
        for (int i = 1; i <= N; i++) {
            dist[i] = 0;
        }
        
        // N-1번 간선 완화
        for (int i = 0; i < N - 1; i++) {
            for (Edge edge : edges) {
                if (dist[edge.from] != Long.MAX_VALUE && 
                    dist[edge.from] + edge.cost < dist[edge.to]) {
                    dist[edge.to] = dist[edge.from] + edge.cost;
                }
            }
        }
        
        // N번째 완화에서 업데이트가 일어나면 음수 사이클 존재
        for (Edge edge : edges) {
            if (dist[edge.from] != Long.MAX_VALUE && 
                dist[edge.from] + edge.cost < dist[edge.to]) {
                return true; // 음수 사이클 발견
            }
        }
        
        return false;
    }
}
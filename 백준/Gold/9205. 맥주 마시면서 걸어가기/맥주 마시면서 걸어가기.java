import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Pos {
        int x, y;
        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            List<Pos> posList = new ArrayList<>();

            for (int j = 0; j < N + 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                posList.add(new Pos(x, y));
            }

            List<List<Integer>> graph = new ArrayList<>();
            for (int j = 0; j < N + 2; j++) {
                graph.add(new ArrayList<>());
            }

            for (int j = 0; j < N + 2; j++) {
                for (int k = 0; k < N + 2; k++) {
                    if (distance(posList.get(j), posList.get(k)) <= 1000) {
                        graph.get(j).add(k);
                        graph.get(k).add(j);
                    }
                }
            }

            if (bfs(graph, N)) {
                System.out.println("happy");
            } else {
                System.out.println("sad");
            }

        }
        
    }

    static int distance(Pos pos1, Pos pos2) {
        return Math.abs(pos1.x - pos2.x) + Math.abs(pos1.y - pos2.y);
    }

    static boolean bfs(List<List<Integer>> graph, int N) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N+2];

        q.offer(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            int current = q.poll();
            if (current == N + 1) {
                return true;
            }
            for (int next : graph.get(current)) {
                if(!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
        
        return false;
    }

}

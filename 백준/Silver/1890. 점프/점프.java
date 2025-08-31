import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[][] board = new int[N][N];
        long[][] path = new long[N][N];
        path[0][0] = 1;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 0) continue;  // 도착점
                if (path[i][j] == 0) continue;  // 도달할 수 없는 칸
                
                int jump = board[i][j];

                if (i + jump < N) {
                    path[i+jump][j] += path[i][j];
                }
                if (j + jump < N) {
                    path[i][j+jump] += path[i][j];
                }
            }
        }
        System.out.println(path[N-1][N-1]);
    }
}

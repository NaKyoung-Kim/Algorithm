import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] block = new int[N][M];

        // 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                block[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        // 윗면, 아랫면 (항상 존재)
        result += N * M * 2;

        // 4방향: 상, 하, 좌, 우
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int d = 0; d < 4; d++) {
                    int ni = i + dr[d];
                    int nj = j + dc[d];
                    int neighbor = 0;
                    if (ni >= 0 && ni < N && nj >= 0 && nj < M) {
                        neighbor = block[ni][nj];
                    }
                    result += Math.max(block[i][j] - neighbor, 0);
                }
            }
        }

        System.out.println(result);
    }
}

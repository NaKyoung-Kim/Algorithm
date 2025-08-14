import java.io.*;

import javax.swing.SpinnerDateModel;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());
        
        int[][] snale = new int[N][N];

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int dir = 0;
        
        int x = N/2, y = N/2;

        int num = 1;
        snale[x][y] = num;

        int target_x = x, target_y = y;

        int depth = 0;
        while ( N * N > num ) {
            depth++;
            
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < depth; j++) {
                    if (num >= N*N) break;
                    x += dx[dir];
                    y += dy[dir];
                    num++;
                    snale[x][y] = num;

                    if (num == target) {
                        target_x = x;
                        target_y = y;
                    }
                }
                dir = (dir + 1) % 4;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N ; j++) {
                sb.append(snale[i][j]).append(" ");
            }
            sb.append("\n");
        }
        sb.append((target_x+1) + " " + (target_y+1));
        System.out.println(sb);
    }
}

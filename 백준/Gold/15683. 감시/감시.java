import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] office;
    static List<CCTV> cctvs = new ArrayList<>();
    static int minBlindSpot = Integer.MAX_VALUE;
    static int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int[][][] cctvDir = {
        {}, 
        {{0}, {1}, {2}, {3}}, 
        {{0, 2}, {1, 3}}, 
        {{0, 1}, {1, 2}, {2, 3}, {3, 0}}, 
        {{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}}, 
        {{0, 1, 2, 3}}
    };

    static class CCTV {
        int x, y, type;
        CCTV(int x, int y, int type) {
            this.x = x; this.y = y; this.type = type;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        office = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                office[i][j] = Integer.parseInt(st.nextToken());
                if (1 <= office[i][j] && office[i][j] <= 5) {
                    cctvs.add(new CCTV(i, j, office[i][j]));
                }
            }
        }

        dfs(0, office);
        System.out.println(minBlindSpot);
    }

    static void dfs(int depth, int[][] map) {
        if (depth == cctvs.size()) {
            int count = countBlindSpots(map);
            minBlindSpot = Math.min(minBlindSpot, count);
            return;
        }
        CCTV cctv = cctvs.get(depth);
        int[][] dirSet = cctvDir[cctv.type];
        for (int[] dirs : dirSet) {
            int[][] temp = copyMap(map);
            for (int d : dirs) {
                watch(temp, cctv.x, cctv.y, d);
            }
            dfs(depth + 1, temp);
        }
    }

    static void watch(int[][] map, int x, int y, int dir) {
        int nx = x;
        int ny = y;
        while (true) {
            nx += directions[dir][0];
            ny += directions[dir][1];
            if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == 6) break;
            if (map[nx][ny] == 0) {
                map[nx][ny] = -1;
            }
        }
    }

    static int countBlindSpots(int[][] map) {
        int count = 0;
        for (int[] row : map) {
            for (int cell : row) {
                if (cell == 0) count++;
            }
        }
        return count;
    }

    static int[][] copyMap(int[][] map) {
        int[][] copy = new int[N][M];
        for (int i = 0; i < N; i++) {
            copy[i] = map[i].clone();
        }
        return copy;
    }
}

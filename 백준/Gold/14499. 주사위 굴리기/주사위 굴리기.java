import java.io.*;

public class Main
{
    // 주사위 현재상태(순서대로 위, 아래, 동, 서, 남, 북)
    static int[] dice;

    // 순서대로 동(1) 서(2) 북(3) 남(4)
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static int[][] map;

	public static void main(String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	    int[] info = toIntArray(5, br.readLine()); // 초기정보
        dice = new int[]{0, 0, 0, 0, 0, 0}; // 주사위 초기화

        int N = info[0], M = info[1], x = info[2], y = info[3], K = info[4];
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = toIntArray(M, br.readLine());
        }

        int[] commands;
        commands = toIntArray(K, br.readLine());

        for (int command : commands) {
            int nx = x + dx[command-1], ny = y + dy[command-1];
            if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                dice(nx, ny, command);
                System.out.println(dice[0]);
                x = nx;
                y = ny;
            }
        }
	}

    static int[] toIntArray(int N, String input) {
        int[] result = new int[N];
        String[] parts = input.split(" ");

        for (int i = 0; i < N; i++) {
            result[i] = Integer.parseInt(parts[i]);
        }
        return result;
    }

    static void dice(int x, int y, int command) {
        int temp;
        // command: 동(1) 서(2) 남(3) 북(4)
        // (dice: 0위, 1아래, 2동, 3서, 4남, 5북)
        switch (command) {
            case 1:
                temp = dice[0];
                dice[0] = dice[3];
                dice[3] = dice[1];
                dice[1] = dice[2];
                dice[2] = temp;
                break;
            case 2:
                temp = dice[0];
                dice[0] = dice[2];
                dice[2] = dice[1];
                dice[1] = dice[3];
                dice[3] = temp;
                break;
            case 3:
                temp = dice[0];
                dice[0] = dice[5];
                dice[5] = dice[1];
                dice[1] = dice[4];
                dice[4] = temp;
                break;
            case 4:
                temp = dice[0];
                dice[0] = dice[4];
                dice[4] = dice[1];
                dice[1] = dice[5];
                dice[5] = temp;
                break;
        }

        if (map[x][y] == 0) {
            map[x][y] = dice[1];
        } else {
            dice[1] = map[x][y];
            map[x][y] = 0;
        }
    }

}

import java.io.*;

public class Main {
    static int n;
    static char[][] board;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new char[n][n];

        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }

        // 모든 인접쌍 교환
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 오른쪽 교환
                if (j + 1 < n) {
                    change(i, j, i, j + 1);
                    check();
                    change(i, j, i, j + 1);
                }
                // 아래쪽 교환
                if (i + 1 < n) {
                    change(i, j, i + 1, j);
                    check();
                    change(i, j, i + 1, j);
                }
            }
        }

        System.out.println(answer);
    }

    // 보드의 최대 연속 부분의 길이 체크
    static void check() {
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 1; j < n; j++) {
                if (board[i][j] == board[i][j - 1]) cnt++;
                else cnt = 1;
                if (cnt > answer) answer = cnt;
            }
        }
        for (int j = 0; j < n; j++) {
            int cnt = 1;
            for (int i = 1; i < n; i++) {
                if (board[i][j] == board[i - 1][j]) cnt++;
                else cnt = 1;
                if (cnt > answer) answer = cnt;
            }
        }
    }

    static void change(int x1, int y1, int x2, int y2) {
        char tmp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = tmp;
    }
}

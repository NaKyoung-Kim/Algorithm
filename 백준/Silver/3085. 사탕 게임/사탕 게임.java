import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] board = new char[N][N];

        // board 정보 입력
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        int maxCnt = countCandy(board);

        // board 정보 바꿔가면서 countCandy
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N-1; j++) {
                char swap1 = board[i][j];
                char swap2 = board[i][j+1];
                board[i][j] = swap2;
                board[i][j+1] = swap1;

                int tempCnt = countCandy(board);
                maxCnt = maxCnt > tempCnt ? maxCnt : tempCnt;

                board[i][j] = swap1;
                board[i][j+1] = swap2;
            }
        }
        for (int i = 0; i < N-1; i++) {
            for (int j = 0; j < N; j++) {
                char swap1 = board[i][j];
                char swap2 = board[i+1][j];

                board[i][j] = swap2;
                board[i+1][j] = swap1;

                int tempCnt = countCandy(board);
                maxCnt = maxCnt > tempCnt ? maxCnt : tempCnt;

                board[i][j] = swap1;
                board[i+1][j] = swap2;
            }
        }
        System.out.println(maxCnt);
    }

    /**
     * 입력받은 board에서 사탕의 최대 개수 return
     * @param board
     * @return
     */
    static int countCandy(char[][] board) {
        int N = board.length;
        int maxCnt = 0;

        for (int i = 0; i < N; i++) {
            int temp = 1;
            for (int j = 1; j < N; j++) {
                if (board[i][j] == board[i][j-1]) {
                    temp += 1;
                    maxCnt = maxCnt > temp ? maxCnt : temp;
                } 
                else temp = 1;
            }
            
        }

        for (int j = 0; j < N; j++) {
            int temp = 1;
            for (int i = 1; i < N; i++) {
                if (board[i][j] == board[i-1][j]) {
                    temp += 1;
                    maxCnt = maxCnt > temp ? maxCnt : temp;
                } 
                else temp = 1;
            }
            maxCnt = maxCnt > temp ? maxCnt : temp;
        }
        return maxCnt;
    }
    
}
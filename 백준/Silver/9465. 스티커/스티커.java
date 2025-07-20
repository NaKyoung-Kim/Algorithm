import java.io.*;
import java.util.StringTokenizer;

public class Main
{
	public static void main(String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] stickers = new int[2][n];

            for (int j = 0; j < 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                
                for (int k = 0; k < n; k++) {
                    stickers[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] score = new int[2][n];
            dp(stickers, score, n);
            System.out.println(Math.max(score[0][n-1], score[1][n-1]));
        }

	}

    static void dp(int[][] stickers, int[][] score, int n) {
        for (int i = 0 ; i < n; i++) {
            if (i == 0) {
                score[0][i] = stickers[0][i];
                score[1][i] = stickers[1][i];
            } else if (i == 1) {
                score[0][i] = stickers[0][i] + stickers[1][i-1];
                score[1][i] = stickers[1][i] + stickers[0][i-1];
            } else if (i >= 2) {
                score[0][i] = Math.max(score[1][i-1], score[1][i-2]) + stickers[0][i];
                score[1][i] = Math.max(score[0][i-1], score[0][i-2]) + stickers[1][i];
            }
        }
    }
}

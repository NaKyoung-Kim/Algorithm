import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static long min = Long.MAX_VALUE, max = Long.MIN_VALUE;
    static int N;
    static int[] op, An;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        An = new int[N];
        op = new int[4]; // 순서대로 + - * /
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            An[i] = Integer.parseInt(st.nextToken());
        }

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st2.nextToken());
        }

        dfs(1, An[0]); // 인덱스 1부터 계산 시작
        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int index, long currentResult) {
        if (index == N) {
            max = Math.max(max, currentResult);
            min = Math.min(min, currentResult);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (op[i] > 0) {
                op[i]--;
                long nextResult = calculate(currentResult, An[index], i);
                dfs(index + 1, nextResult);
                op[i]++;
            }
        }
    }

    static long calculate(long a, long b, int op) {
        switch (op) {
            case 0:
                return a + b;
            case 1:
                return a - b;
            case 2:
                return a * b;
            case 3:
                if (b != 0) {
                    if (a < 0) {
                        return (a * (-1) / b) * (-1);
                    } else {
                        return a / b;
                    }
                }
            default:
                throw new IllegalArgumentException();

        }
    }
}

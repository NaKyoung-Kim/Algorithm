import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken()); // 가지고 있는 랜선 개수
        int N = Integer.parseInt(st.nextToken()); // 필요한 랜선 개수

        int[] cable = new int[K];

        // 2분탐색: 가지고 있는 랜선 중 가장 긴 선의 길이를 end 값으로 잡음
        long start = 1, end = 1; // 0으로 두면 ArithmeticException 발생할 가능성 있음
        long maxLen = 0;

        for (int i = 0; i < K; i++) {
            cable[i] = Integer.parseInt(br.readLine());
            if (end < cable[i]) {
                end = cable[i];
            }
        }

        long targetLength = 0;
        while (start <= end) {
            targetLength = (start + end) / 2;
            if (calculateCutCnt(cable, targetLength) >= N) {
                maxLen = targetLength;
                start = targetLength + 1;
            } else {
                end = targetLength - 1;
            }
        }
        System.out.println(maxLen);

    }

    public static long calculateCutCnt(int[] cableList, long cutLen) {
        int cutCnt = 0;
        for (int cableLen : cableList) {
            cutCnt += cableLen / cutLen;
        }
        return cutCnt;
    }

}

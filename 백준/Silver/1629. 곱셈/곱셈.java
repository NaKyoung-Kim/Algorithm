import java.io.*;
import java.util.*;

public class Main {
    static long A, B, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        System.out.println(pow(A, B));
    }

    static long pow(long a, long b) {
        long result = 1;
        a = a % C;

        while (b > 0) {
            if ((b & 1) == 1) { // b가 홀수일 때
                result = (result * a) % C;
            }
            a = (a * a) % C;
            b >>= 1; // b를 절반으로 줄임
        }
        return result;
    }
}

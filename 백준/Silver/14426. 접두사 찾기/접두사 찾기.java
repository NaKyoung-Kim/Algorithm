import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }
        Arrays.sort(arr);

        int cnt = 0;
        for (int i = 0; i < M; i++) {
            String temp = br.readLine();

            int idx = Arrays.binarySearch(arr, temp);
            if (idx < 0) {
                idx = -(idx+1);
            }
            if (idx < N && arr[idx].startsWith(temp)) cnt++;
        }
        System.out.println(cnt);
    }
}